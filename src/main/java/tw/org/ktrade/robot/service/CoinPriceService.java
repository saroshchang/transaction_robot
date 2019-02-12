package tw.org.ktrade.robot.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface CoinPriceService {
	
	/**
	 * 取 coingecko 個幣種當前價格
	 * @param coin 幣種
	 * @param tradeCoin  交易幣種
	 * @param targetCoin 目標幣種
	 * @param url 網址
	 * @return
	 */
	BigDecimal getCoinPrice(String coin, String tradeCoin,  String targetCoin, String url);

	List<Map<String,BigDecimal>> getCoinPriceAndPercentage(String coin, String tradeCoin, String targetCoin, String url);
	
}
