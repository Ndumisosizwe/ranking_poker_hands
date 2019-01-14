package com.codeofwars.integers.recreationone.exception;

/**
 * @author Ndumiso
 * @since 07-Nov-18
 */
public class FiveCardDrawException extends RuntimeException {

    public FiveCardDrawException() {
    }

    public FiveCardDrawException(String message, Throwable cause) {
        super(message, cause);
    }

    public FiveCardDrawException(String message) {
        super(message);
    }
}
