package tw.org.ktrade.robot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import tw.org.ktrade.robot.po.Market;
import tw.org.ktrade.robot.service.MarketService;
import tw.org.ktrade.robot.service.RobotService;

@RestController
@RequestMapping("/robot")
public class RobotController {

	private static final Logger logger = LoggerFactory.getLogger(RobotController.class);
	
	@Value("${user.random.intNumber}")
	private String intNumber;
	
	@Autowired
	RobotService robotService;
	@Autowired
	MarketService marketService;

	/****************************2019/01/19 fto*********************************************************************************************************/
	
	/**
	 * 取目前Fto_Btc價格
	 */
	@ApiOperation(value="未來幣對比特幣", notes="未來幣對比特幣交易對")
	@RequestMapping(value = "/runFtoBtc", method = { RequestMethod.GET })
	@Scheduled(cron = "2 */17 * * * *")
	public void runFtoBtc() {
		robotService.runFtoBtc();
	}
	
	/**
	 * 取目前Fto_Eth價格
	 */
	@ApiOperation(value="未來幣對以太幣", notes="未來幣對以太幣交易對")
	@RequestMapping(value = "/runFtoEth", method = { RequestMethod.GET })
	@Scheduled(cron = "13 */13 * * * *")
	public void runFtoEth() {
		robotService.runFtoEth();
	}

	/**
	 * 取目前Fto_Usdt價格
	 */
	@ApiOperation(value="未來幣對Usdt", notes="未來幣對Usdt交易對")
	@RequestMapping(value = "/runFtoUsdt", method = { RequestMethod.GET })
	@Scheduled(cron = "1 */13 * * * *")
	public void runFtoUsdt() {
		robotService.runFtoUsdt();
	}
	
	/**
	 * 取目前Fto_Twdt價格
	 */
	@ApiOperation(value="未來幣對Twdt", notes="未來幣對Twdt交易對")
	@RequestMapping(value = "/runFtoTwdt", method = { RequestMethod.GET })
	@Scheduled(cron = "2 */7 * * * *")
	public void runFtoTwdt() {
		robotService.runFtoTwdt();
	}
	
	
	/****************************2019/01/19 nuls*********************************************************************************************************/
	
	/**
	 * 取目前Nuls_Btc價格
	 */
	@ApiOperation(value="Nuls對比特幣", notes="Nuls對比特幣交易對")
	@RequestMapping(value = "/runNulsBtc", method = { RequestMethod.GET })
	@Scheduled(cron = "4 */12 * * * *")
	public void runNulsBtc() {
		robotService.runNulsBtc();
	}
	
	/**
	 * 取目前Nuls_Eth價格
	 */
	@ApiOperation(value="Nuls對以太幣", notes="Nuls對以太幣交易對")
	@RequestMapping(value = "/runNulsEth", method = { RequestMethod.GET })
	@Scheduled(cron = "3 */14 * * * *")
	public void runNulsEth() {
		robotService.runNulsEth();
	}

	/**
	 * 取目前Nuls_Usdt價格
	 */
	@ApiOperation(value="Nuls對Usdt", notes="Nuls對Usdt交易對")
	@RequestMapping(value = "/runNulsUsdt", method = { RequestMethod.GET })
	@Scheduled(cron = "5 */18 * * * *")
	public void runNulsUsdt() {
		robotService.runNulsUsdt();
	}
	
	/**
	 * 取目前Nuls_Twdt價格
	 */
	@ApiOperation(value="nuls對Twdt", notes="nuls對Twdt交易對")
	@RequestMapping(value = "/runNulsTwdt", method = { RequestMethod.GET })
	@Scheduled(cron = "7 */16 * * * *")
	public void runNulsTwdt() {
		robotService.runNulsTwdt();
	}
	
	/****************************2019/01/19 dash*********************************************************************************************************/

	//目前無	Dash_Btc、Dash_Eth 交易
		
	//	/**
	//	 * 取目前Dash_Btc價格
	//	 */
	//	@ApiOperation(value="達斯對比特幣", notes="達斯對比特幣交易對")
	//	@RequestMapping(value = "/runDashBtc", method = { RequestMethod.GET })
	//	@Scheduled(cron = "2 */9 * * * *")
	//	public void runDashBtc() {
	//		robotService.runDashBtc();
	//	}
	//	
	//	/**
	//	 * 取目前Dash_Eth價格
	//	 */
	//	@ApiOperation(value="達斯對Eth", notes="達斯對Eth交易對")
	//	@RequestMapping(value = "/runDashEth", method = { RequestMethod.GET })
	//	@Scheduled(cron = "2 */8 * * * *")
	//	public void runDashEth() {
	//		robotService.runDashEth();
	//	}
	
