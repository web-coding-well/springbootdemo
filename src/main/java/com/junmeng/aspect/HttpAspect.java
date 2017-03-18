package com.junmeng.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 面向切面（AOP）实例
 * Created by HWJ on 2017/3/18.
 */
@Aspect
@Component
public class HttpAspect {

    public static final Logger logger = org.slf4j.LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.junmeng.controller.UserController.*(..))")
    public void log() {
    }


    //拦截UserController的请求，后面的两个点表示任何参数
    //经常用来做登录验证
    //@Before("execution(public * com.junmeng.controller.UserController.*(..))")
    @Before("log()")//这种方法是减少重复的代码
    public void doBefore(JoinPoint joinPoint) {
        logger.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        logger.info("url={}", request.getRequestURI());

        logger.info("method={}", request.getMethod());

        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    //@After("execution(public * com.junmeng.controller.UserController.*(..))")
    @After("log()")
    public void doAfter() {
        logger.info("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
    }

    /**
     * 此注解用来打印返回对象的信息，这个对于调试也是非常有用的
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}",object==null?"return null": object.toString());
    }

}
