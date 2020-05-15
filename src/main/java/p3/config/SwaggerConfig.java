package p3.config;

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
public class SwaggerConfig {
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				// 0th set "app metadata", custom header (title, etc) to be used instead of default generated "Api Documentation", for swagger generated documents 
				.apiInfo(apiInfo())
				.select()
				 // 1a filter out unrelated urls coming from Spring MVC (like error handling "basic-error-controller" section)
//					.paths(PathSelectors.any())  // Any path satisfies this condition
					.paths(PathSelectors.ant("/rest/**"))
				 // 1b filter out unrelated model classes(like "ModelAndView", "View"), show only our REST api classes
					.apis(RequestHandlerSelectors.basePackage("p3.rest"))
					.build()
				;
	}
	/** @return ApiInfo that is used to display customized info on top of the swagger generated api documentations */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("p3 REST api Reference")
				.version("1.0.0")
				.build();
	}

}
