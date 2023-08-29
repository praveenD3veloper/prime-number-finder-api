package com.praveen.primefinder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.praveen.primefinder"))
                .paths(PathSelectors.any()).build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "REST API to find prime numbers",
                "Find prime numbers till the given range of N",
                "1.0.0",
                "Terms of service",
                new Contact("Praveen", "https://github.com/praveenD3veloper/", "praveeninmanchester@gmail.com"),
                "The GNU General Public License v3.0",
                "https://www.gnu.org/licenses/gpl-3.0.en.html",
                Collections.emptyList());
    }

}
