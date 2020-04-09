package com.nkpdqz.spingboot_aop_demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
@Aspect
public class LogAspect {

    private final static Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.nkpdqz.spingboot_aop_demo.controller..*.*(..))")
    public void controllerLog(){

    }

    @Before("controllerLog()")
    public void logBeforeController(JoinPoint joinPoint){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        log.info("###################request 参数#############\n"+request.getRequestURI());
        log.info(request.getMethod());
        log.info(request.getRemoteAddr());
        log.info("##############################类和方法参数#########################################");
        log.info(Arrays.toString(joinPoint.getArgs()));
        log.info(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info(joinPoint.getTarget().toString());
        log.info(joinPoint.getThis().toString());
    }

    @After("controllerLog()")
    public void logAfterController(JoinPoint joinPoint){
        log.info("After");
    }

    @Around("controllerLog()")
    public Object aroundController(ProceedingJoinPoint joinPoint){
        try {
            log.info("####################brfore");
            Object proceed = joinPoint.proceed();
            log.info("#####################after");
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return throwable;
        }
    }

    @AfterReturning(returning = "o",pointcut = "controllerLog()")
    public void doAfterController(JoinPoint joinPoint,Object o){
        log.info(o.toString());
    }

}
