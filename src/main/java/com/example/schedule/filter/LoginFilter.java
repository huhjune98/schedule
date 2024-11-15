package com.example.schedule.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {
    private static final String[] WHITE_LIST = {"/users","/users/login"};


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpServletRequest.getRequestURI();

        log.info("로그인 필터 로직 실행");

        if(!isWhiteList(requestURI)){
            HttpSession session = httpServletRequest.getSession(false);
            if(session != null || session.getAttribute("SESSION_KEY") != null){
                throw new RuntimeException("로그인 바랍니다.");
            }

            log.info("로그인된 사용자 요청: {}", requestURI);
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    private boolean isWhiteList(String requestURI){
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
