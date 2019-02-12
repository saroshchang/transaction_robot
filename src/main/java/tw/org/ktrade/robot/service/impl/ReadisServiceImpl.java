package tw.org.ktrade.robot.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.etchain.model.infoormation.MarketInfo;
import com.etchain.model.infoormation.MarketInfoDay;
import com.etchain.model.infoormation.MarketInfoHour;
import com.etchain.model.infoormation.MarketInfoMinutes;
import com.etchain.model.infoormation.MarketInfoSecond;
import com.etchain.model.infoormation.MarketInfoUtils;

import tw.org.ktrade.robot.common.SerializeUtils;
import tw.org.ktrade.robot.context.KtradeContext;
import tw.org.ktrade.robot.context.KtradeContextKey;
import tw.org.ktrade.robot.dao.MarketInfoDayRepository;
import tw.org.ktrade.robot.dao.MarketInfoHourRepository;
import tw.org.ktrade.robot.dao.MarketInfoMinutesRepository;
import tw.org.ktrade.robot.dao.MarketInfoSecondRepository;
import tw.org.ktrade.robot.po.Range;
import tw.org.ktrade.robot.po.TradeLog;
import tw.org.ktrade.robot.service.ReadisService;
import tw.org.ktrade.robot.utils.JedisUtilnew;

@Service
public class ReadisServiceImpl implements ReadisService {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	MarketInfoSecondRepository<MarketInfoSecond, Integer> marketInfoSecondRepository;
	@Autowired
	MarketInfoMinutesRepository<MarketInfoMinutes, Integer> marketInfoMinutesRepository;
	@Autowired
	MarketInfoHourRepository<MarketInfoHour, Integer> marketInfoHourRepository;
	@Autowired
	MarketInfoDayRepository<MarketInfoDay, Integer> marketInfoDayRepository;
	@Resource
	JedisUtilnew jedisUtil;
	@Autowired
	MongoTemplate mongoTemplate;

