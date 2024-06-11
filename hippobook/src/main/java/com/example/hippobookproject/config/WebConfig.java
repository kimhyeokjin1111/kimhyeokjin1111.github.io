package com.example.hippobookproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${file.dir}")
    private String fileDir;
    @Value("${file.profile.dir}")
    private String profileDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:" + fileDir);

        registry.addResourceHandler("/profile/**")
                .addResourceLocations("file:" + profileDir);
    }
}
















