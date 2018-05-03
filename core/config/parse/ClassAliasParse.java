package com.alibaba.tamper.core.config.parse;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.alibaba.tamper.core.BeanMappingException;
import com.alibaba.tamper.core.helper.ReflectionHelper;

/**
 * 解析下Class alias的相关配置
 * 
 * @author jianghang 2011-6-21 下午01:33:28
 */
public class ClassAliasParse {

    public static void parseAndRegister(Node node) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node aliasClassNode = nodeList.item(i);
            if ("classAlias".equals(aliasClassNode.getNodeName())) {
                Node aliasNode = aliasClassNode.getAttributes().getNamedItem("alias");
                Node clazzNode = aliasClassNode.getAttributes().getNamedItem("class");
                if (aliasNode == null || clazzNode == null) {
                    throw new BeanMappingException("alias or class is null , please check!");
                }

                String alias = aliasNode.getNodeValue();
                Class clazz = ReflectionHelper.forName(clazzNode.getNodeValue());
                ReflectionHelper.registerClassAlias(aliasNode.getNodeValue(), clazz);
                System.out.println("register class[" + clazz.toString() + "] to alias[" + alias + "]");
            }
        }
    }
}
