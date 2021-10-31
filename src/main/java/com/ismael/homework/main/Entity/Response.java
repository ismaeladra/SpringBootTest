package com.ismael.homework.main.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Unified public responder
 * @author NULL
 * @date 2019-07-16
 */
@Data
@AllArgsConstructor
public class Response implements Serializable {

    /**
     * Return information
     */
    private String msg;
    /**
     * data
     */
    private Object data;

}