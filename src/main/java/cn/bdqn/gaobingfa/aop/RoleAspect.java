package cn.bdqn.gaobingfa.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class RoleAspect {
    // * 代表任意返回类型的方法
    @Before("execution(* cn.bdqn.gaobingfa.aop.RoleServiceImpl.print(..))")
    public void before(){
        System.out.println("*****before**");
    }
    @After("execution(* cn.bdqn.gaobingfa.aop.RoleServiceImpl.print(..))")
    public  void  after(){
        System.out.println("*********after******");
    }
    @AfterReturning("execution(* cn.bdqn.gaobingfa.aop.RoleServiceImpl.print(..))")
    public void afterreturning(){
        System.out.println("********afterReturning***");
    }
    @AfterThrowing("execution(* cn.bdqn.gaobingfa.aop.RoleServiceImpl.print(..))")
    public void afterThrowing(){
        System.out.println("******afterThrowing***");
    }

    @Pointcut("execution(* cn.bdqn.gaobingfa.aop.RoleServiceImpl.print(..))")
    public void print(){

    }
    @Around("print()")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("*****aroud before****");

        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new RuntimeException("异常需要切面捕捉");
        }
    }
}
