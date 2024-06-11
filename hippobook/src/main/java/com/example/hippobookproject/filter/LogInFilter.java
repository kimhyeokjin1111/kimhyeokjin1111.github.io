package com.example.hippobookproject.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LogInFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    log.info("LoginFilter init !!");
    }

    @Override
    public void destroy() {
        log.info("LoginFilter Destroy !!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        다운 캐스팅하여 사용
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            HttpServletResponse resp = (HttpServletResponse) servletResponse;
            resp.sendRedirect("/user/login");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
        log.info("doFilter 지나간다");
    }
}
