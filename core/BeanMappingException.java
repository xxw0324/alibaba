package com.alibaba.tamper.core;

import org.apache.commons.lang.exception.NestableRuntimeException;

/**
 * @author jianghang 2011-5-25 上午11:23:59
 */
public class BeanMappingException extends NestableRuntimeException {

    private static final long serialVersionUID = -4176128184885659405L;

    public BeanMappingException(){
        super();
    }

    public BeanMappingException(String message, Throwable cause){
        super(message, cause);
    }

    public BeanMappingException(String message){
        super(message);
    }

    public BeanMappingException(Throwable cause){
        super(cause);
    }

}
