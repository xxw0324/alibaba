# alibaba
BeanCopy

配置文件
mapping.properties
valueProcess.script = com.alibaba.tamper.process.ScriptValueProcess
valueProcess.defaultValue = com.alibaba.tamper.process.DefaultValueValueProcess
valueProcess.convertor = com.alibaba.tamper.process.ConvertorValueProcess
valueProcess.behavior = com.alibaba.tamper.process.BehaviorValueProcess
valueProcess.debug = com.alibaba.tamper.process.DebugValueProcess
valueProcess.beanCreator = com.alibaba.tamper.process.BeanCreatorValueProcess

beanMapping.valueProcess.list = script,defaultValue,convertor,beanCreator,behavior,debug
beanMap.valueProcess.list = 
beanCopy.valueProcess.list = convertor

uberspect.impl = com.alibaba.tamper.core.introspect.UberspectImpl
