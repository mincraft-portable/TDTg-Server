package com.minecraftportable.TDTg.auth.exception;

public class TokenException extends RuntimeException {
    public TokenException() {
        super("False token");
    }
}
