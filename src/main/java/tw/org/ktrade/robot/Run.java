package tw.org.ktrade.robot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication// same as @Configuration @EnableAutoConfiguration @ComponentScan
@MapperScan("tw.org.ktrade.robot.dao")
@EnableScheduling
public class Run {
	
	public static void main(String[] args) {
		//run debug 都會停止在“throw new SilentExitException（）;” 即使沒有斷點會停留，
		//遺憾的是，這是新spring-boot-devtools模塊的一個已知問題，通過以下方式禁用它
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(Run.class, args);
    }
	
}
