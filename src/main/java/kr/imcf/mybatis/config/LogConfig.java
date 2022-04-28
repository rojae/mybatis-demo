package kr.imcf.mybatis.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
@Aspect
public class LogConfig {

  @Around("within(kr.imcf.mybatis..*) && !@annotation(kr.imcf.mybatis.config.LogExclusion) && @annotation(kr.imcf.mybatis.config.LogInclusion))")
  public Object logging(ProceedingJoinPoint procJoinPoint) throws Throwable { // 2

    String params = getRequestParams(); // request 값 가져오기

    long startAt = System.currentTimeMillis();

    log.info("-----------> REQUEST : {}({}) = {}", procJoinPoint.getSignature().getDeclaringTypeName(),
        procJoinPoint.getSignature().getName(), params);

    Object result = procJoinPoint.proceed(); // 4

    long endAt = System.currentTimeMillis();

    log.info("-----------> RESPONSE : {}({}) = {} ({}ms)", procJoinPoint.getSignature().getDeclaringTypeName(),
        procJoinPoint.getSignature().getName(), result, endAt - startAt);

    return result;
  }


  private String paramMapToString(Map<String, String[]> paramMap) {
    return paramMap.entrySet().stream()
        .map(entry -> String.format("%s -> (%s)",
            entry.getKey(), String.join(",", entry.getValue())))
        .collect(Collectors.joining(", "));
  }

  // Get request values 
  private String getRequestParams() {

    String params = "empty";

    RequestAttributes requestAttributes = RequestContextHolder
        .getRequestAttributes(); // 3

    if (requestAttributes != null) {
      HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
          .getRequestAttributes()).getRequest(); 

      Map<String, String[]> paramMap = request.getParameterMap();
      if (!paramMap.isEmpty()) {
        params = " [" + paramMapToString(paramMap) + "]";
      }
    }

    return params;
  }
}