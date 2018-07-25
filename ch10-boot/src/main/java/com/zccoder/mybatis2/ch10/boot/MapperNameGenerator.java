package com.zccoder.mybatis2.ch10.boot;

import java.beans.Introspector;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.util.ClassUtils;

/**
 * 标题：Mapper 名字生成器<br>
 * 描述：Mapper 名字生成器<br>
 * 时间：2018/07/03<br>
 *
 * @author zc
 **/
public class MapperNameGenerator implements BeanNameGenerator {
    Map<String, Integer> nameMap = new HashMap<String, Integer>();

    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        //获取类的名字，如  CountryMapper
        String shortClassName = ClassUtils.getShortName(definition.getBeanClassName());
        //将类名转换为规范的变量名，如 countryMapper
        String beanName = Introspector.decapitalize(shortClassName);
        //判断名字是否已经存在，如果存在，则在名字后面增加序号
        if (nameMap.containsKey(beanName)) {
            int index = nameMap.get(beanName) + 1;
            nameMap.put(beanName, index);
            //增加序号
            beanName += index;
        } else {
            nameMap.put(beanName, 1);
        }
        return beanName;
    }

}

