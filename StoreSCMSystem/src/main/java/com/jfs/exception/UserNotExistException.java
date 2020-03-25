package com.jfs.exception;

import org.springframework.security.core.AuthenticationException;

public class UserNotExistException extends AuthenticationException {

    public UserNotExistException(String msg, Throwable t) {
        super(msg, t);
    }

    public UserNotExistException(String msg) {
        super(msg);
    }

}
