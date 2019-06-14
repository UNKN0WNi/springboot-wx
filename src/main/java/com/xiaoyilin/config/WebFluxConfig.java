package com.xiaoyilin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * 如果你想保留Spring Boot WebFlux功能，并且想要添加额外的WebFlux配置，
 * 你可以添加自己的@Configuration类，类型为WebFluxConfigurer，
 * 但没有@EnableWebFlux。
 *
 * 如果完全控制Spring WebFlux，可以添加自己的@Configuration注释@EnableWebFlux。
 */
@Configuration
public class WebFluxConfig implements WebFluxConfigurer {

 @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }



}
