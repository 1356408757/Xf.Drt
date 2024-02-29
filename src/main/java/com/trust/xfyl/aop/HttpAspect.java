package com.trust.xfyl.aop;

import com.trust.xfyl.entity.ResultVO;
import net.sf.json.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 所有http的请求都会进入到这里
 * @author LENOVO
 */
@Aspect
@Component
public class HttpAspect {

    private static final Logger loggerInfo = LoggerFactory.getLogger("HttpAspect");

    /**
    * @Author djj
    * @Description //TODO 定义切点
    * @Date 17:13 2024/2/4
    * @Param []
    * @return void
    **/
    @Pointcut("execution(public  * com.trust.xfyl.controller.*.*(..))")
     void exception() {

    }

    /**
     * @return java.lang.Object
     * @Author djj
     * @Description //TODO
     * @Date 11:31 2024/2/4
     * @Param [pjp]
     **/
    @Around("exception()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //url
        String url = request.getRequestURL().toString();
        //method
        String method = request.getMethod();
        // ip
        String remoteAddr = request.getRemoteAddr();
        //类,方法
        String classMethod = pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName();
        //参数
     /*   Object[] args = pjp.getArgs();
        StringBuilder params=new StringBuilder();
        for (Object arg : args) {
            if(arg instanceof StandardMultipartHttpServletRequest || arg instanceof MultipartFile){
                    continue;
            }else{
                //System.out.println(arg);
                params.append(JSONArray.fromObject(arg).toString());
            }
        }*/
        Object[] args = pjp.getArgs();
        String params = Arrays.toString(args);

         System.out.println("url={},method={},remoteAddr={},classMethod={},args={}+"+url+method+remoteAddr+classMethod+args);
        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行，result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        String jsonResult = "";
        jsonResult = result.toString();
        if (result instanceof ResultVO) {
            jsonResult = JSONObject.fromObject(result).toString();
        } else {
            jsonResult = result.toString();
        }
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        loggerInfo.info("{},url={},method={},remoteAddr={},classMethod={},args={},result={}", now, url, method, remoteAddr, classMethod, params, jsonResult);
        loggerInfo.info("{}", now);
        loggerInfo.info("url={}", url);
        loggerInfo.info("method={}", method);
        loggerInfo.info("remoteAddr={}", remoteAddr);
        loggerInfo.info("classMethod={}", classMethod);
        loggerInfo.info("args={}", params);
        loggerInfo.info("result={}", jsonResult);
        loggerInfo.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        loggerInfo.info("------------------------------------------------------------------------------------------------------------------------------");
        return result;

    }


}
