package com.plateer.todo.common.config;

import com.plateer.todo.todo.controller.interceptor.TodoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.*;
import com.plateer.todo.common.formmatter.LocalDateFormatter;
import com.plateer.todo.common.util.JWTUtil;

@Configuration
@EnableWebMvc
public class CustomServletConfig implements WebMvcConfigurer {

    @Bean
    public JWTUtil jwtUtil(){
        return new JWTUtil();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new TodoInterceptor(jwtUtil()))
                .addPathPatterns("/api/todos/*");

    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

        registry.addFormatter(new LocalDateFormatter());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE")
                .maxAge(300)
                .allowedHeaders("Authorization", "Cache-Control", "Content-Type");


    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/fonts/**")
                .addResourceLocations("classpath:/static/fonts/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/assets/**").
                addResourceLocations("classpath:/static/assets/");

    }

}