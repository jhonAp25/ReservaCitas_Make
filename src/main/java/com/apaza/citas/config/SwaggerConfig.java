package com.apaza.citas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.apaza.citas.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo info(){
        return new ApiInfo(
                "Api Tienda 2.0",
                "",
                "1.0",
                "https://www.apache.org/licenses/LICENSE-2.0.html",
                new Contact(
                        "jhon Apaza Larico ",
                        "",
                        "apazalaricojhon25@gmail.com"),
                "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0.html",
                Collections.emptyList()
        );
    }


}
