package ar.edu.unq.desapp.GrupoJ022020.desappapl.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class LoggingAspect {
	private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class.getName());

    @Pointcut("within(ar.edu.unq.desapp.GrupoJ022020.desappapl..*) || @annotation(ar.edu.unq.desapp.GrupoJ022020.desappapl.aspects.LogExecutionTime)")
    public void loggableMethods() {
    }

    @Before("loggableMethods()")
    public void logMethod(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info("Executing method: " + methodName);
    }
}
