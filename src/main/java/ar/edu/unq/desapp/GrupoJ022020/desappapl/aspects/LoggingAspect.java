package ar.edu.unq.desapp.GrupoJ022020.desappapl.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class LoggingAspect {
	private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class.getName());

    @Pointcut("within(ar.edu.unq.desapp.GrupoJ022020.desappapl.webservice.*) || @annotation(ar.edu.unq.desapp.GrupoJ022020.desappapl.aspects.LogExecutionTime)")
    public void loggableMethods() {
    }

    @Before("loggableMethods()")
    public void logMethod(JoinPoint jp) {
    	CodeSignature methodSignature = (CodeSignature) jp.getSignature();
        String methodName = methodSignature.getName();
        String methodParameters = "";
        if (methodSignature.getParameterNames() != null) {
        	String[] methodSignatureParameters = methodSignature.getParameterNames();
        	methodParameters = " with parameters(";
        	for(int i = 0; i < methodSignatureParameters.length; i++)
        		methodParameters +=  methodSignatureParameters[i] + "=" + jp.getArgs()[i] + ", ";
        	if(methodParameters != " with parameters(")
        		methodParameters = methodParameters.substring(0, methodParameters.length()-2) + ")";
        	else
        		methodParameters = "";
        }
        logger.info("Executing method: '" + methodName + "'" + methodParameters);
    }
    
    @Around("loggableMethods()")
	public Object logExecutionTimeAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
		final long start = System.currentTimeMillis();
		final Object proceed = joinPoint.proceed();
		final long executionTime = System.currentTimeMillis() - start;
		logger.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
		return proceed;
	}
}
