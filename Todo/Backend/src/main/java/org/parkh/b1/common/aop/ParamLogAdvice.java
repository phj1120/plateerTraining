package org.parkh.b1.common.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Log4j2
public class ParamLogAdvice {

    @Before("execution(* org.parkh.b1.todo.service.TodoService.*(..))")
    public void logBefore(JoinPoint jp) {
        log.info("--------------[AOP Before]--------------");
        log.info(Arrays.toString(jp.getArgs()));
        log.info("----------------------------------------");
    }

    @Around("execution(* org.parkh.b1.todo.service.TodoService.*(..))")
    public Object checkTime(ProceedingJoinPoint pjp) throws Throwable {
        log.info("--------------[AOP Around]--------------");
        long start = System.currentTimeMillis();

        log.info(pjp.getArgs());

        Object result = pjp.proceed();

        long end = System.currentTimeMillis();
        log.info("[Time] : {} ms", end - start);
        log.info("----------------------------------------");

        return result;
    }


}
