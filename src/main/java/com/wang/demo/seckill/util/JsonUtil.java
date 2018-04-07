package com.wang.demo.seckill.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.wang.demo.seckill.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        //对象的全部字段全部列入
        //objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        //取消默认转换timestamps形式
       // objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS,false);
        //取消空bean返回错误
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        //统一的时间格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //忽略在JSON中存在，但是Java对象中不存在属性的情况，防止错误
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }

    public static <T> String obj2String(T obj){
        if(obj == null){
            return null;
        }
        try {
            return obj instanceof String?(String) obj:objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.warn("parse object to string error",e);
            return null;
        }
    }

    public static <T> String obj2StringPretty(T obj){
        if(obj == null){
            return null;
        }
        try {
            return obj instanceof String?(String) obj:objectMapper
                    .writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            log.warn("parse object to string error",e);
            return null;
        }
    }


    public static <T> T string2Obj(String str,Class<T> clazz){
        if(StringUtils.isEmpty(str) || clazz == null){
            return null;
        }
        try {
            return clazz.equals(String.class)?(T)str:objectMapper.readValue(str,clazz);
        } catch (IOException e) {
            log.warn("parse string to object error",e);
            return null;
        }
    }

    public static <T> T string2Obj(String str,TypeReference<T> typeReference){
        if(StringUtils.isEmpty(str) || typeReference == null){
            return null;
        }
        try {
            return (T)(typeReference.equals(String.class)?str:objectMapper.readValue(str,typeReference));
        } catch (Exception e) {
            log.warn("parse string to object error",e);
            return null;
        }
    }

    public static <T> T string2Obj(String str,Class<?> collectionClass,Class<?> ...elementClass){
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass,elementClass);
        try {
            return objectMapper.readValue(str,javaType);
        } catch (Exception e) {
            log.warn("parse string to object error",e);
            return null;
        }
    }



    public static void main(String[] args) {
        User user = new User();
        user.setId(123);
        User user1 = new User();
        user.setId(222);
        user1.setName("王旭龙");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        String usersStr = JsonUtil.obj2StringPretty(user);
        log.info(usersStr);



    }

}
