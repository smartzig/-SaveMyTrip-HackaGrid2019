package com.hackagr1d.team4.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.IllegalFormatException;

public enum IssueEnum {


    UNEXPECTED_ERROR(6, "invoice-service-unexpected-error.please-contact-system-administrator");


    private final Logger logger = LogManager.getLogger(IssueEnum.class);
    private final int code;
    private final String message;

    IssueEnum(final int code, final String message) {

        this.code = code;
        this.message = message;
    }

    public int getCode() {

        return code;
    }

    public String getFormattedMessage(final Object... args) {

        if (message == null) {
            return "";
        }

        try {
            return String.format(message, args);
        } catch (final IllegalFormatException e) {
            logger.warn(e.getMessage(), e);
            return message.replace("%s", "");
        }
    }
}

