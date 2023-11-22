package com.RabbitProject.FindRabbit;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // You can configure which origins are allowed to access your server. "*" allows all origins, which can be a security risk.
        config.addAllowedOrigin("*");

        // You can configure which HTTP methods are allowed (e.g., GET, POST, PUT, DELETE).
        config.addAllowedMethod("*");

        // You can configure which HTTP headers are allowed in the request.
        config.addAllowedHeader("*");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}