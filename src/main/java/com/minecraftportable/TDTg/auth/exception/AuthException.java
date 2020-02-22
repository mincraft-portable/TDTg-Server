package com.minecraftportable.TDTg.auth.exception;

import com.minecraftportable.TDTg.base.exception.ServiceException;

public class AuthException extends ServiceException {
    public AuthException() {
        super("Authentication failed", 403);
    }
}
