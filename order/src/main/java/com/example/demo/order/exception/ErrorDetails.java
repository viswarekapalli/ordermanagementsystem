package com.example.demo.order.exception;

import lombok.Data;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Data
public class ErrorDetails {
    private Date timestamp;
    private String message;


    public ErrorDetails(Date timestamp, String message) {
        super();
        this.timestamp = timestamp;
        this.message = message;
    }


}
