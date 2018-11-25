package com.dsm.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class DsmAspect {

    @Pointcut("@annotation(com.dsm.aopdemo.anno.Dsm)")
    private void cut(){}

    @Around("cut()")
    public void advice(ProceedingJoinPoint joinPoint){
        System.out.println("环绕通知之开始");
        for(Object obj : joinPoint.getArgs()){
            if(obj instanceof HttpServletRequest){
                HttpServletRequest req = (HttpServletRequest)obj;
                System.err.println(req.getParameter("id"));
            }
        }
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("环绕通知之结束");
    }
}
