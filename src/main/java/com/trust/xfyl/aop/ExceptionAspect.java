package com.trust.xfyl.aop;

import com.aliyuncs.exceptions.ClientException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ExceptionAspect {

    private static final Logger loggerError = LoggerFactory.getLogger("my_aop_error");
    private static final Logger loggerInfo = LoggerFactory.getLogger("my_aop_exe");

    //定义切点
    @Pointcut("execution(public * com.trust.xfyl.controller.*.*(..))")
    public void exception() {
    }

    @Before(("exception()"))
    public void executeFunction(JoinPoint joinPoint) {
        /*获取进入方法的类名和方法名*/
        loggerInfo.info("execute " + joinPoint.getSignature().getDeclaringTypeName() +
                "." + joinPoint.getSignature().getName());
        /*  loggerInfo.info("execute"+joinPoint.getSignature().getDeclaringTypeName()+""+joinPoint.getSignature().getName());*/
    }

    @Around("exception()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> returnMap = new HashMap<String, Object>();
        try {
            return proceedingJoinPoint.proceed();
        } catch (JsonProcessingException e) {
            returnMap.put("status", "-1");
            returnMap.put("msg", "JSON转换异常");
            e.printStackTrace();
        } catch (ClientException e) {
            returnMap.put("status", e.getErrCode());
            returnMap.put("msg", e.getMessage());
        } catch (IOException e) {
            returnMap.put("status", "-100");
            returnMap.put("msg", "文件读写异常");
        } catch (Exception e) {
            returnMap.put("status", "-99");
            returnMap.put("msg", "服务器异常");
            e.printStackTrace();
        } catch (Throwable e) {
            returnMap.put("status", "-101");
            //returnMap.put("msg","aop执行切点异常");
            returnMap.put("msg", "------------------------------------" + e);
        }
        String json = null;
        try {
            json = mapper.writeValueAsString(returnMap);
            if (!"{}".equals(json)) {
                loggerError.error(json);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }


}
