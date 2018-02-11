package com.coviam.booking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfig {

  @Value("${swagger.application.api.title}")
  private String apiTitle;

  @Value("${swagger.application.api.description}")
  private String apiDesc;

  @Value("${swagger.application.api.email}")
  private String email;

  @Value("${swagger.application.api.licenseType}")
  private String licence;

  @Value("${swagger.application.api.licenseLocation}")
  private String licenceLocation;

  @Value("${documentation.services.version}")
  private String apiVersion;

  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.coviam.booking"))
        .paths(PathSelectors.any()).build().genericModelSubstitutes(ResponseEntity.class)
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    ApiInfo apiInfo = new ApiInfo(apiTitle, apiDesc, apiVersion, "", new Contact(email, "", email),
        licence, licenceLocation);
    return apiInfo;
  }

}

