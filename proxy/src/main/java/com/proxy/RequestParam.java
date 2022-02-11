package com.proxy;

import lombok.Data;

import java.io.Serializable;

@Data
public class RequestParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private String bodyKey;
}
