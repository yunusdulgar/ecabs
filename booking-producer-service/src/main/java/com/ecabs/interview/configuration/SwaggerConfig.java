package com.ecabs.interview.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${api.basePackagePattern}")
    private String apiBasePackagePattern;
    @Value("${api.basePackageSelectors}")
    private String apiBasePackageSelectors;
    @Value("${api.title}")
    private String apiTitle;
    @Value("${api.description}")
    private String apiDescription;
    @Value("${api.contact.name}")
    private String apiContactName;
    @Value("${api.contact.url}")
    private String apiContactUrl;
    @Value("${api.contact.email}")
    private String apiContactEmail;
    @Value("${api.license}")
    private String apiContactLicense;
    @Value("${api.licenseUrl}")
    private String apiContactLicenseUrl;
    @Value("${api.version}")
    private String apiVersion;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(apiBasePackagePattern))
                .paths(PathSelectors.regex(apiBasePackageSelectors))
                .build().apiInfo(apiEndPointsInfo());

    }


    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title(apiTitle)
                .description(apiDescription)
                .contact(new Contact(apiContactName, apiContactUrl, apiContactEmail))
                .license(apiContactLicense)
                .licenseUrl(apiContactLicenseUrl)
                .version(apiVersion)
                .build();
    }
}
