package com.zccoder.mybatis2.ch8.plugin.plugin;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 标题：MyBatis Map类型下划线key转小写驼峰形式<br>
 * 描述：MyBatis Map类型下划线key转小写驼峰形式<br>
 * 时间：2018/06/26<br>
 *
 * @author zc
 **/
@Intercepts(
    @Signature(
        type = ResultSetHandler.class,
        method = "handleResultSets",
        args = {Statement.class}
    )
)
public class CameHumpinterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 先执行得到结果，再对结果进行处理
        List<Object> list = (List<Object>) invocation.proceed();
        for (Object object : list) {
            // 如果结果是Map类型，就对Map的key进行转换
            if (object instanceof Map){
                processMap((Map)object);
            }else {
                break;
            }
        }
        return list;
    }

    /**
     * 处理Map类型
     * @param map Map
     */
    private void processMap(Map<String,Object> map) {
        Set<String> keyset = map.keySet();
        for (String key : keyset) {
            // 将以大写开头的字符串转换为小写，如果包含下画线也会处理为驼峰
            // 此处只通过这两个简单的标识来判断是否进行转换
            boolean isUpperCase = key.charAt(0) >= 'A' && key.charAt(0) <= 'Z';
            boolean isHasLine = key.contains("_");
            if (isUpperCase || isHasLine){
                Object value = map.get(key);
                map.remove(key);
                map.put(underLineToCameHump(key),value);
            }
        }
    }

    /**
     * 将下画线风格转换为驼峰风格
     * @param inputString 画线风格
     * @return 驼峰风格
     */
    private String underLineToCameHump(String inputString) {
        StringBuilder key = new StringBuilder();
        boolean nextUpperCase = false;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (c == '_'){
                if (key.length() > 0){
                    nextUpperCase=true;
                }
            }else {
                if (nextUpperCase){
                    key.append(Character.toUpperCase(c));
                    nextUpperCase = false;
                }else {
                    key.append(Character.toLowerCase(c));
                }
            }
        }
        return key.toString();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}
