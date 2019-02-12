import java.math.BigDecimal;

//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import tw.org.ico.Run;
//import tw.org.ico.common.IcoUtils;
//import tw.org.ico.po.KtrUser;
//import tw.org.ico.service.IcoUserService;
//import tw.org.ico.utils.PrintModel;

//@RunWith(SpringJUnit4ClassRunner.class)
////指定我们SpringBoot工程的Application启动类
//@SpringApplicationConfiguration(classes = Run.class)
////由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
//@WebAppConfiguration
public class UserApiTest {

	
	
	public static void main(String[] arg) throws Exception {
		
		BigDecimal bd= new BigDecimal(0);   
		for(int x = 0 ; x<= 100 ; x++) {
			double i= Math.random()*0.1;
			bd= new BigDecimal(i);   
			bd=bd.setScale(4, BigDecimal.ROUND_HALF_UP);// 小數後面四位, 四捨五入   
			System.out.println(bd.doubleValue());  
			System.out.println(i);
		}
		
		

	}
	
}
