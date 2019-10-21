package com.zlin.aspect;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Repository
@Aspect
public class MyAspect {

    private static final Logger logger = Logger.getLogger(MyAspect.class);

    @Pointcut(value = "execution(* com.zlin.service.*.*(..))")
    public void serviceLog(){

    }

    /**
     * 前置通知
     * 在切入点之前执行
     */
//    @Before("execution(* com.zlin.service.impl.UserServiceImpl.selectAllUser(..))")
//    @Before("execution(* com.zlin.service.UserService.*(..))")
    @Before(value = "serviceLog()")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知...");
        ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttribute.getRequest();
        logger.info("------------------start-----------------------");
        // 打印请求参数相关日志
        // 打印请求url
        logger.info("url:"+httpServletRequest.getRequestURI());
        // 打印 Http Method
        logger.info("Http Method:"+httpServletRequest.getMethod());

        logger.info("Class Method:"+joinPoint.getSignature().getDeclaringTypeName()+","+joinPoint.getSignature().getName());
        // 打印请求IP
        logger.info("IP:"+httpServletRequest.getRemoteAddr());
        // 打印请求入参
        logger.info("Request Args:"+new Gson().toJson(joinPoint.getArgs()));

    }

    /**
     * 后置通知
     * returnVal,切点方法执行后的返回值
     */
//    @AfterReturning(value="execution(* com.zlin.service.UserService.*(..))",returning = "returnVal")
    @AfterReturning(value = "serviceLog()", returning = "returnVal")
    public void afterReturning(Object returnVal){
        System.out.println("后置通知...."+returnVal);
    }

    /**
     * 环绕通知
     * @param joinPoint 可用于执行切点的类
     * @return
     * @throws Throwable
     */
//    @Around(value="execution(* com.zlin.service.UserService.*(..))")
    @Around(value = "serviceLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("环绕通知前...");
        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        // 打印出参
        logger.info("Response Args:"+ new Gson().toJson(obj));
        // 执行耗时
        logger.info("Time-Consuming:"+(endTime-startTime));
        System.out.println("环绕通知后...");
        return obj;
    }

    /**
     * 异常通知
     */
//    @AfterThrowing(value="execution(* com.zlin.service.UserService.*(..))", throwing = "throwable")
    @AfterThrowing(value = "serviceLog()", throwing = "throwable")
    public void afterThrowable(Throwable throwable){
        System.out.println("出现异常:msg="+throwable.getMessage());
    }

    /**
     * 无论什么情况下都会执行的方法
     * 在切入点之后执行
     */
//    @After(value="execution(* com.zlin.service.UserService.*(..))")
    @After(value = "serviceLog()")
    public void after(){
        System.out.println("最终通知...");
        logger.info("-------------------end---------------");
    }
}
