package com.hackagr1d.team4.config;

import com.hackagr1d.team4.helpers.ApiConstants;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource("classpath:version.properties")
public class SwaggerConfig {

    @Autowired
    private Environment env;

    @Value("${swaggerBaseUrl}")
    private String baseUrl;

    @Bean
    public Docket productApi() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(metaData()).useDefaultResponseMessages(true).host(baseUrl)
                .tags(new Tag(ApiConstants.API_NAME, "HackaGr1d Team 4 App.")).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).paths(PathSelectors.any()).build();
    }

    private ApiInfo metaData() {

        final String projectVersion = env.getProperty("API_VERSION");
        return new ApiInfoBuilder().title("HackaGr1d Team 4 App")
                .description("\"REST API for HackaGr1d Team 4 App\"").version(projectVersion)
                .license("Team 4 © 2019").build();
    }

    @Bean
    public UiConfiguration uiConfig() {

        return UiConfigurationBuilder.builder().displayRequestDuration(true).validatorUrl(Strings.EMPTY).build();
    }

}
