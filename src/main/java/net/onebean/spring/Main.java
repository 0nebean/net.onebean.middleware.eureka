package net.onebean.spring;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import net.onebean.core.extend.ApolloConfInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaServer
@EnableApolloConfig
public class Main  {

	public static void main(String[] args) {
		ApolloConfInitializer.init();
		SpringApplication.run(Main.class, args);
	}


}

