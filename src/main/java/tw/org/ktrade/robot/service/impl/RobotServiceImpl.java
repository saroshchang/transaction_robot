package tw.org.ktrade.robot.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;

import tw.org.ktrade.robot.constant.FullCoinName;
import tw.org.ktrade.robot.constant.FullCoinsName;
import tw.org.ktrade.robot.constant.GroupCoinName;
import tw.org.ktrade.robot.constant.ShortCoinName;
import tw.org.ktrade.robot.context.KtradeContext;
import tw.org.ktrade.robot.context.KtradeContextKey;
import tw.org.ktrade.robot.po.TradeLog;
import tw.org.ktrade.robot.service.CoinPriceService;
import tw.org.ktrade.robot.service.MongoDbService;
import tw.org.ktrade.robot.service.ReadisService;
import tw.org.ktrade.robot.service.RobotService;

@Service
public class RobotServiceImpl implements RobotService {

	private static final Logger logger = LoggerFactory.getLogger(RobotServiceImpl.class);

	@Autowired
	private CoinPriceService coinPrice;

	@Autowired
	private MongoDbService mongoDbService;

	@Autowired
	private ReadisService readisService;
	
	@Value("${coin.price.eth_btc}")
	private String eth_btc_url;
	@Value("${coin.price.hlc_btc}")
	private String hlc_btc_url;
	@Value("${coin.price.fto_eth}")
	private String fto_eth_url;
	@Value("${coin.price.fto_usdt}")
	private String fto_usdt_url;
	@Value("${coin.price.fto_btc}")
	private String fto_btc_url;
	@Value("${coin.price.nuls_eth}")
	private String nuls_eth_url;
	@Value("${coin.price.nuls_btc}")
	private String nuls_btc_url;
	@Value("${coin.price.nuls_usdt}")
	private String nuls_usdt_url;
	@Value("${coin.price.xrp_usdt}")
	private String xrp_usdt_url;
	@Value("${coin.price.hlc_usdt}")
	private String hlc_usdt_url;
	@Value("${coin.price.btc_usdt}")
	private String btc_usdt_url;
	@Value("${coin.price.eth_usdt}")
	private String eth_usdt_url;
	@Value("${coin.price.dash_usdt}")
	private String dash_usdt_url;
	@Value("${coin.price.xmr_usdt}")
	private String xmr_usdt_url;
	@Value("${coin.price.xrp_btc}")
	private String xrp_btc_url;
	@Value("${coin.price.xrp_eth}")
	private String xrp_eth_url;
	@Value("${coin.price.hlc_eth}")
	private String hlc_eth_url;
	@Value("${coin.price.dash_btc}")
	private String dash_btc_url;
	@Value("${coin.price.dash_eth}")
	private String dash_eth_url;
	@Value("${coin.price.xmr_btc}")
	private String xmr_btc_url;
	@Value("${coin.price.xmr_eth}")
	private String xmr_eth_url;
	@Value("${coin.price.all_coin}")
	private String all_coin_url;
	
	

	@Override
	public void runFtoEth() {
		running(GroupCoinName.fto_eth, FullCoinName.fto, ShortCoinName.eth,	fto_eth_url, 3);
	}

	@Override
	public void runFtoUsdt() {
		running(GroupCoinName.fto_usdt, FullCoinName.fto, ShortCoinName.usdt, fto_usdt_url, 4);
	}
	
	@Override
	public void runFtoBtc() {
		running(GroupCoinName.fto_btc, FullCoinName.fto, ShortCoinName.btc, fto_btc_url, 6);
	}
	
	@Override
	public void runNulsEth() {
		running(GroupCoinName.nuls_eth, FullCoinName.nuls, ShortCoinName.eth, nuls_eth_url, 6);
	}
	
	@Override
	public void runNulsBtc() {
		running(GroupCoinName.nuls_btc, FullCoinName.nuls, ShortCoinName.btc, nuls_btc_url, 6);
		
	}

	@Override
	public void runNulsUsdt() {
		running(GroupCoinName.nuls_usdt, FullCoinName.nuls, ShortCoinName.usdt, nuls_usdt_url, 4);
		
	}
	
	@Override
	public void runXrpTwdt() {
		running(GroupCoinName.xrp_twdt, FullCoinName.xrp, ShortCoinName.twdt, xrp_usdt_url, 4);
		
	}

	@Override
	public void runNulsTwdt() {
		running(GroupCoinName.nuls_twdt, FullCoinName.nuls, ShortCoinName.twdt, nuls_usdt_url, 4);
		
	}

	@Override
	public void runHlcTwdt() {
		running(GroupCoinName.hlc_twdt, FullCoinName.hlc, ShortCoinName.twdt, hlc_usdt_url, 4);
		
	}

	@Override
	public void runBtcTwdt() {
		running(GroupCoinName.btc_twdt, FullCoinName.btc, ShortCoinName.twdt, btc_usdt_url, 4);
		
	}

	@Override
	public void runEthTwdt() {
		running(GroupCoinName.eth_twdt, FullCoinName.eth, ShortCoinName.twdt, eth_usdt_url, 4);
		
	}

	@Override
	public void runDashTwdt() {
		running(GroupCoinName.dash_twdt, FullCoinName.dash, ShortCoinName.twdt, dash_usdt_url, 4);
		
	}

	@Override
	public void runXmrTwdt() {
		running(GroupCoinName.xmr_twdt, FullCoinName.xmr, ShortCoinName.twdt, xmr_usdt_url, 4);
		
	}

	@Override
	public void runXrpUsdt() {
		running(GroupCoinName.xrp_usdt, FullCoinName.xrp, ShortCoinName.usdt, xrp_usdt_url, 4);
		
	}

