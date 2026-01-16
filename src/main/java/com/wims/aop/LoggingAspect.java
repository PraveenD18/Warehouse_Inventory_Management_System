package com.wims.aop;

import com.wims.logging.AppLogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Pointcut("execution(* com.wims.warehouse.service..*(..))")
	public void serviceLayer() {
	}

	@Pointcut("execution(* com.wims.warehouse.controller..*(..))")
	public void controllerLayer() {
	}

	@Pointcut("serviceLayer() || controllerLayer()")
	public void applicationLayer() {
	}

	@Around("applicationLayer()")
	public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
		Logger log = AppLogger.getLogger(joinPoint.getTarget().getClass());
		String methodName = joinPoint.getSignature().toShortString();
		long startTime = System.currentTimeMillis();
		log.debug("Entering {}", methodName);
		try {
			Object result = joinPoint.proceed();
			long elapsedTime = System.currentTimeMillis() - startTime;
			log.debug("Exiting {} | Time taken: {} ms", methodName, elapsedTime);
			return result;

		} catch (Throwable ex) {
			log.error("Exception in {} : {}", methodName, ex.getMessage());
			throw ex;
		}
	}
}
