package tw.org.ktrade.robot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 配置跨域請求
 */
@Configuration
public class CorsConfig {

	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*"); // 允許任何域名使用
		corsConfiguration.addAllowedHeader("*"); // 允許任何頭
		corsConfiguration.addAllowedMethod("*"); // 允許任何方法（post、get等）
		corsConfiguration.setAllowCredentials(true);
		return corsConfiguration;
	}

	/**
	 * 配置js跨域
	 */
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig());

		return new CorsFilter(source);
	}

}