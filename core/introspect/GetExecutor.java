package com.alibaba.tamper.core.introspect;

import com.alibaba.tamper.core.BeanMappingException;

/**
 * 属性的Get方法操作接口
 * 
 * @author jianghang 2011-5-25 上午11:14:28
 */
public interface GetExecutor {

    Object invoke(Object obj) throws BeanMappingException;
}
