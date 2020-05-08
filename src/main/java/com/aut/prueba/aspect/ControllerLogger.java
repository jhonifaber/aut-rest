package com.aut.prueba.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@RequiredArgsConstructor
public class ControllerLogger {

    private final HttpServletRequest request;

    private Logger logger = LoggerFactory.getLogger(ControllerLogger.class);

    @Before("within(com.aut.prueba.web.controller.*Controller)")
    public void before(JoinPoint joinPoint) {
        String uuid = (String) request.getAttribute("log_uuid");
        CodeSignature methodSignature = (CodeSignature) joinPoint.getSignature();
        String[] sigParamNames = methodSignature.getParameterNames();

        //5319eed5-ec03-4381-a09e-5504650c7ed0 Controller: execution(AuthenticationResponse
        // com.aut.prueba.web.controller.UserController.createToken(AuthenticationRequest)) -
        // Param names: [authenticationRequest] -
        // Param values: [AuthenticationRequest(username=any, password=pass)]
        logger.info("{} Controller: {} - Param names: {} - Param values: {}", uuid, joinPoint, Arrays.toString(sigParamNames), Arrays.toString(joinPoint.getArgs()));
    }
}
