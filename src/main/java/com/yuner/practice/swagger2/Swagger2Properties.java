package com.yuner.practice.swagger2;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2文档 配置
 *
 * @author star
 * @date 2018年9月5日
 */
@Data
@EnableSwagger2
@ConfigurationProperties(prefix = "swagger2")
@Component(value = "swagger2Properties")
public class Swagger2Properties {

    private String title;

    private String description;

    private String groupName;

    private String license;

    private String licenseUrl;

    private String version;

    private String url;

    private String name;

    private String email;

    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenBuilder = new ParameterBuilder();
        List<Parameter> parameterList = new ArrayList<>();
        tokenBuilder.name("Authorization")
                .defaultValue("去其他请求中获取heard中token参数")
                .description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true).build();
        parameterList.add(tokenBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(groupName)
                .genericModelSubstitutes(DeferredResult.class)
                .apiInfo(apiInfo())
                // 选择哪些路径和api会生成document
                .select()
                //api接口包扫描路径
                //.apis(RequestHandlerSelectors.basePackage("zl.service.base.weather.controller"))
                /*所有restControll 中添加了ApiOperation注解的方法*/
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 对所有路径进行监控, 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置文档的标题
                .title(title)
                // 设置文档的描述->1.Overview
                .description(description)
                .license(license)
                .licenseUrl(licenseUrl)
                // 设置文档的联系方式->1.2 Contact information
                .contact(new Contact(name, url, email))
                // 设置文档的License信息->1.3 License information
                .termsOfServiceUrl(url)
                // 设置文档的版本信息-> 1.1 Version information
                .version(version)
                .build();
    }

}
