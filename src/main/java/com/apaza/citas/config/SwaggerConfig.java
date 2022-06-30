package com.apaza.citas.config;


import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;;

import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(info())
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo info(){
        return new ApiInfo(
                "Make Citas",
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

    private List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope("global","AccessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;

        return Collections.singletonList(new SecurityReference("JWT", authorizationScopes));
    }

    private SecurityContext securityContext(){
        return SecurityContext
                .builder()
                .securityReferences(defaultAuth())
                .build();
    }

    private ApiKey apiKey(){
        return new ApiKey("JWT", "Authorization", "header");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT")
                ;
            }
        };
    }


}
