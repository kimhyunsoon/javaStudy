package soo.md.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import lombok.extern.log4j.Log4j;

@Log4j
@Aspect
@Component
public class SampleLogAdvice { //Aspec 지시해주는 클래스
	@Before("execution(* soo.md.service.SampleLogService*.*(..))")
	public void logBefore() {
		log.info("#(3)logBefore() 수행");
	}
	
	@Around("execution(* soo.md.service.SampleLogService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		
		log.info("#(1)target class: " + pjp.getTarget().getClass());
		log.info("#(2)args: " + Arrays.deepToString(pjp.getArgs()));

		
        Object result = null;
        //try {
        	result = pjp.proceed(); //비지니스 메소드로 진행하도록 하는 메소드 
        //}catch(Throwable t) {
        //	log.info("#예외 발생  t: " + t);
        //}
		long end = System.currentTimeMillis();
		log.info("#(4)수행시간: " + ( end-start));
		
		return result;
	}
	
	@After("execution(* soo.md.service.SampleLogService*.*(..))")
	public void logAfter() {
	    log.info("#(5)logAfter() 수행");
	}
	@AfterThrowing(pointcut = "execution(* soo.md.service.SampleLogService*.*(..))", throwing = "exception")
	public void logAfterThrowing(Exception exception) {
		log.info("#(5)logAfterThrowing exception: " + exception);
	}
}
//https://icarus8050.tistory.com/8
//https://woongsin94.tistory.com/325
