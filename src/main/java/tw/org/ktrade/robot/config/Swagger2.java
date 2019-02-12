package tw.org.ktrade.robot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
	@Bean
    public Docket createRestApi() {
		
		
		//http://localhost:8089/swagger-ui.html#/
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("tw.org.ktrade.robot"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2構建RESTful APIs")
                //.description("更多Spring Boot相關文章請關注：http://blog.didispace.com/")
                //.termsOfServiceUrl("http://blog.didispace.com/")
                .contact("院子落葉　跟我的思念厚厚一疊 【Sarosh】")
                .version("1.0")
                .build();
    }
}
