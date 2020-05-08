package com.aut.prueba.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class LogFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //UUID: universal unique identifier
        String uuid =  UUID.randomUUID().toString();
        request.setAttribute("log_uuid", uuid);

        //123456543sdfghgfd Request: POST http://localhost/login
        logger.info("{} Request: {} {}", uuid, request.getMethod(), request.getRequestURL());

        long startTime = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        Integer responseCode = response.getStatus();
        long timeTaken = System.currentTimeMillis() - startTime;

        //123456543sdfghgfd Response Code: 200 - Time taken: 400ms
        logger.info("{} Response Code: {} - Time Taken: {} ms", uuid, responseCode, timeTaken);
    }
}
