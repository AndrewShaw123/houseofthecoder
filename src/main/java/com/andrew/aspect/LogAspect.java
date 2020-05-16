package com.andrew.aspect;

import com.andrew.annotation.MyLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Class
 *
 * @author andrew
 * @date 2020/3/11
 */
@Component
@Aspect
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    private static final String OPERATION_TYPE = "operationType";
    private static final String OPERATION_NAME = "operationName";

    //"execution(* com.andrew.service.*.*.*(..))"

    @Pointcut("@annotation(com.andrew.annotation.MyLog)")
    public  void serviceAspect() {}

    @Before("serviceAspect()")
    public void doBefore(JoinPoint joinPoint) {
        Map<String, String> logInfo = getLogInfo(joinPoint);
        logger.info("操作名称："+logInfo.get(OPERATION_NAME));
        logger.info("操作类型："+logInfo.get(OPERATION_TYPE));
        logger.info("状态：开始执行");
    }

    @AfterReturning("serviceAspect()")
    public void doAfter(JoinPoint joinPoint){
        Map<String, String> logInfo = getLogInfo(joinPoint);
        logger.info("操作名称："+logInfo.get(OPERATION_NAME));
        logger.info("操作类型："+logInfo.get(OPERATION_TYPE));
        logger.info("状态：完成");
    }

    @AfterThrowing(pointcut = "serviceAspect()",throwing="e")
    public void doThrowing(JoinPoint joinPoint,Throwable e){
        Map<String, String> logInfo = getLogInfo(joinPoint);
        logger.error("操作名称："+logInfo.get(OPERATION_NAME));
        logger.error("操作类型："+logInfo.get(OPERATION_TYPE));
        logger.error("状态：异常");
        logger.error("异常信息："+e.getMessage());
        logger.error("异常代码："+e.getClass().getName());

    }

    private Map<String,String> getLogInfo(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        MyLog myLog = method.getAnnotation(MyLog.class);
        Map<String,String> map = new HashMap<>(2);
        map.put(OPERATION_TYPE,myLog.operationType());
        map.put(OPERATION_NAME,myLog.operationName());
        return map;
    }

}
