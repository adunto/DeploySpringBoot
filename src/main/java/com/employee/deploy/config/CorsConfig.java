package com.employee.deploy.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

/*
* CSRF(Cross-Site Request Forgery)
*/

@Configuration
public class CorsConfig {
    @Bean
    public FilterRegistrationBean<?> corsConfigurationSource() {
        // Cors 설정
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(List.of("*"));
        // 토큰 통신 설정 Credential
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList(
                "Access-Control-Allow-Headers",
                "Access-Control-Allow-Origin",
                "Access-Control-Request-Method",
                "Access-Control-Request-Headers",
                "Origin","Cache-Control", "Content-Type", "Authorization"));
        configuration.setAllowedMethods(Arrays.asList("POST", "DELETE", "GET", "PATCH", "PUT"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        FilterRegistrationBean<?> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}