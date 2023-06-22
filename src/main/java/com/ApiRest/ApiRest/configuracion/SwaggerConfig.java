/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiRest.ApiRest.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
     public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ApiRest.ApiRest")) // Reemplaza "com.example.api" con el paquete base de tu aplicación
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
     
     private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API Documentation") // Título de la documentación
                .description("Documentation for My API") // Descripción de la API
                .version("1.0.0") // Versión de la API
                .build();
    }
     
     @Bean
    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .displayRequestDuration(true)
                .build();
    }
}
