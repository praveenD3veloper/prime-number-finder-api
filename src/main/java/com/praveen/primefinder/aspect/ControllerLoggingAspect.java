package com.praveen.primefinder.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(ControllerLoggingAspect.class);

    @AfterReturning(pointcut = "within(com.praveen.primefinder.controller.*)", returning = "result")
    public void logControllerMethod(JoinPoint joinPoint, Object result) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        logger.info("Controller method executed: {}.{}", className, methodName);
    }
}