	@Override
	public void runHlcUsdt() {
		running(GroupCoinName.hlc_usdt, FullCoinName.hlc, ShortCoinName.usdt, hlc_usdt_url, 4);
		
	}

	@Override
	public void runBtcUsdt() {
		running(GroupCoinName.btc_usdt, FullCoinName.btc, ShortCoinName.usdt, btc_usdt_url, 4);
		
	}

	@Override
	public void runEthUsdt() {
		running(GroupCoinName.eth_usdt, FullCoinName.eth, ShortCoinName.usdt, eth_usdt_url, 4);
		
	}

	@Override
	public void runDashUsdt() {
		running(GroupCoinName.dash_usdt, FullCoinName.dash, ShortCoinName.usdt, dash_usdt_url, 4);
		
	}

	@Override
	public void runXmrUsdt() {
		running(GroupCoinName.xmr_usdt, FullCoinName.xmr, ShortCoinName.usdt, xmr_usdt_url, 4);
		
	}

	/****************************2019/01/19*********************************************************************************************************/
	

	@Override
	public void runXrpBtc() {
		running(GroupCoinName.xrp_btc, FullCoinName.xrp, ShortCoinName.btc, xrp_btc_url, 8);
		
	}

	@Override
	public void runXrpEth() {
		running(GroupCoinName.xrp_eth, FullCoinName.xrp, ShortCoinName.eth, xrp_eth_url, 6);
		
	}
	
	@Override
	public void runHlcEth() {
		running(GroupCoinName.hlc_eth, FullCoinName.hlc, ShortCoinName.eth, hlc_eth_url, 6);
		
	}
	
	@Override
	public void runHlcBtc() {
		running(GroupCoinName.hlc_btc, FullCoinName.hlc, ShortCoinName.btc, hlc_btc_url, 8);
		
	}
	
	@Override
	public void runFtoTwdt() {
		running(GroupCoinName.fto_twdt, FullCoinName.fto, ShortCoinName.twdt, fto_usdt_url, 4);
		
	}
	
	@Override
	public void runDashBtc() {
		running(GroupCoinName.dash_btc, FullCoinName.dash, ShortCoinName.btc, dash_btc_url, 8);
		
	}

	@Override
	public void runDashEth() {
		running(GroupCoinName.dash_eth, FullCoinName.dash, ShortCoinName.eth, dash_eth_url, 6);
		
	}
	
	@Override
	public void runXmrBtc() {
		running(GroupCoinName.xmr_btc, FullCoinName.xmr, ShortCoinName.btc, xmr_btc_url, 6);
		
	}

	@Override
	public void runXmrEth() {
		running(GroupCoinName.xmr_eth, FullCoinName.xmr, ShortCoinName.eth, xmr_eth_url, 6);
		
	}
	
	@Override
	public void runEthBtc() {
		running(GroupCoinName.eth_btc, FullCoinName.eth, ShortCoinName.btc, eth_btc_url, 7);
		
	}
	
	/**
	 * 取幣幣對照價格，並寫入MongoDb、Readis
	 * @param coinName 交易對
	 * @param tradeCoin 交易貨幣
	 * @param targetCoin 目標貨幣
	 * @param url 交易對價格網址
	 * @param decimalPoint 價格取多少小數點
	 */
	private void running(String coinName, String tradeCoin,  String targetCoin, String url, int decimalPoint ) {
		
		try {
			BigDecimal price = coinPrice.getCoinPrice(coinName, tradeCoin, targetCoin, url);
			
			TradeLog tradelog = mongoDbService.buyTrade(coinName, price.setScale(decimalPoint, BigDecimal.ROUND_DOWN));
			// 寫入mongo
			mongoDbService.insertMongo(tradelog);
			// 寫入Readis
			readisService.marketPush(tradelog, coinName, price);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.toString());

		}
		
	}

	@Override
	public Object getMarket(String type) {
		try {
			String[] coins = type.split("_");
			
			if (StringUtils.equals(coins[1], "usdt")) {
				coins[1] = "usd";
			}
			
			List<Map<String,BigDecimal>> priceList = coinPrice.getCoinPriceAndPercentage(type, FullCoinsName.of(coins[0]), coins[1], all_coin_url);
			BigDecimal price = new BigDecimal(String.valueOf(priceList.get(0).get(coins[1])));
			BigDecimal change = new BigDecimal(String.valueOf(priceList.get(1).get("change")));
			
			Map<String, Object> map = new HashMap<>();
			map.put("high", highBigDecimal(price, change));
			map.put("low", lowBigDecimal(price, change));
			map.put("change",change.setScale(8, RoundingMode.HALF_UP));
			map.put("price",price);
			map.put("count",RandomCount());
			map.put("symbol", type);
			return map;
		}catch(Exception e) {
			logger.info(e.toString());
			return null;
		}
		
	}

	BigDecimal RandomCount() {
		Float i = (float) (Math.random()*1+1);
		return new BigDecimal(String.valueOf(i));
	}

	BigDecimal lowBigDecimal(BigDecimal price, BigDecimal change) {
		BigDecimal coinPrice = price.multiply(change.divide(new BigDecimal(100)));
		return price.subtract(coinPrice).setScale(8, RoundingMode.HALF_UP);
		
	}
	
	BigDecimal highBigDecimal(BigDecimal price, BigDecimal change) {
		
		BigDecimal coinPrice = price.multiply(change.divide(new BigDecimal(100)));
		return price.add(coinPrice).setScale(8, RoundingMode.HALF_UP);
	}
	

	

	

	

	

	
}
