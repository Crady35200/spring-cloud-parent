package com.crady.zuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :Crady
 * date :2019/9/2 17:59
 * desc : Swagger配置
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    ZuulProperties properties;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // 扫描的包路径
                .apis(RequestHandlerSelectors.basePackage("com.crady.zuul.controller"))
                .apis(RequestHandlerSelectors.any())
                // 定义要生成文档的Api的url路径规则
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                // 标题
                .title("ms-gateway-zuul")
                // 描述
                .description("ms-gateway-zuul项目集成swagger")
                // 文档版本
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }

    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider(){
        return () ->{
            List<SwaggerResource> resources = new ArrayList<>();
            properties.getRoutes().values().stream().forEach(route -> resources.add(
                    createResource(route.getServiceId(),route.getPath(),"2.0")));
            return resources;
        };
    }
    private SwaggerResource createResource(String name,String location,String version){
        SwaggerResource resource = new SwaggerResource();
        resource.setName(name);
        resource.setLocation("/api/" + location.replaceAll("/\\*\\*","") + "/v2/api-docs");
        resource.setSwaggerVersion(version);
        return resource;
    }
}
