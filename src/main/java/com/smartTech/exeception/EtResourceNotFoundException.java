package com.smartTech.exeception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
   public class EtResourceNotFoundException  extends RuntimeException {

        public EtResourceNotFoundException (String message) {
            super(message);
        }
    }

