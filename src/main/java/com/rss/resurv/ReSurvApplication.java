package com.rss.resurv;

import jakarta.annotation.Nullable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ReSurvApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReSurvApplication.class, args);
    }
    @Bean
    public WebMvcConfigurer configure() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@Nullable CorsRegistry reg) {
                assert reg != null;
                reg.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
