package com.example.hippobookproject.config;


import com.example.hippobookproject.filter.LogInFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

//    LoginFilter
    @Bean
    public FilterRegistrationBean<LogInFilter> loginFilter(){
        FilterRegistrationBean<LogInFilter> registrationBean = new FilterRegistrationBean<>();


//        LoginFilter 필터 등록
        registrationBean.setFilter(new LogInFilter());

//        실행되어야하는 URL 패턴 설정
        registrationBean.addUrlPatterns("/alarm", "/feed/follow","/feed/postwrite","/feed/readwrite",
                "/mypage/*","/message/*", "/board/write" );

//      필터 순서
        registrationBean.setOrder(1);

//        필터이름
        registrationBean.setName("login");
        return registrationBean;
    }



}
