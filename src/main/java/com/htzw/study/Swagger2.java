package com.htzw.study;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
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

/**
 *
 * @ConditionalOnExpression 为Spring的注解，用户是否实例化本类，
 * 用于是否启用Swagger的判断（生产环境需要屏蔽Swagger）
* @Description:    Swagger配置类
* @Author:         glj
* @CreateDate:     2018/11/8
* @Version:        1.0
*/
@Configuration
@EnableSwagger2
@ConditionalOnExpression("${swagger.enable:true}")//生产环境下需要屏蔽Swagger
public class Swagger2  {
    /**
     * api文档实例
     * @return
     */
    @Bean
    public Docket createRestfulApi() {
        return new Docket(DocumentationType.SWAGGER_2)//文档类型：DocumentationType.SWAGGER_2
                .apiInfo(apiInfo())//api信息
                .select()//构建api选择器
                .apis(RequestHandlerSelectors.basePackage("com.htzw.study.controller"))//api选择器选择api的包
                .paths(PathSelectors.any())//api选择器选择包路径下任何api显示在文档中
                .build();//创建文档
    }

    /**
     * 接口的相关信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful接口")
                .description("API描述")
                .contact(new Contact("glj",null,null))//创建人
                .version("1.0")//版本号
                .build();
    }
}