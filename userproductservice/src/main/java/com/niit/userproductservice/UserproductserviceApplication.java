package com.niit.userproductservice;

import com.niit.userproductservice.JWTFilter.Jwt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients

public class UserproductserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserproductserviceApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean filterUrl(){
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new Jwt());
//		filterRegistrationBean.addUrlPatterns("/api/v2/demo");
//		filterRegistrationBean.addUrlPatterns("/track/{email}");
		filterRegistrationBean.addUrlPatterns("/allusers/*");
//		filterRegistrationBean.addUrlPatterns("/tracks/{trackName}");
//		filterRegistrationBean.addUrlPatterns("/musictrack/{email}");

		return filterRegistrationBean;
	}


}
