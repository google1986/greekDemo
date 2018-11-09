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
 *swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。
 @author Administrator
  * @Api：修饰整个类，描述Controller的作用
 @ApiOperation：描述一个类的一个方法，或者说一个接口
 @ApiParam：单个参数描述
 @ApiModel：用对象来接收参数
 @ApiProperty：用对象接收参数时，描述对象的一个字段
 @ApiResponse：HTTP响应其中1个描述
 @ApiResponses：HTTP响应整体描述
 @ApiIgnore：使用该注解忽略这个API
 @ApiError ：发生错误返回的信息
 @ApiImplicitParam：一个请求参数
 @ApiImplicitParams：多个请求参数

 * @ConditionalOnExpression 为Spring的注解，用户是否实例化本类，
 * 用于是否启用Swagger的判断（生产环境需要屏蔽Swagger）
* @Description:    Swagger配置类
* @Author:         glj
* @CreateDate:     2018/11/8
* @Version:        1.0
*/
@Configuration
@EnableSwagger2
/**
 *生产环境下需要屏蔽Swagger
 */
@ConditionalOnExpression("${swagger.enable:true}")
public class Swagger2  {
    /**
     * api文档实例
     * @return
     */
    @Bean
    public Docket createRestfulApi() {
        /**
         * 文档类型：DocumentationType.SWAGGER_2
         */
        return new Docket(DocumentationType.SWAGGER_2)
                /**
                 * api信息
                 */
                .apiInfo(apiInfo())
                /**
                 * 构建api选择器
                 */
                .select()
                /**
                 * api选择器选择api的包
                 */
                .apis(RequestHandlerSelectors.basePackage("com.htzw.study.controller"))
                /**
                 * api选择器选择包路径下任何api显示在文档中
                 */
                .paths(PathSelectors.any())
                /**
                 * 创建文档
                 */
                .build();
    }

    /**
     * 接口的相关信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful接口")
                .description("API描述")
                /**
                 * 创建人
                 */
                .contact(new Contact("glj",null,null))
                /**
                 * 版本号
                 */
                .version("1.0")
                .build();
    }
}