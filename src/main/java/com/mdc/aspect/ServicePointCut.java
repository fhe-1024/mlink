package com.mdc.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ServicePointCut {

	private Log log = LogFactory.getLog(getClass());

	// @Pointcut("execution(* com.mdc.service.*.*(..))")
	// public void businessService() {
	// }
	//
	// @Before("businessService()")
	// public void beforeService() {
	// log.info("before point invoked");
	// }
	//
	// @After("execution(* com.mdc.service.*.*(..))")
	// public void afterService() {
	// log.info("after point invoked");
	// }

	@Around("execution(* com.mdc.service.*.*(..))")
	public Object aroundService(ProceedingJoinPoint joinpoint) throws Throwable {
		log.info("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
		log.info("调用方法:" + joinpoint.getSignature().getDeclaringType().getName() + "."
				+ joinpoint.getSignature().getName());
		Object[] args = joinpoint.getArgs();
		for (int i = 0; i < args.length; i++) {
			log.info("参数[" + i + "]" + args[i]);
		}
		Object obj = joinpoint.proceed();
		log.info("返回结果:" + obj.toString());
		log.info("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
		return obj;
	}

}