package tw.org.ico.service.impl;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import net.sf.json.JSONObject;
import tw.org.ktrade.robot.Run;

//@RunWith(SpringJUnit4ClassRunner.class)
////指定我们SpringBoot工程的Application启动类
//@SpringApplicationConfiguration(classes = Run.class)
////由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class BonusServiceImplTest {
	
//	final String uri = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=eth";
//	//https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=eth
//	//https://api.coingecko.com/api/v3/coins/bitcoin
////	@Resource
////	private BonusService bonusService;
////	
////	@Test
////	public void bonusTest() {
////		bonusService.userBonus();
////	}
//	@Test
//	public void testGetName() {
//		
//		RestTemplate restTemplate = new RestTemplate();
//
//		//https://api.coingecko.com/api/v3/coins/bitcoin
//		/*
//			JSONObject result = restTemplate.getForObject(uri, JSONObject.class);
//			JSONObject data = result.getJSONObject("market_data");
//			JSONObject data1 = data.getJSONObject("current_price"); 
//			System.out.println(data1);
//			String data2 = data1.getString("eth"); 
//			BigDecimal bd=new BigDecimal(data2);
//			System.out.println(bd);
//	    */
//	    
//		//https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=eth
//		JSONObject result = restTemplate.getForObject(uri, JSONObject.class);
//		JSONObject data = result.getJSONObject("bitcoin");
//		String data2 = data.getString("eth"); 
//		BigDecimal bd=new BigDecimal(data2);
//		System.out.println("btc_eth : "+bd);
//
//	}
//	
//	

}
