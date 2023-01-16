package project.ntsk.common.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class NtskLogAspect {

	/**
	 * メソッド開始
	 */
	@Before("execution(* project.ntsk.application.controller.*Controller.*(..))")
	public void startLog(JoinPoint joinPoint) {
		log.info("★Start {}.{}", joinPoint.getSignature().getDeclaringType().getName(),
				joinPoint.getSignature().getName());
	}

	/**
	 * メソッド終了
	 */
	@AfterReturning("execution(* project.ntsk.application.controller.*Controller.*(..))")
	public void endLog(JoinPoint joinPoint) {
		log.info("★End {}.{}", joinPoint.getSignature().getDeclaringType().getName(),
				joinPoint.getSignature().getName());
	}

	/**
	 * 例外発生時
	 */
	@AfterThrowing(value = "execution(* project.ntsk..*(..))", throwing = "e")
	public void afterException(JoinPoint joinPoint, Exception e) {
		log.error("★Error!, Exception: {}, {}.{}", e.getMessage(),
				joinPoint.getSignature().getDeclaringType().getName(), joinPoint.getSignature().getName());
	}

}
