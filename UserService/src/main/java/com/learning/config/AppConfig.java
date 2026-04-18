package com.learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {
    @Bean
    public WebClient webClient() {
        // Builder return karna best hai, taaki tu alag-alag
        // services ke liye base URL alag set kar sake
        return WebClient.builder().build();
    }
}
