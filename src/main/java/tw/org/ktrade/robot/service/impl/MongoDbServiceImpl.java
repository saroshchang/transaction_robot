package tw.org.ktrade.robot.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import tw.org.ktrade.robot.po.TradeLog;
import tw.org.ktrade.robot.service.MongoDbService;

@Service
public class MongoDbServiceImpl implements MongoDbService {

	private static final Logger logger = LoggerFactory.getLogger(MongoDbServiceImpl.class);

	@Resource
	private TradeLogServiceImpl service;

	@Override
	public TradeLog buyTrade(String coinName, BigDecimal coinPrice) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

		Long addTime = System.currentTimeMillis();
		TradeLog tradeLog = new TradeLog();
		tradeLog.set_class("com.etchain.model.trade.TradeLog");
		// 交易方用戶ID
		tradeLog.setUserid(1300);
		// 交易對方用戶ID
		tradeLog.setPeerid(1300);
		// 交易對
		tradeLog.setMarket(coinName);
		// 交易價格
		tradeLog.setPrice(coinPrice);
		// 交易數量
		double num = Math.random() * 0.02;
		BigDecimal bd = new BigDecimal(num);
		bd = bd.setScale(2, BigDecimal.ROUND_UP);// 無條件進入到 scale 位
		tradeLog.setNum(bd);
		tradeLog.setFeeBuy(bd);
		// tradeLog.setNum(bd.equals(BigDecimal.ZERO) ? : bd);
		BigDecimal fee = null;
		int status = (int) (Math.random() * 10);
		// fee =
		// userTrade.getTrade().getFee().divide(userTrade.getTrade().getPrice().multiply(userTrade.getTrade().getNum()),10,BigDecimal.ROUND_UP);
		switch (status % 2 + 1) {
		case 1:
			// 獲取買方手續費 手續費費率 掛單手續費/掛單單價*掛單量*成交量
			// 計算手續費
			tradeLog.setFeeBuy(new BigDecimal("0.2"));
			tradeLog.setFeeSell(BigDecimal.ZERO);
			tradeLog.setType(1);
			break;
		case 2:
			// 獲取賣方手續費
			// 計算手續費
			tradeLog.setFeeBuy(BigDecimal.ZERO);
			tradeLog.setFeeSell(new BigDecimal("0.2"));
			tradeLog.setType(2);
			break;
		default:
			return null;
		}
		// 交易類型：1:買方掛單；2：賣方掛單
		// tradeLog.setType(1);
		// 交易時間
		tradeLog.setAddtime(addTime);
		tradeLog.setEndtime(addTime);
		// 獲取交易流水號
		Long serialNumber = Long.parseLong(1300 + "" + 1221);
		// 新增屬性掛單表ID 2018122106500000005
		tradeLog.setTradeId(Long.parseLong("165501"));
		tradeLog.setSerialNumber(serialNumber);
		tradeLog.setId(Long.parseLong(sdf.format(new Date())));
		tradeLog.setMum(tradeLog.getNum().multiply(tradeLog.getPrice()).setScale(10, BigDecimal.ROUND_UP));
		// 設置成交狀態
		tradeLog.setStatus(1);
		logger.info(coinName + " coinPrice = " + coinPrice);
		return tradeLog;

	}

	@Override
	public void insertMongo(TradeLog tradelog) {
		try {
			service.insert(tradelog);
		} catch (Exception e) {
			logger.info(e.toString());
			e.printStackTrace();
		}
		
	}

	

}
