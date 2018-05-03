package com.alibaba.tamper.core.config.parse;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.alibaba.tamper.core.BeanMappingException;
import com.alibaba.tamper.core.helper.ReflectionHelper;
import com.alibaba.tamper.process.script.ScriptHelper;

/**
 * 解析下Function class的相关配置
 * 
 * @author jianghang 2011-6-21 下午01:33:28
 */
public class FunctionClassParse {

	public static void parseAndRegister(Node node) {
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node aliasClassNode = nodeList.item(i);
			if ("functionClass".equals(aliasClassNode.getNodeName())) {
				Node nameNode = aliasClassNode.getAttributes().getNamedItem("name");
				Node clazzNode = aliasClassNode.getAttributes().getNamedItem("class");
				if (nameNode == null || clazzNode == null) {
					throw new BeanMappingException("alias or class is null , please check!");
				}

				String name = nameNode.getNodeValue();
				Class clazz = ReflectionHelper.forName(clazzNode.getNodeValue());
				ScriptHelper.getInstance().registerFunctionClass(name, ReflectionHelper.newInstance(clazz));
				System.out.println("register class[" + clazz.toString() + "] to name[" + name + "]");
			}
		}
	}
}
