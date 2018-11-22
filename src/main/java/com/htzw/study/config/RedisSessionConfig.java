package com.htzw.study.config;

import org.springframework.context.annotation.Configuration;

/**
 * 注意：引入了spring-session后，这个server.session.timeout=1800配置将不再起作用， 我们需要写一个如下的配置类：
 *  maxInactiveIntervalInSeconds：默认是1800秒过期，这里测试修改为60秒
 * @author Administrator
 */
@Configuration
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60)
public class RedisSessionConfig {
//	@Bean
//	public CookieHttpSessionStrategy cookieHttpSessionStrategy(){
//	    CookieHttpSessionStrategy strategy=new CookieHttpSessionStrategy();
//	    DefaultCookieSerializer cookieSerializer=new DefaultCookieSerializer();
//		//cookies名称
//	    cookieSerializer.setCookieName("MYSESSIONID");
//		//过期时间(秒)
//	    cookieSerializer.setCookieMaxAge(1800);
//	    strategy.setCookieSerializer(cookieSerializer);
//	    return strategy;
//	}
}

	