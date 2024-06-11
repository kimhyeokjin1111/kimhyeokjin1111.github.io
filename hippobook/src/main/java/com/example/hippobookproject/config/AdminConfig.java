package com.example.hippobookproject.config;

import com.example.hippobookproject.filter.AdminFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {
    @Bean
    public FilterRegistrationBean<AdminFilter> firstFilter(){
        FilterRegistrationBean<AdminFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new AdminFilter());
        registrationBean.addUrlPatterns("/admin/*");
        registrationBean.setOrder(1);
        registrationBean.setName("first");

        return registrationBean;
    }


}
