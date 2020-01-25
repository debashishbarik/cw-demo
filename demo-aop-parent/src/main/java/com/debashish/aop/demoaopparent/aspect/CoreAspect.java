package com.debashish.aop.demoaopparent.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CoreAspect {

    @Pointcut("execution(* com.debashish.aop.demoaopparent.service.*.*(..))")
    public void k(){}//pointcut name


    @Before("k()")//applying pointcut on before advice
    public void myadvice(JoinPoint jp)//it is advice (before advice)
    {
     //   System.out.println("Before concern");
        System.out.println("[B]Method Signature: "  + jp.getTarget().getClass().getName()+"."  + jp.getSignature().getName());
    }


    @After("k()")//applying pointcut on before advice
    public void myadviceAfter(JoinPoint jp)//it is advice (before advice)
    {
       // System.out.println("After concern");
        System.out.println("[A]Method Signature: "  + jp.getTarget().getClass().getName()+"."  + jp.getSignature().getName());
    }


    @Around("k()")
    public Object aroundWebMethodE(ProceedingJoinPoint pjp) throws Throwable {
        String packageName = pjp.getSignature().getDeclaringTypeName();
        String methodName = pjp.getSignature().getName();
     //   System.out.println("packageName::"+pjp.getTarget().getClass().getCanonicalName());
       // System.out.println("methodName::"+pjp.getTarget().getClass().getName());
        long start = System.currentTimeMillis();
        if(!pjp.getSignature().getName().equals("initBinder")) {
         //   System.out.println("Entering method [" + packageName + "." + methodName +  "]");
        }
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        if(!methodName.equals("initBinder")) {
            String packageNameC=pjp.getTarget().getClass().getCanonicalName();
            System.out.println("Exiting method [" + packageNameC + "." + methodName + "]; exec time (ms): " + elapsedTime);
        }
        return output;
    }
}
