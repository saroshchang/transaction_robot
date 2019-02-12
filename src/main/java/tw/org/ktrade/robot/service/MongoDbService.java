package tw.org.ktrade.robot.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import tw.org.ktrade.robot.po.TradeLog;


@Service
public interface MongoDbService {

	
	/**
	 * 寫成交紀錄到MongoDb
	 * @param coinName
	 * @param coinPrice
	 */
	public void insertMongo(TradeLog tradelog);

	/**
	 * 生成存入MongoDb的值
	 * @param prcie
	 * @param coinPrice
	 * @return
	 * @throws Exception
	 */
	public TradeLog buyTrade(String prcie,	BigDecimal coinPrice) throws Exception ;

	

}
