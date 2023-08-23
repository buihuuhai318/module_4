package com.example.app_rent_book.logger;

import com.example.app_rent_book.model.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.app_rent_book.service.imp.RentDetailService.*(..))")
    public void beforeBookServiceMethods(JoinPoint joinPoint) {
        logger.info("Executing method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.app_rent_book.service.imp.RentDetailService.*(..))", returning = "result")
    public void afterReturningBookServiceMethods(JoinPoint joinPoint, Object result) {
        logger.info("Finished executing method: " + joinPoint.getSignature().getName());
        if (result instanceof Book) {
            logger.info("Updated book: " + ((Book) result).getName());
        }
    }

    @AfterThrowing(pointcut = "execution(* com.example.app_rent_book.service.imp.RentDetailService.*(..))", throwing = "ex")
    public void afterThrowingBookServiceMethods(JoinPoint joinPoint, Throwable ex) {
        logger.error("Error in method: " + joinPoint.getSignature().getName() + " - " + ex.getMessage());
    }
}