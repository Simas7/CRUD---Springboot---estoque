package com.estoque.lojinha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class LojinhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojinhaApplication.class, args);
	}

//  @Bean
    // public CorsFilter corsFilter() {
    //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //     CorsConfiguration config = new CorsConfiguration();
    //     config.setAllowCredentials(true);
    //     config.addAllowedOrigin("*"); // Permitir todas as origens, ajuste conforme necessário
    //     config.addAllowedHeader("*");
    //     config.addAllowedMethod("OPTIONS");
    //     config.addAllowedMethod("GET");
    //     config.addAllowedMethod("POST");
    //     config.addAllowedMethod("PUT");
    //     config.addAllowedMethod("DELETE");
    //     source.registerCorsConfiguration("/**", config);
    //     return new CorsFilter(source);
    // }
}
