package com.fanedesign.bookstore.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseHttp {

    private String status;
    private Integer code;
    private String message;
    private Object reponse;
}
