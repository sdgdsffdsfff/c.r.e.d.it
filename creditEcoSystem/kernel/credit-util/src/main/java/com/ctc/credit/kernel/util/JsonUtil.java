package com.ctc.credit.kernel.util;

import java.text.SimpleDateFormat;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.PropertySetStrategy;


public class JsonUtil {

	public static <T> Object getBean(JSONObject jsonObject, Class<T> clazz) {
		// 声明JsonConfig对象
		JsonConfig cfg = new JsonConfig();
		// 设置属性包装器
		cfg.setPropertySetStrategy(new PropertyStrategyWrapper(
				PropertySetStrategy.DEFAULT));
		// 设置要转换成的JavaBean
		cfg.setRootClass(clazz);
		// 转换
		Object object = JSONObject.toBean(jsonObject, cfg);
		return object;
	}
	
	
	public static String toString(Object jsonClass) {
		// 声明JsonConfig对象
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter(){
            @Override
            public boolean apply(Object source, String name, Object value) {
                return value == null || value.toString().isEmpty();
            }
        });
		
		JSONObject jo = JSONObject.fromObject(jsonClass,cfg);
		return jo.toString();
	}
	
	public static JsonConfig getDateJsonConfig() {
		JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class,new JsonValueProcessor() {
            private final String format="yyyy-MM-dd HH:mm:ss";
            public Object processObjectValue(String key, Object value,JsonConfig arg2){
              if(value==null)
                    return "";
              if (value instanceof java.util.Date) {
                    String str = new SimpleDateFormat(format).format((java.util.Date) value);
                    return str;
              }
                    return value.toString();
            }
      
            public Object processArrayValue(Object value, JsonConfig arg1){
                       return null;
            }
         });
		return jsonConfig;
	}
}