	/**
	 * 成交完成校驗
	 * 
	 * @param buyTradeLog
	 * @param sellTradeLog
	 */
	@Override
	public void marketPush(TradeLog buyTradeLog, String coinName, BigDecimal coinPrice) {

		try {
			marketVerify(buyTradeLog, 1, buyTradeLog.getMarket());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	/**
	 *
	 *
	 * 1,將行情數據存入redis 1.1:獲取當前時間的行情類型key在redis中是否存在，如果存在則更新行情數據，不存在則添加行情數據
	 * 1.2:添加行情數據時判斷是否是下一個父級行情 2,將行情數據存入數據庫
	 * 
	 * @param type
	 *            行情類型：1:秒；2:分鐘；3：小時；4：天；5：月;6:年
	 */
	@Override
	public void marketVerify(TradeLog buyTradeLog, Integer type, String market) {
		/**
		 * 獲取當前時間的行情類型key在redis中是否存在，如果存在則更新行情數據，不存在則添加行情數據
		 */
		// list緩存集合
		JedisUtilnew.Lists lists = jedisUtil.new Lists();
		// redis的key:交易對+行情類型
		String key = "ThreadLog_" + market + "_" + Range.getName(type);// ThreadLog_fto_eth_second
		// 獲取redis的key 查詢當前秒數有沒有數據

		String kineTime = MarketInfoUtils.getMarketInfoTime(type, new Date(buyTradeLog.getAddtime()));
		MarketInfo marketInfo = new MarketInfo();
		marketInfo.setDealTime(buyTradeLog.getAddtime());
		marketInfo.setFirstPrice(buyTradeLog.getPrice());
		marketInfo.setLastPrice(buyTradeLog.getPrice());
		marketInfo.setLowPrice(buyTradeLog.getPrice());
		marketInfo.setTopPrice(buyTradeLog.getPrice());
		marketInfo.setKineTime(kineTime);
		marketInfo.setCount(buyTradeLog.getNum());
		// 在當前緩存集合中新增
		lists.rpush(key.getBytes(), SerializeUtils.serialize(marketInfo));
		// 初始化當前交易對redis行情交易
		createMarketInfoRedis(market, marketInfo, type, buyTradeLog.getAddtime(), lists);
		// }
	}

	/**
	 * 根據行情類型存入不同的mongo表
	 * 
	 * @param marketInfo
	 * @param type
	 */
	@Override
	public void saveMarket(MarketInfo marketInfo, Integer type, String market) {
		switch (type) {
		case 1:
			MarketInfoSecond marketInfoSecond = new MarketInfoSecond(marketInfo);
			marketInfoSecond.setType(market);
			marketInfoSecondRepository.save(marketInfoSecond);
			break;
		case 2:
			MarketInfoMinutes marketInfoMinutes = new MarketInfoMinutes(marketInfo);
			marketInfoMinutes.setType(market);
			marketInfoMinutesRepository.save(marketInfoMinutes);
			break;
		case 3:
			MarketInfoHour marketInfoHour = new MarketInfoHour(marketInfo);
			marketInfoHour.setType(market);
			marketInfoHourRepository.save(marketInfoHour);
			break;
		case 4:
			MarketInfoDay marketInfoDay = new MarketInfoDay(marketInfo);
			marketInfoDay.setType(market);
			marketInfoDayRepository.save(marketInfoDay);
			break;
		default:
			break;
		}
	}

	/**
	 * 初始化redis緩存
	 * 
	 * @param marketInfo
	 * @param type
	 * @param addTime
	 * @param lists
	 */
	@Override
	public void createMarketInfoRedis(String market, MarketInfo marketInfo, Integer type, Long addTime,
			JedisUtilnew.Lists lists) {
		for (int i = 4; i > type; i--) {
			String key = "ThreadLog_" + market + "_" + Range.getName(i);
			MarketInfo parentMarketInfo = marketInfo;
			parentMarketInfo.setKineTime(MarketInfoUtils.getMarketInfoTime(i, new Date(addTime)));
			lists.rpushVar("111111111111", "123456789");
			lists.rpush(key.getBytes(), SerializeUtils.serialize(parentMarketInfo));
		}
	}

	/**
	 * redis 存儲當天的交易記錄
	 * 
	 * @param price 成交價
	 * @param num 交易數量
	 * @param type 交易對
	 */
	@Override
	public void saveExcRedis(double price, double num, String type) {

		JedisUtilnew.Strings valueOperations = jedisUtil.new Strings();

		String today = DateFormatUtils.format(new Date(), "yyyyMMdd");
		String high = valueOperations.get(today + "_" + type + "_high");
		String low = valueOperations.get(today + "_" + type + "_low");
		String count = valueOperations.get(today + "_" + type + "_count");
		count = count == null ? "0" : count;
		if (high == null || Double.valueOf(high) < price) {
			valueOperations.set(today + "_" + type + "_high", BigDecimal.valueOf(price).toPlainString());
		}
		if (low == null || Double.valueOf(low) > price) {
			valueOperations.set(today + "_" + type + "_low", BigDecimal.valueOf(price).toPlainString());
		}
		valueOperations.set(today + "_" + type + "_count",
				BigDecimal.valueOf(num).add(new BigDecimal(count)).stripTrailingZeros().toPlainString());
	}

	/**
	 * 更新行情數據
	 *
	 * @param symbol
	 *  交易對
	 */
	@Async
	@Override
	public void changeViewData(String symbol) {

		KtradeContext.getAttribute(KtradeContextKey.KTRADE_HIGH_MAP);

		JedisUtilnew.Strings valueOperations = jedisUtil.new Strings();
		String today = DateFormatUtils.format(new Date(), "yyyyMMdd");

		String tHigh = valueOperations.get(today + "_" + symbol + "_high");
		String count = valueOperations.get(today + "_" + symbol + "_count");
		String low = valueOperations.get(today + "_" + symbol + "_low");
		tHigh = tHigh == null ? "0" : tHigh;
		count = count == null ? "0" : count;
		low = low == null ? "0" : low;
		String change = "0";
		if (!"0".equals(tHigh)) {
			JedisUtilnew.Keys key = jedisUtil.new Keys();
			Set<String> keys = key.keys("*_" + symbol + "_high");
			List<String> keyList = new ArrayList<>(keys);
			if (!keyList.isEmpty()) {
				Collections.sort(keyList, new Comparator<String>() {
					@Override
					public int compare(String s1, String s2) {
						return s2.compareTo(s1);
					}
				});
				String lastKey = null;
				if (keyList.get(0).equals(today + "_" + symbol + "_high")) {
					if (keyList.size() > 1) {
						lastKey = keyList.get(1);
					}
				} else {
					lastKey = keyList.get(0);
				}
				if (lastKey != null) {
					String lastHighStr = valueOperations.get(lastKey); // 有記錄最後一天最高價
					BigDecimal yHigh = new BigDecimal(lastHighStr);
					if (!yHigh.equals(BigDecimal.ZERO)) {
						change = new BigDecimal(tHigh).subtract(yHigh).divide(yHigh, 4, BigDecimal.ROUND_HALF_EVEN)
								.multiply(BigDecimal.valueOf(100)).stripTrailingZeros().toPlainString();
					}
				}
			}
		}

		String price = "0";
		Query query = new Query();
		query.addCriteria(Criteria.where("market").is(symbol));
		query.with(new Sort(Sort.Direction.valueOf("DESC"), "addtime"));
		query.with(new PageRequest(0, 1));
		TradeLog tradeLogs = mongoTemplate.findOne(query, TradeLog.class);
		if (tradeLogs != null) {
			price = tradeLogs.getPrice().toPlainString();
		}
		((Map<String, String>) KtradeContext.getAttribute(KtradeContextKey.KTRADE_HIGH_MAP)).put(symbol, tHigh);
		((Map<String, String>) KtradeContext.getAttribute(KtradeContextKey.KTRADE_LOW_MAP)).put(symbol, low);
		((Map<String, String>) KtradeContext.getAttribute(KtradeContextKey.KTRADE_CHANGE_MAP)).put(symbol, change);
		((Map<String, String>) KtradeContext.getAttribute(KtradeContextKey.KTRADE_PRICE_MAP)).put(symbol, price);
		((Map<String, String>) KtradeContext.getAttribute(KtradeContextKey.KTRADE_COUNT_MAP)).put(symbol, count);
	}

}
