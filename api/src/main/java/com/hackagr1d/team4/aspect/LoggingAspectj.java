package com.hackagr1d.team4.aspect;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectj {

    private static final String INVOICE_BEFORE = " Post request message: %s";
    private static final String INVOICE_AFTER = " Post response message: %s";
    private static final String INVOICE_BEFORE_GET = " Get method name: %s";

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspectj.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Before("execution(* com.hackagr1d.team4.controllers.*.*(..))")
    public void logBefore(final JoinPoint joinPoint) throws JsonProcessingException {

        if (joinPoint.getArgs().length > 0) {
            loggerInvoice(INVOICE_BEFORE, joinPoint.getArgs());
        } else {
            loggerInvoice(INVOICE_BEFORE_GET, joinPoint.getSignature().getName());
        }
    }

    @AfterReturning(value = "execution(* com.hackagr1d.team4.controllers.*.*(..))",
            returning = "result")
    public void logAfterReturning(final JoinPoint joinPoint, final Object result) throws JsonProcessingException {

        loggerInvoice(INVOICE_AFTER, result);
    }

    private void loggerInvoice(final String message, final Object values) throws JsonProcessingException {

        final String jsonMessage = objectMapper.writer().writeValueAsString(values);
        final String payloadMsg = String.format(message, jsonMessage);
        LOGGER.info(payloadMsg);
    }
}