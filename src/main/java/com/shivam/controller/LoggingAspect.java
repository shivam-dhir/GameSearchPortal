package com.shivam.controller;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// @Aspect is important in AOP. Allows implementation of advices at specific points in app. 
// Used in cross-cutting concerns
@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(public * com.shivam.controller.GameController.redirect())") 
    public void logBefore(){
        LOGGER.info("redirect started implementation");
    }

    // Logs message regardless of successful implementation, error, exception etc
    @After("execution(public * com.shivam.controller.GameController.redirect())")
    public void logAfter(){
        LOGGER.info("redirect method invoked");    
    }

    // Logs output if method throws exception
    @AfterThrowing("execution(public * com.shivam.controller.GameController.redirect())")
    public void logException(){
        LOGGER.info("exception encountered");    
    }

    // Logs output after successful implementation
    @AfterReturning("execution(public * com.shivam.controller.GameController.redirect())")
    public void logReturn(){
        LOGGER.info("redirect method completed implementation");    
    }

}
