package tw.org.ico.service.impl;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import tw.org.ktrade.robot.Run;
import tw.org.ktrade.robot.po.TradeLog;
import tw.org.ktrade.robot.service.impl.TradeLogServiceImpl;

//@RunWith(SpringJUnit4ClassRunner.class)
//// 指定我们SpringBoot工程的Application启动类
//@SpringApplicationConfiguration(classes = Run.class)
//// 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
//@WebAppConfiguration
public class TradeLogTest {
	

//	@Resource
//	private TradeLogServiceImpl service;
//
//	/**
//	 * 测试增删改查
//	 */
//	@Test
//	public void test() {
//
////		// service.deleteAll();
////		try {
////			MongoClient client = new MongoClient();
////			MongoClientOptions customClientOptions = new MongoClientOptions.Builder().connectionsPerHost(50).maxWaitTime(2000).build();  
////			MongoOptions options = new MongoOptions(customClientOptions);  
////			//client = new MongoClient("ec2-3-112-37-217.ap-northeast-1.compute.amazonaws.com", customClientOptions);  // 每個MongoClient例項維護一個連線池
////			client = new MongoClient(new MongoClientURI("mongodb://:@ec2-3-112-37-217.ap-northeast-1.compute.amazonaws.com/admin?authMechanism=MONGODB-CR&maxPoolSize=500"));  
////			//client.close();  
////			//MongoClient client = new MongoClient();
////			List<String> DatabaseNames = client.getDatabaseNames();
////			String ConnectPoint = client.getConnectPoint();
////			String Address = client.getAddress().toString();
////		} catch (UnknownHostException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		// save a couple of customers
//		try {
//			for(int x = 0 ; x < 2 ; x++) {
//				service.insert(this.buyTrade());
//		
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// service.save(new Customer("Bob", "Smith"));
//
//		// fetch all customers
////		System.out.println("TradeLog found with findAll():");
////		System.out.println("-------------------------------");
////		int count = 0;
////		for (TradeLog tradeLog1 : service.findAll()) {
////			System.out.println(tradeLog1);
////			count++;
////		}
//		// assertThat(count, is(2));
//
//		// // fetch an individual customer
//		// System.out.println("Customer found with findByFirstName('Alice'):");
//		// System.out.println("--------------------------------");
//		// Customer c = service.findByFirstName("Alice");
//		// System.out.println("-------------------------------- :" + c);
//		//// assertThat(c, notNullValue());
//		//// assertThat(c.getFirstName(), is("Alice"));
//		//
//		// System.out.println("Customers found with findByLastName('Smith'):");
//		// System.out.println("--------------------------------");
//		//
//		// List<Customer> list = service.findByLastName("Smith");
//		//// assertThat(list, notNullValue());
//		//// assertThat(list.size(), greaterThan(1));
//		//// assertThat(list.size(), is(2));
//	}
//
////	public TradeLog buyTrade1() throws Exception {
////		
//////		 "_id" : NumberLong(2018122106500000005),
//////		    "_class" : "com.etchain.model.trade.TradeLog",
//////		    "userid" : 1300,
//////		    "peerid" : 178,
//////		    "market" : "nuls_usdt",
//////		    "price" : "3.0000000000",
//////		    "num" : "1.3500000000",
//////		    "mum" : "4.0500000000",
//////		    "feeBuy" : "0.0040500000",
//////		    "feeSell" : "0",
//////		    "type" : 1,
//////		    "addtime" : NumberLong(1545376777699),
//////		    "endtime" : NumberLong(1545376777699),
//////		    "status" : 1,
//////		    "tradeId" : 1640497,
//////		    "serialNumber" : NumberLong(1640497494164),
//////		    "version" : "1.0.0",
//////		    "pageSize" : 10,
//////		    "totalCount" : NumberLong(0),
//////		    "DEF_COUNT" : 10,
//////		    "currentPage" : 0,
//////		    "direction" : "desc"
////		Long addTime = System.currentTimeMillis();
////		TradeLog tradeLog = new TradeLog();
////		//tradeLog.setc
////		tradeLog.setId(new Long(addTime));
////		
////		tradeLog.set_class("com.etchain.model.trade.TradeLog");
////		// 交易方用户ID
////		tradeLog.setUserid(1300);
////		// 交易对方用户ID
////		tradeLog.setPeerid(1300);
////		// 交易对
////		tradeLog.setMarket("nuls_usdt");
////		// 交易价格
////		tradeLog.setPrice(new BigDecimal("0.1"));
////		// 交易数量
////		tradeLog.setNum(new BigDecimal("2"));
//////	    "price" : "3.0000000000",
//////	    "num" : "1.3500000000",
//////	    "mum" : "4.0500000000",
//////	    "feeBuy" : "0.0040500000",
//////	    "feeSell" : "0",
//////	    "type" : 1,
//////	    "totalCount" : NumberLong(0),
//////	    "DEF_COUNT" : 10,
//////	    "currentPage" : 0,
//////	    "direction" : "desc"		
////		tradeLog.setFeeBuy(new BigDecimal("1"));
////		tradeLog.setFeeSell(new BigDecimal("1"));
////		tradeLog.setFee(new BigDecimal("1"));
////		tradeLog.setStatus(1);
////		tradeLog.setTotalCount(Long.parseLong("0"));
////		tradeLog.setDEF_COUNT(10);
////		tradeLog.setCurrentPage(0);
////		tradeLog.setDesc("desc");
////		// 交易类型：1:买方挂单；2：卖方挂单
////		tradeLog.setType(1);
////		// 交易时间
////		tradeLog.setAddtime(addTime);
////		tradeLog.setEndtime(addTime);
////		// 获取交易流水号
////		Long serialNumber = Long.parseLong(addTime.toString());
////		// 新增属性挂单表ID
////		tradeLog.setTradeId(Long.parseLong(addTime.toString()));
////		tradeLog.setSerialNumber(serialNumber);
////		
////		tradeLog.setMum(tradeLog.getNum().multiply(tradeLog.getPrice()).setScale(10, BigDecimal.ROUND_UP));
////		// 设置成交状态
////		tradeLog.setStatus(1);
////
////		return tradeLog;
////
////	}
//	
//	public TradeLog buyTrade() throws Exception {
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//		
//		
//		Long addTime = System.currentTimeMillis();
//        TradeLog tradeLog = new TradeLog();
//        //交易方用户ID
//        tradeLog.setUserid(1300);
//        //交易对方用户ID
//        tradeLog.setPeerid(1221);
//        //交易对
//        tradeLog.setMarket("fto_usdt");
//        //交易价格
//        tradeLog.set_class("com.etchain.model.trade.TradeLog");
//        double price= Math.random()*0.05;
//        BigDecimal bd= new BigDecimal(price);   
//		bd=bd.setScale(4, BigDecimal.ROUND_HALF_UP);// 小數後面四位, 四捨五入   
//        tradeLog.setPrice(bd);
//        //交易数量
//        double num= Math.random()*0.2;
//        bd= new BigDecimal(num);   
//		bd=bd.setScale(2, BigDecimal.ROUND_HALF_UP);// 小數後面四位, 四捨五入   
//		tradeLog.setNum(bd);
//        //tradeLog.setNum(bd.equals(BigDecimal.ZERO) ?  : bd);
//        BigDecimal fee = null;
//        int status = (int)(Math.random()*10);
//        //fee = userTrade.getTrade().getFee().divide(userTrade.getTrade().getPrice().multiply(userTrade.getTrade().getNum()),10,BigDecimal.ROUND_UP);
//        switch (status%2+1) {
//            case 1:
//                //获取买方手续费 手续费费率 挂单手续费/挂单单价*挂单量*成交量
//                //计算手续费
//                tradeLog.setFeeBuy(new BigDecimal("0.2"));
//                tradeLog.setFeeSell(BigDecimal.ZERO);
//                tradeLog.setType(1);
//                break;
//            case 2:
//                //获取卖方手续费
//                //计算手续费
//                tradeLog.setFeeBuy(BigDecimal.ZERO);
//                tradeLog.setFeeSell(new BigDecimal("0.2"));
//                tradeLog.setType(2);
//                break;
//            default:
//                return null;
//        }
//        //交易类型：1:买方挂单；2：卖方挂单
//        //tradeLog.setType(1);
//        //交易时间
//        tradeLog.setAddtime(addTime);
//        tradeLog.setEndtime(addTime);
//        //获取交易流水号
//        Long serialNumber = Long.parseLong(1300 + "" + 1221);
//        //新增属性挂单表ID 2018122106500000005
//        tradeLog.setTradeId(Long.parseLong("165501"));
//        tradeLog.setSerialNumber(serialNumber);
//        tradeLog.setId(Long.parseLong(sdf.format(new Date())));
//        tradeLog.setMum(tradeLog.getNum().multiply(tradeLog.getPrice()).setScale(10,BigDecimal.ROUND_UP));
//        //设置成交状态
//        tradeLog.setStatus(1);
//        return tradeLog;
//    
//	}
//	
////  /**
////  * 生成数据库表主键
////  * 
////  * @param name 表名
////  * @return
////  */
//// public static Long generateID(TableName name) {
////     
////     String timeStr8 = DateUtils.getTimeStr8();      //获取当前日期
////     String key = name.name() + timeStr8;            //key
//////     Long incrBy = jedis.incrBy(key, AUTO_INCR_LONG);
////    
////    JedisUtilnew instance = JedisUtilnew.getInstance();
////    Strings strings = instance. new Strings();
////     
////     String autoNum = NumberUtils.getLengthLong(strings.incrBy(key, AUTO_INCR_LONG), 8);              //获取8位自增序号
////     String tbNum = NumberUtils.getLengthLong(name.ordinal(), 3);        //3位表序号
////     return new Long(timeStr8 + tbNum + autoNum);
//// }
//	
}
