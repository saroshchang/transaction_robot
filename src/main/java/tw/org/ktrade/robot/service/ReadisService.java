package tw.org.ktrade.robot.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.etchain.model.infoormation.MarketInfo;

import tw.org.ktrade.robot.po.TradeLog;
import tw.org.ktrade.robot.utils.JedisUtilnew;

@Service
public interface ReadisService {

	public void marketPush(TradeLog buyTradeLog, String coinName, BigDecimal coinPrice);

	public void marketVerify(TradeLog buyTradeLog, Integer type, String market);

	/**
	 * 根據行情類型存入不同的mongo表
	 * 
	 * @param marketInfo
	 * @param type
	 */
	public void saveMarket(MarketInfo marketInfo, Integer type, String market);

	/**
	 * 初始化redis緩存
	 * 
	 * @param marketInfo
	 * @param type
	 * @param addTime
	 * @param lists
	 */
	public void createMarketInfoRedis(String market, MarketInfo marketInfo, Integer type, Long addTime,
			JedisUtilnew.Lists lists) ;

	/**
	 * redis 存儲當天的交易記錄
	 * 
	 * @param price
	 *            成交價
	 * @param num
	 *            交易數量
	 * @param type
	 *            交易對
	 */
	public void saveExcRedis(double price, double num, String type) ;

	/**
	 * 更新行情數據
	 *
	 * @param symbol
	 *            交易對
	 */
	public void changeViewData(String symbol);

	//public TradeLog buyTrade() throws Exception;

}
