package com.minecraftportable.TDTg.auth.exception;

import com.minecraftportable.TDTg.base.exception.ServiceException;

public class UnauthorizedException extends ServiceException {
    public UnauthorizedException() {
        super("Unauthorized", 401);
    }
}
