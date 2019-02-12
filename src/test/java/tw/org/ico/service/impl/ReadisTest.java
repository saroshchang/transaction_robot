package tw.org.ico.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.etchain.model.infoormation.MarketInfo;
import com.etchain.model.infoormation.MarketInfoDay;
import com.etchain.model.infoormation.MarketInfoHour;
import com.etchain.model.infoormation.MarketInfoMinutes;
import com.etchain.model.infoormation.MarketInfoSecond;
import com.etchain.model.infoormation.MarketInfoUtils;

import tw.org.ktrade.robot.Run;
import tw.org.ktrade.robot.common.SerializeUtils;
import tw.org.ktrade.robot.context.KtradeContext;
import tw.org.ktrade.robot.context.KtradeContextKey;
import tw.org.ktrade.robot.dao.MarketInfoDayRepository;
import tw.org.ktrade.robot.dao.MarketInfoHourRepository;
import tw.org.ktrade.robot.dao.MarketInfoMinutesRepository;
import tw.org.ktrade.robot.dao.MarketInfoSecondRepository;
import tw.org.ktrade.robot.po.Range;
import tw.org.ktrade.robot.po.TradeLog;
import tw.org.ktrade.robot.utils.JedisUtilnew;

//@RunWith(SpringJUnit4ClassRunner.class)
////指定我们SpringBoot工程的Application启动类
//@SpringApplicationConfiguration(classes = Run.class)
////由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
//@WebAppConfiguration
public class ReadisTest {

//	Logger logger = Logger.getLogger(this.getClass());
//
//	// @Autowired
//	// TradeLogService<TradeLog,Integer> tradeLogService;
//	// @Autowired
//	// MarketInfoController marketInfoController;
//	@Autowired
//	MarketInfoSecondRepository<MarketInfoSecond, Integer> marketInfoSecondRepository;
//	@Autowired
//	MarketInfoMinutesRepository<MarketInfoMinutes, Integer> marketInfoMinutesRepository;
//	@Autowired
//	MarketInfoHourRepository<MarketInfoHour, Integer> marketInfoHourRepository;
//	@Autowired
//	MarketInfoDayRepository<MarketInfoDay, Integer> marketInfoDayRepository;
//	@Resource
//	JedisUtilnew jedisUtil;
//	@Autowired
//	private MongoTemplate mongoTemplate;
//
//
//	/**
//	 * 成交完成校验
//	 * 
//	 * @param buyTradeLog
//	 * @param sellTradeLog
//	 */
//	@Test
//	public void marketPush() {
//		// TradeLog buyTradeLog, TradeLog sellTradeLog
//		try {
//			TradeLog buyTradeLog = this.buyTrade();
//			// 将成交数据插入数据库
//			// isSuccess = tradeLogService.createEntityDeal(buyTradeLog,sellTradeLog);
//
//			/*
//			 * 红利换算步骤： 1 交易成功后，计算买家基础币的币种和数量总和 2
//			 * 币种的数量换算成TWDT单位个数，记录levelDB将该用户的群主（邀请进来的userid）的当日TWDT交易量累加， 3 计算卖家购买的币种以及交易数量
//			 * 4 币种的数量换算成TWDT单位数，记录levelDB将该用户的群主（邀请进来的userid）的当日TWDT交易量累加 5
//			 * 最后通过定时机制，用平台账户，将每个群主的交易总量计算出红利，发配个相应的群主账户奖励
//			 */
//			// recodeBuyVol(buyTradeLog);
//			//
//			// recodeBuyVol(sellTradeLog);
//
//			// 处理秒级行情
//			marketVerify(buyTradeLog, 1, buyTradeLog.getMarket());
//			// 通知行情推送
//			// marketInfoController.marketPush(buyTradeLog,sellTradeLog);
//
//			// 处理行情, 2.0 TODO
////			saveExcRedis(buyTradeLog.getPrice().doubleValue(), buyTradeLog.getMum().doubleValue(),
////					buyTradeLog.getMarket());
//
//			// 修改系统存储的行情数据
//			//changeViewData(buyTradeLog.getMarket());
//
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//		// return isSuccess;
//	}
//
//	// public boolean createEntityDeal(TradeLog buyTradeLog, TradeLog sellTradeLog)
//	// {
//	// try {
//	// logger.debug("----插入买卖方成交记录----");
//	// //插入买方的成交记录 挂单交易成交记录更新 用户账户变更
//	// TradeLog buyTrade = tradeDao.queryById(buyTradeLog.getTradeId());
//	// tradeLogDao.createEntity(buyTradeLog);
//	// //更新买方账户
//	// updateDealTrade(buyTradeLog,buyTrade);
//	// userCoinService.updateUserCoinAccount(buyTradeLog,buyTrade);
//	//
//	// //插入卖方的成交记录 挂单交易成交记录更新 账户变更
//	// tradeLogDao.createEntity(sellTradeLog);
//	// Trade sellTrade = tradeDao.queryById(sellTradeLog.getTradeId());
//	// //更新卖方账户
//	// updateDealTrade(sellTradeLog,sellTrade);
//	// userCoinService.updateUserCoinAccount(sellTradeLog,sellTrade);
//	//
//	// } catch (Exception e) {
//	// logger.error("插入成交记录异常！",e);
//	// return false;
//	// }
//	// return true;
//	// }
//
//	/**
//	 *
//	 *
//	 * 1,将行情数据存入redis 1.1:获取当前时间的行情类型key在redis中是否存在，如果存在则更新行情数据，不存在则添加行情数据
//	 * 1.2:添加行情数据时判断是否是下一个父级行情 2,将行情数据存入数据库
//	 * 
//	 * @param type
//	 *            行情类型：1:秒；2:分钟；3：小时；4：天；5：月;6:年
//	 */
//	private void marketVerify(TradeLog buyTradeLog, Integer type, String market) {
//		/**
//		 * 获取当前时间的行情类型key在redis中是否存在，如果存在则更新行情数据，不存在则添加行情数据
//		 */
//		// list缓存集合
//		JedisUtilnew.Lists lists = jedisUtil.new Lists();
//		// redis的key:交易对+行情类型
//		String key = "ThreadLog_" + market + "_" + Range.getName(type);//ThreadLog_fto_eth_second
//		// 获取redis的key 查询当前秒数有没有数据
////		int llen = 0;
////		synchronized (this) {
////			llen = (int) lists.llen(key.getBytes());
////		}
////		int index = llen - 1;
////		if (llen > 0) {
////			// 获取最后一条
////			byte[] keyByte = lists.lindex(key.getBytes(), index);
////			// 当前交易(s)、当前类型最后一条（s)、当前级别(s)、当前级别的key、当前级别最后一个的index
////			parentQuotationVerify(buyTradeLog, keyByte, type, key, index);
////			// 行情缓存中只 保存1000条数据
////			if (llen > 3000) {
////				lists.lpop(key.getBytes());
////			}
////		} else {
//			String kineTime = MarketInfoUtils.getMarketInfoTime(type, new Date(buyTradeLog.getAddtime()));
//			MarketInfo marketInfo = new MarketInfo();
//			marketInfo.setDealTime(buyTradeLog.getAddtime());
//			marketInfo.setFirstPrice(buyTradeLog.getPrice());
//			marketInfo.setLastPrice(buyTradeLog.getPrice());
//			marketInfo.setLowPrice(buyTradeLog.getPrice());
//			marketInfo.setTopPrice(buyTradeLog.getPrice());
//			marketInfo.setKineTime(kineTime);
//			marketInfo.setCount(buyTradeLog.getNum());
//			// 在当前缓存集合中新增
//			lists.rpush(key.getBytes(), SerializeUtils.serialize(marketInfo));
//			// 初始化当前交易对redis行情交易
//			createMarketInfoRedis(market, marketInfo, type, buyTradeLog.getAddtime(), lists);
////		}
//	}
//
//	// 当前交易(s)、当前类型最后一条（s)、当前级别(s)、当前级别的key（s)、当前级别最后一个的index
//	private void parentQuotationVerify(TradeLog tradeLog, byte[] keyByte, Integer type, String key, int llen) {
//		List<byte[]> bytes1 = jedisUtil.new Lists().lrange("ThreadLog_fto_eth_second".getBytes(),0,1000);
//		// redis反序列化出实体对象
//		MarketInfo marketInfo = (MarketInfo) SerializeUtils.unserialize(bytes1.get(0));
//		// 处理当前行情数据
//		synchronized (this) {
//			// 当前级别最后一条、null、当前级别的key（s)、当前交易(s)、当前级别(s)、当前级别最后一个的index（s)
//			getMarketInfo(marketInfo, null, key, tradeLog, type, llen);
//		}
//	}
//
//	/**
//	 * 行情记录生成
//	 * 
//	 * @param marketInfo
//	 *            行情
//	 * @param key
//	 *            行情缓存KEY
//	 * @param tradeLog
//	 *            成交交易
//	 * @param type
//	 *            类型
//	 * @param llen
//	 *            marketInfo在redis中的索引位置
//	 * @return
//	 */ // 当前级别最后一条、null、 当前级别的key（s)、当前交易(s)、 当前级别(s)、当前级别最后一个的index（s)
//		// 上一级最后一个、当前级别最后一条、上一级的key、 当前的交易、 上一级、 上一级的最后index
//	public boolean getMarketInfo(MarketInfo marketInfo, MarketInfo childMarketInfo, String key, TradeLog tradeLog,
//			Integer type, int llen) {
//		int index = llen - 1;
//		// list缓存集合
//		JedisUtilnew.Lists lists = jedisUtil.new Lists();
//
//		String kineTime = MarketInfoUtils.getMarketInfoTime(type, new Date(tradeLog.getAddtime()));
//		if (childMarketInfo != null) {
//			kineTime = MarketInfoUtils.getMarketInfoTime(type, new Date(childMarketInfo.getDealTime()));
//		}
//		/**
//		 * 行情记录唯一编号相等时 成交交易已存入Redis时 更新开盘价、收盘价， 最高价、最低价、成交数量 不相等时则为新的记录 创建新的行情
//		 */
//		boolean isKineTime = false;
//		synchronized (this) {
//			isKineTime = kineTime.equals(marketInfo.getKineTime());
//		}
//		if (isKineTime) {
//			if (childMarketInfo == null) {
//				// 判断最高价
//				if (marketInfo.getTopPrice().doubleValue() < tradeLog.getPrice().doubleValue()) {
//					marketInfo.setTopPrice(tradeLog.getPrice());
//				}
//				// 判断最低价
//				if (marketInfo.getLowPrice().doubleValue() > tradeLog.getPrice().doubleValue()) {
//					marketInfo.setLowPrice(tradeLog.getPrice());
//				}
//				// 增加成交量
//				marketInfo.setCount(marketInfo.getCount().add(tradeLog.getNum()));
//				// 收盘价为当前价
//				marketInfo.setLastPrice(tradeLog.getPrice());
//
//			} else {
//				// 判断最高价
//				if (marketInfo.getTopPrice().doubleValue() < childMarketInfo.getTopPrice().doubleValue()) {
//					marketInfo.setTopPrice(childMarketInfo.getTopPrice());
//				}
//				// 判断最低价
//				if (marketInfo.getLowPrice().doubleValue() > childMarketInfo.getLowPrice().doubleValue()) {
//					marketInfo.setLowPrice(childMarketInfo.getLowPrice());
//				}
//				// 增加成交量
//				marketInfo.setCount(marketInfo.getCount().add(childMarketInfo.getCount()));
//				// 收盘价为当前价
//				marketInfo.setLastPrice(tradeLog.getPrice());
//			}
//			// 根据llen更新当前缓存集合
//			lists.lset(key.getBytes(), index, SerializeUtils.serialize(marketInfo));
//		} else {
//
//			// 处理上级行情
//			String parentKey = "ThreadLog_" + tradeLog.getMarket() + "_" + Range.getName(type + 1);
//			int parentLlen = (int) lists.llen(parentKey.getBytes());
//			MarketInfo parentMarketInfo = null;
//			if (parentLlen > 0) {
//				int parentIndex = parentLlen - 1;
//				// 获取最后一条
//				byte[] parentKeyByte = lists.lindex(parentKey.getBytes(), parentIndex);
//				parentMarketInfo = (MarketInfo) SerializeUtils.unserialize(parentKeyByte);
//				// 处理上一级
//				// 上一级最后一个、当前级别最后一条、上一级的key、当前的交易、上一级、上一级的最后index
//				getMarketInfo(parentMarketInfo, marketInfo, parentKey, tradeLog, type + 1, parentLlen);
//			}
//			String k = key.substring("ThreadLog_".length());
//			String marketStr = k.substring(0, k.indexOf("_"));
//			// 生成新行情将上一行情写入数据库
//			saveMarket(marketInfo, type, marketStr);
//			marketInfo = new MarketInfo();
//			marketInfo.setDealTime(tradeLog.getAddtime());
//			marketInfo.setFirstPrice(tradeLog.getPrice());
//			marketInfo.setLastPrice(tradeLog.getPrice());
//			marketInfo.setLowPrice(tradeLog.getPrice());
//			marketInfo.setTopPrice(tradeLog.getPrice());
//			marketInfo.setCount(tradeLog.getNum());
//			marketInfo.setKineTime(kineTime);
//			// 在当前缓存集合中新增
//			lists.rpush(key.getBytes(), SerializeUtils.serialize(marketInfo));
//		}
//		return true;
//	}
//
//	/**
//	 * 根据行情类型存入不同的mongo表
//	 * 
//	 * @param marketInfo
//	 * @param type
//	 */
//	private void saveMarket(MarketInfo marketInfo, Integer type, String market) {
//		switch (type) {
//		case 1:
//			MarketInfoSecond marketInfoSecond = new MarketInfoSecond(marketInfo);
//			marketInfoSecond.setType(market);
//			marketInfoSecondRepository.save(marketInfoSecond);
//			break;
//		case 2:
//			MarketInfoMinutes marketInfoMinutes = new MarketInfoMinutes(marketInfo);
//			marketInfoMinutes.setType(market);
//			marketInfoMinutesRepository.save(marketInfoMinutes);
//			break;
//		case 3:
//			MarketInfoHour marketInfoHour = new MarketInfoHour(marketInfo);
//			marketInfoHour.setType(market);
//			marketInfoHourRepository.save(marketInfoHour);
//			break;
//		case 4:
//			MarketInfoDay marketInfoDay = new MarketInfoDay(marketInfo);
//			marketInfoDay.setType(market);
//			marketInfoDayRepository.save(marketInfoDay);
//			break;
//		default:
//			break;
//		}
//	}
//
//	/**
//	 * 初始化redis缓存
//	 * 
//	 * @param marketInfo
//	 * @param type
//	 * @param addTime
//	 * @param lists
//	 */
//	private void createMarketInfoRedis(String market, MarketInfo marketInfo, Integer type, Long addTime,
//			JedisUtilnew.Lists lists) {
//		for (int i = 4; i > type; i--) {
//			String key = "ThreadLog_" + market + "_" + Range.getName(i);
//			MarketInfo parentMarketInfo = marketInfo;
//			parentMarketInfo.setKineTime(MarketInfoUtils.getMarketInfoTime(i, new Date(addTime)));
//			lists.rpush(key.getBytes(), SerializeUtils.serialize(parentMarketInfo));
//		}
//	}
//
//	/**
//	 * redis 存储当天的交易记录
//	 * 
//	 * @param price
//	 *            成交价
//	 * @param num
//	 *            交易数量
//	 * @param type
//	 *            交易对
//	 */
//	private void saveExcRedis(double price, double num, String type) {
//
//		// ValueOperations<String, String> valueOperations =
//		// stringRedisTemplate.opsForValue();
//		JedisUtilnew.Strings valueOperations = jedisUtil.new Strings();
//
//		String today = DateFormatUtils.format(new Date(), "yyyyMMdd");
//		String high = valueOperations.get(today + "_" + type + "_high");
//		String low = valueOperations.get(today + "_" + type + "_low");
//		String count = valueOperations.get(today + "_" + type + "_count");
//		count = count == null ? "0" : count;
//		if (high == null || Double.valueOf(high) < price) {
//			valueOperations.set(today + "_" + type + "_high", BigDecimal.valueOf(price).toPlainString());
//		}
//		if (low == null || Double.valueOf(low) > price) {
//			valueOperations.set(today + "_" + type + "_low", BigDecimal.valueOf(price).toPlainString());
//		}
//		valueOperations.set(today + "_" + type + "_count",
//				BigDecimal.valueOf(num).add(new BigDecimal(count)).stripTrailingZeros().toPlainString());
//	}
//
//	/**
//	 * 更新行情数据
//	 *
//	 * @param symbol
//	 *            交易对
//	 */
//	@Async
//	public void changeViewData(String symbol) {
//
//		KtradeContext.getAttribute(KtradeContextKey.KTRADE_HIGH_MAP);
//
//		JedisUtilnew.Strings valueOperations = jedisUtil.new Strings();
//		String today = DateFormatUtils.format(new Date(), "yyyyMMdd");
//
//		String tHigh = valueOperations.get(today + "_" + symbol + "_high");
//		String count = valueOperations.get(today + "_" + symbol + "_count");
//		String low = valueOperations.get(today + "_" + symbol + "_low");
//		tHigh = tHigh == null ? "0" : tHigh;
//		count = count == null ? "0" : count;
//		low = low == null ? "0" : low;
//		String change = "0";
//		if (!"0".equals(tHigh)) {
//			JedisUtilnew.Keys key = jedisUtil.new Keys();
//			Set<String> keys = key.keys("*_" + symbol + "_high");
//			List<String> keyList = new ArrayList<>(keys);
//			if (!keyList.isEmpty()) {
//				Collections.sort(keyList, new Comparator<String>() {
//					@Override
//					public int compare(String s1, String s2) {
//						return s2.compareTo(s1);
//					}
//				});
//				String lastKey = null;
//				if (keyList.get(0).equals(today + "_" + symbol + "_high")) {
//					if (keyList.size() > 1) {
//						lastKey = keyList.get(1);
//					}
//				} else {
//					lastKey = keyList.get(0);
//				}
//				if (lastKey != null) {
//					String lastHighStr = valueOperations.get(lastKey); // 有记录最后一天最高价
//					BigDecimal yHigh = new BigDecimal(lastHighStr);
//					if (!yHigh.equals(BigDecimal.ZERO)) {
//						change = new BigDecimal(tHigh).subtract(yHigh).divide(yHigh, 4, BigDecimal.ROUND_HALF_EVEN)
//								.multiply(BigDecimal.valueOf(100)).stripTrailingZeros().toPlainString();
//					}
//				}
//			}
//		}
//
//		String price = "0";
//		Query query = new Query();
//		query.addCriteria(Criteria.where("market").is(symbol));
//		query.with(new Sort(Sort.Direction.valueOf("DESC"), "addtime"));
//		query.with(new PageRequest(0, 1));
//		TradeLog tradeLogs = mongoTemplate.findOne(query, TradeLog.class);
//		if (tradeLogs != null) {
//			price = tradeLogs.getPrice().toPlainString();
//		}
//		((Map<String, String>) KtradeContext.getAttribute(KtradeContextKey.KTRADE_HIGH_MAP)).put(symbol, tHigh);
//		((Map<String, String>) KtradeContext.getAttribute(KtradeContextKey.KTRADE_LOW_MAP)).put(symbol, low);
//		((Map<String, String>) KtradeContext.getAttribute(KtradeContextKey.KTRADE_CHANGE_MAP)).put(symbol, change);
//		((Map<String, String>) KtradeContext.getAttribute(KtradeContextKey.KTRADE_PRICE_MAP)).put(symbol, price);
//		((Map<String, String>) KtradeContext.getAttribute(KtradeContextKey.KTRADE_COUNT_MAP)).put(symbol, count);
//	}
//
//	public TradeLog buyTrade() throws Exception {
//
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//
//		Long addTime = System.currentTimeMillis();
//		TradeLog tradeLog = new TradeLog();
//		// 交易方用户ID
//		tradeLog.setUserid(1300);
//		// 交易对方用户ID
//		tradeLog.setPeerid(1221);
//		// 交易对
//		tradeLog.setMarket("fto_usdt");//fto_eth
//		// 交易价格
//		//double price = Math.random() * 0.05;
//		double price = 3;
//		BigDecimal bd = new BigDecimal(price);
//		bd = bd.setScale(4, BigDecimal.ROUND_HALF_UP);// 小數後面四位, 四捨五入
//		tradeLog.setPrice(bd);
//		// 交易数量
//		//double num = Math.random() * 0.2;
//		double num = 2;
//		bd = new BigDecimal(num);
//		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);// 小數後面四位, 四捨五入
//		tradeLog.setNum(bd);
//		// tradeLog.setNum(bd.equals(BigDecimal.ZERO) ? : bd);
//		BigDecimal fee = null;
//		int status = (int) (Math.random() * 10);
//		// fee =
//		// userTrade.getTrade().getFee().divide(userTrade.getTrade().getPrice().multiply(userTrade.getTrade().getNum()),10,BigDecimal.ROUND_UP);
//		switch (status % 2 + 1) {
//		case 1:
//			// 获取买方手续费 手续费费率 挂单手续费/挂单单价*挂单量*成交量
//			// 计算手续费
//			tradeLog.setFeeBuy(new BigDecimal("0.2"));
//			tradeLog.setFeeSell(BigDecimal.ZERO);
//			tradeLog.setType(1);
//			break;
//		case 2:
//			// 获取卖方手续费
//			// 计算手续费
//			tradeLog.setFeeBuy(BigDecimal.ZERO);
//			tradeLog.setFeeSell(new BigDecimal("0.2"));
//			tradeLog.setType(2);
//			break;
//		default:
//			return null;
//		}
//		// 交易类型：1:买方挂单；2：卖方挂单
//		// tradeLog.setType(1);
//		// 交易时间
//		tradeLog.setAddtime(addTime);
//		tradeLog.setEndtime(addTime);
//		// 获取交易流水号
//		Long serialNumber = Long.parseLong(1300 + "" + 1221);
//		// 新增属性挂单表ID 2018122106500000005
//		tradeLog.setTradeId(Long.parseLong("165501"));
//		tradeLog.setSerialNumber(serialNumber);
//		tradeLog.setId(Long.parseLong(sdf.format(new Date())));
//		tradeLog.setMum(tradeLog.getNum().multiply(tradeLog.getPrice()).setScale(10, BigDecimal.ROUND_UP));
//		//tradeLog.set_class("com.etchain.model.infoormation.MarketInfo");
//		// 设置成交状态
//		tradeLog.setStatus(1);
//		return tradeLog;
//
//	}

}
