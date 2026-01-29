package com.camilo.webdemo.common.infrastriture.exepciones;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ErrorMessage {
    private String message;
    private String exception;
    private String path;
    private Map<String, String> errores;

    public ErrorMessage(String exception, String message, String path, Map<String, String> errores) {
        this.exception = exception;
        this.message = message;
        this.path = path;
        this.errores = errores;
    }

    public ErrorMessage(String exception, String message, String path) {
        this.exception = exception;
        this.message = message;
        this.path = path;
        this.errores = new HashMap<>();
    }
}
