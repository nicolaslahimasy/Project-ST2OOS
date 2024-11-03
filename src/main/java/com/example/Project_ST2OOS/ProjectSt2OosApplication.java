package com.example.Project_ST2OOS;

import com.example.Project_ST2OOS.rpcservice.RpcServiceApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProjectSt2OosApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ProjectSt2OosApplication.class, args);
		RpcServiceApplication rpcServiceApplication = context.getBean(RpcServiceApplication.class);

		try {
			rpcServiceApplication.start(); // Démarre explicitement le service gRPC
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Bean
	public WebMvcConfigurer forwardToIndex() {
		return new WebMvcConfigurer() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("index"); // Renvoie index.html
				registry.addViewController("/orders").setViewName("orders"); // Renvoie orders.html
			}
		};
	}
}
