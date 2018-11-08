package com.htzw.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**通过使用@MapperScan可以指定要扫描的Mapper类的包的路径
 *greek主函数
 */
@SpringBootApplication
@MapperScan(basePackages = "com.htzw.study.mapper")
public class GreekApplication {
	public static void main(String[] args) {
		SpringApplication.run(GreekApplication.class, args);
	}
}