	/**
	 * 取目前Dash_Usdt價格
	 */
	@ApiOperation(value="達斯對Usdt", notes="達斯對Usdt交易對")
	@RequestMapping(value = "/runDashUsdt", method = { RequestMethod.GET })
	@Scheduled(cron = "2 */12 * * * *")
	public void runDashUsdt() {
		robotService.runDashUsdt();
	}
	
	/**
	 * 取目前Dash_Twdt價格
	 */
	@ApiOperation(value="達斯對Twdt", notes="達斯對Twdt交易對")
	@RequestMapping(value = "/runDashTwdt", method = { RequestMethod.GET })
	@Scheduled(cron = "2 */12 * * * *")
	public void runDashTwdt() {
		robotService.runDashTwdt();
	}
	
	/****************************2019/01/19 xmr*********************************************************************************************************/
	
	/**
	 * 取目前Xmr_Btc價格
	 */
	@ApiOperation(value="門羅幣對比特幣", notes="門羅幣對比特幣交易對")
	@RequestMapping(value = "/runXmrBtc", method = { RequestMethod.GET })
	@Scheduled(cron = "2 */9 * * * *")
	public void runXmrBtc() {
		robotService.runXmrBtc();
	}
	
	/**
	 * 取目前Xmr_Eth價格
	 */
	@ApiOperation(value="門羅幣對Eth", notes="門羅幣對Eth交易對")
	@RequestMapping(value = "/runXmrEth", method = { RequestMethod.GET })
	@Scheduled(cron = "2 */8 * * * *")
	public void runXmrEth() {
		robotService.runXmrEth();
	}
	
	/**
	 * 取目前Xmr_Usdt價格
	 */
	@ApiOperation(value="門羅幣對Usdt", notes="門羅幣對Usdt交易對")
	@RequestMapping(value = "/runXmrTwdt", method = { RequestMethod.GET })
	@Scheduled(cron = "3 */11 * * * *")
	public void runXmrTwdt() {
		robotService.runXmrTwdt();
	}
	
	/**
	 * 取目前Xmr_Usdt價格
	 */
	@ApiOperation(value="門羅幣對Usdt", notes="門羅幣對Usdt交易對")
	@RequestMapping(value = "/runXmrUsdt", method = { RequestMethod.GET })
	@Scheduled(cron = "3 */11 * * * *")
	public void runXmrUsdt() {
		robotService.runXmrUsdt();
	}
	
/****************************2019/01/19 XRP*********************************************************************************************************/
	
	/**
	 * 取目前Xrp_Btc價格
	 */
	@ApiOperation(value="瑞波幣對Btc", notes="瑞波幣對Btc交易對")
	@RequestMapping(value = "/runXrpBtc", method = { RequestMethod.GET })
	@Scheduled(cron = "3 */12 * * * *")
	public void runXrpBtc() {
		robotService.runXrpBtc();
	}
	
	/**
	 * 取目前Xrp_Eth價格
	 */
	@ApiOperation(value="瑞波幣對Eth", notes="瑞波幣對Eth交易對")
	@RequestMapping(value = "/runXrpEth", method = { RequestMethod.GET })
	@Scheduled(cron = "3 */13 * * * *")
	public void runXrpEth() {
		robotService.runXrpEth();
	}
	
	/**
	 * 取目前Xrp_Twdt價格
	 */
	@ApiOperation(value="瑞波幣對Twdt", notes="瑞波幣對Twdt交易對")
	@RequestMapping(value = "/runXrpTwdt", method = { RequestMethod.GET })
	@Scheduled(cron = "6 */13 * * * *")
	public void runXrpTwdt() {
		robotService.runXrpTwdt();
	}
	
	/**
	 * 取目前Xrp_Usdt價格
	 */
	@ApiOperation(value="瑞波幣對Usdt", notes="瑞波幣對Usdt交易對")
	@RequestMapping(value = "/runXrpUsdt", method = { RequestMethod.GET })
	@Scheduled(cron = "6 */12 * * * *")
	public void runXrpUsdt() {
		robotService.runXrpUsdt();
	}
	
	/****************************2019/01/19 hlc*********************************************************************************************************/
	
	/**
	 * 取目前Hlc_Btc價格
	 */
	@ApiOperation(value="HalalChain對比特幣", notes="HalalChain對比特幣交易對")
	@RequestMapping(value = "/runHlcBtc", method = { RequestMethod.GET })
	@Scheduled(cron = "8 */11 * * * *")
	public void runHlcBtc() {
		robotService.runHlcBtc();
	}
	
	/**
	 * 取目前Hlc_Eth價格
	 */
	@ApiOperation(value="HalalChain對以太幣", notes="HalalChain對以太幣交易對")
	@RequestMapping(value = "/runHlcEth", method = { RequestMethod.GET })
	@Scheduled(cron = "8 */13 * * * *")
	public void runHlcEth() {
		robotService.runHlcEth();
	}
	
