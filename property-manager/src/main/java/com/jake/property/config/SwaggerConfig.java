package com.jake.property.config;

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


@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket customDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        // springfox.documentation.service.Contact
        Contact contact = new Contact("jake-jin", "https://www.cnblogs.com/jake-jin/", "jinbbnij@163.com");
        return new ApiInfoBuilder()
                .title("智慧社区管理平台开发文档")
                .description("开发文档通用接口")
                .contact(contact)   // 联系方式
                .version("1.2.0")  // 版本
                .build();
    }
}
