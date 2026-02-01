package com.awsmembermanager;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ApiErrorLoggerAop {
    @AfterThrowing(pointcut = "bean(memberController)", throwing = "e")
    public void logError(JoinPoint jp, Throwable e) {
        log.error("[ERROR]: {} - {}", jp.getSignature().toShortString(), e.getMessage());
    }
}