	/**
	 * 取目前Hlc_Usdt價格
	 */
	@ApiOperation(value="HalalChain對Usdt", notes="HalalChain對Usdt交易對")
	@RequestMapping(value = "/runHlcUsdt", method = { RequestMethod.GET })
	@Scheduled(cron = "8 */11 * * * *")
	public void runHlcUsdt() {
		robotService.runHlcUsdt();
	}
	
	/**
	 * 取目前Hlc_Twdt價格
	 */
	@ApiOperation(value="HalalChain對Twdt", notes="HalalChain對Twdt交易對")
	@RequestMapping(value = "/runHlcTwdt", method = { RequestMethod.GET })
	@Scheduled(cron = "8 */12 * * * *")
	public void runHlcTwdt() {
		robotService.runHlcTwdt();
	}
	
	/****************************2019/01/19 btc*********************************************************************************************************/
	
	/**
	 * 取目前Eth_Btc價格
	 */
	@ApiOperation(value="以太幣對比特幣", notes="以太幣對比特幣交易對")
	@RequestMapping(value = "/runEthBtc", method = { RequestMethod.GET })
	@Scheduled(cron = "12 */9 * * * *")
	public void runEthBtc() {
		robotService.runEthBtc();
	}
	
	/**
	 * 取目前Btc_Twdt價格
	 */
	@ApiOperation(value="比特幣對Twdt", notes="比特幣對Twdt交易對")
	@RequestMapping(value = "/runBtcTwdt", method = { RequestMethod.GET })
	@Scheduled(cron = "9 */14 * * * *")
	public void runBtcTwdt() {
		robotService.runBtcTwdt();
	}
	
	/**
	 * 取目前Btc_Usdt價格
	 */
	@ApiOperation(value="比特幣對Usdt", notes="比特幣對Usdt交易對")
	@RequestMapping(value = "/runBtcUsdt", method = { RequestMethod.GET })
	@Scheduled(cron = "9 */14 * * * *")
	public void runBtcUsdt() {
		robotService.runBtcUsdt();
	}
	
	/****************************2019/01/19 eth*********************************************************************************************************/
	
	/**
	 * 取目前Eth_Twdt價格
	 */
	@ApiOperation(value="以太幣對Twdt", notes="以太幣對Twdt交易對")
	@RequestMapping(value = "/runEthTwdt", method = { RequestMethod.GET })
	@Scheduled(cron = "1 */13 * * * *")
	public void runEthTwdt() {
		robotService.runEthTwdt();
	}
	
	/**
	 * 取目前Eth_Usdt價格
	 */
	@ApiOperation(value="以太幣對Usdt", notes="以太幣對Usdt交易對")
	@RequestMapping(value = "/runEthUsdt", method = { RequestMethod.GET })
	@Scheduled(cron = "1 */13 * * * *")
	public void runEthUsdt() {
		robotService.runEthUsdt();
	}
	
	/**
	 * 根据币种，查询币种对的最新价和涨跌幅
	 * 
	 * @param coinname
	 * 币种名称
	 */
	@RequestMapping("/getChangeAndPriceList")
	public Object getChangeAndPriceList(@RequestParam(required = true) String coinname) {
		if ("TWDT-ETH".equalsIgnoreCase(coinname)) {
			coinname = "twdt";
		}
		String _coinName = "_" + coinname.toLowerCase();
		List<Market> marketList = marketService.queryListByNameLike(_coinName);

		List<Map<String, Object>> list = new ArrayList<>();
		for (int i = 0; i < marketList.size(); i++) {
			String symbol = marketList.get(i).getName();
			if ("btc_kcoin".equals(symbol) || "eth_kcoin".equals(symbol) || "btc_eth".equals(symbol)) {
				continue;
			}
			list.add((Map<String, Object>) robotService.getMarket(symbol));
		}
		return list;
	}
	
	
//	@RequestMapping("/getMarket")
//	public Object getMarket(String type) {
//		if (type == null) {
//			return null;
//		}
//		Map<String, Object> map = new HashMap<>();
//		map.put("high", ((Map<String, String>) KtradeContext.getAttribute(KtradeContextKey.KTRADE_HIGH_MAP)).get(type));
//		map.put("low", ((Map<String, String>) KtradeContext.getAttribute(KtradeContextKey.KTRADE_LOW_MAP)).get(type));
//		map.put("change",
//				((Map<String, String>) KtradeContext.getAttribute(KtradeContextKey.KTRADE_CHANGE_MAP)).get(type));
//		map.put("price",
//				((Map<String, String>) KtradeContext.getAttribute(KtradeContextKey.KTRADE_PRICE_MAP)).get(type));
//		map.put("count",
//				((Map<String, String>) KtradeContext.getAttribute(KtradeContextKey.KTRADE_COUNT_MAP)).get(type));
//		map.put("symbol", type);
//		return map;
//	}
	
	


}
