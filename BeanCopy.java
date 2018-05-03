package com.alibaba.tamper;

import com.alibaba.tamper.core.BeanMappingException;
import com.alibaba.tamper.core.BeanMappingExecutor;
import com.alibaba.tamper.core.BeanMappingParam;
import com.alibaba.tamper.core.config.BeanMappingConfigHelper;
import com.alibaba.tamper.core.config.BeanMappingEnvironment;
import com.alibaba.tamper.core.config.BeanMappingObject;

/**
 * Bean copy操作的处理单元
 * 
 * <pre>
 * <code>
 * 使用例子：
 *  BeanCopy beanCopy = BeanCopy.create(srcClass , targetClass);
 *  beanCopy.copy(src,target);//完成copy动作
 * </code>
 * </pre>
 * 
 * @author jianghang 2011-6-8 上午11:10:47
 */
public class BeanCopy {

    private BeanMappingObject config; // 对应的Bean Mapping配置

    BeanCopy(BeanMappingObject config){
        this.config = config;
    }

    /**
     * 创建srcClass和targetClass之间的BeanCopy操作
     */
    public static BeanCopy create(Class srcClass, Class targetClass) {
        BeanMappingObject config = BeanMappingConfigHelper.getInstance().getBeanMappingObject(srcClass, targetClass,
                                                                                              true);
        return new BeanCopy(config);
    }

    /**
     * 对象属性的拷贝，与BeanUtils , BeanCopier功能类似
     * 
     * @param src
     * @param target
     * @throws BeanMappingException
     */
    public void copy(Object src, Object target) throws BeanMappingException {
        BeanMappingParam param = new BeanMappingParam();
        param.setSrcRef(src);
        param.setTargetRef(target);
        param.setConfig(this.config);
        param.setProcesses(BeanMappingEnvironment.getBeanCopyVps());

        // 执行mapping处理
        BeanMappingExecutor.execute(param);
    }

}
