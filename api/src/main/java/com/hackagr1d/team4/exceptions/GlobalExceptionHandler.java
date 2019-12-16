package com.hackagr1d.team4.exceptions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Collections;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected Issue processExceptions(final Exception ex, final WebRequest request) {
        LOGGER.error("Error for request"+ request, ex);
        return new Issue(IssueEnum.UNEXPECTED_ERROR, Collections.singletonList(ex.getLocalizedMessage()));
    }
}
