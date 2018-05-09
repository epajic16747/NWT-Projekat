package com.nwtProject.ZuluGatewayService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.nwtProject.ZuluGatewayService.Filters.PreSimpleFilter;

//@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ZuluGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuluGatewayServiceApplication.class, args);
	}
	
	  @Bean
	  public PreSimpleFilter simpleFilter() {
	    return new PreSimpleFilter();
	  }
}
