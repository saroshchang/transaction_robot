package tw.org.ktrade.robot.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.druid.util.StringUtils;

import net.sf.json.JSONObject;
import tw.org.ktrade.robot.constant.FullCoinsName;
import tw.org.ktrade.robot.constant.ShortCoinName;
import tw.org.ktrade.robot.service.CoinPriceService;

@Service
public class CoinPriceServiceImpl implements CoinPriceService {
	
	private static final Logger logger = LoggerFactory.getLogger(CoinPriceServiceImpl.class);
	
	@Override
	public BigDecimal getCoinPrice(String coin, String tradeCoin,  String targetCoin, String url) {
		
		RestTemplate restTemplate = new RestTemplate();

		JSONObject result = restTemplate.getForObject(url, JSONObject.class);
		
		JSONObject data = result.getJSONObject(tradeCoin);
		String data2 = null;
		BigDecimal bd=new BigDecimal(0);
		//因為沒Twdt幣種，所以用Usdt幣種除30
		if(StringUtils.equalsIgnoreCase(targetCoin, "twdt")) {
			data2 = data.getString(ShortCoinName.usdt); 
			bd = new BigDecimal(data2);
			bd = bd.multiply(new BigDecimal("30"));
		}else {
			data2 = data.getString(targetCoin); 
			bd=new BigDecimal(data2);
		}
		return bd;
		
	}
	
	@Override
	public List<Map<String,BigDecimal>> getCoinPriceAndPercentage(String coin, String tradeCoin,  String targetCoin, String url) {
		
		if (tradeCoin == null) {
			return null;
		}
		String coin_url = null;
		////需改成每個交易對應的url，all_coin: https://api.coingecko.com/api/v3/simple/price?include_24hr_change=true&ids=replaceIds&vs_currencies=replaceCurrency
		//因沒有twdt交易，所以只能先換usdt換算
		if(StringUtils.equalsIgnoreCase(targetCoin, "twdt")) {
			coin_url = url.replaceFirst("replaceIds", tradeCoin).replace("replaceCurrency", "usd");
		}else {
			coin_url = url.replaceFirst("replaceIds", tradeCoin).replace("replaceCurrency", targetCoin);
		}
		List<Map<String,BigDecimal>> valuePrice = new ArrayList<Map<String,BigDecimal>>();
		
		RestTemplate restTemplate = new RestTemplate();
		JSONObject result = restTemplate.getForObject(coin_url, JSONObject.class);
		
		JSONObject data = result.getJSONObject(tradeCoin);
		String data2 = null;
		BigDecimal bd=new BigDecimal(0);
		//因沒有twdt交易，所以只能先換usdt換算
		if(StringUtils.equalsIgnoreCase(targetCoin, "twdt")) {
			data2 = data.getString(ShortCoinName.usdt); 
			bd = new BigDecimal(data2);
			bd = bd.multiply(new BigDecimal("30"));
		}else {
			data2 = data.getString(targetCoin); 
			bd=new BigDecimal(data2);
		}
		valuePrice.add(setMap(targetCoin, bd));
		
		//因沒有twdt交易，所以只能先換usdt換算
		if(StringUtils.equalsIgnoreCase(targetCoin, "twdt")) {
			targetCoin = ShortCoinName.usdt;
		}
		String change = data.getString(targetCoin+"_24h_change"); 
		BigDecimal percent=new BigDecimal(change);
		valuePrice.add(setMap("change", percent));
		return valuePrice;
		
	}
	
	public Map<String,BigDecimal> setMap(String key, BigDecimal value){
		Map<String,BigDecimal> priceNow = new HashMap<String,BigDecimal>();
		priceNow.put(key, value);
		return priceNow;
	}

}
