package org.parkh.b1.todo.interceptor;

import lombok.extern.log4j.Log4j2;
import org.parkh.b1.common.annotation.JWTAuth;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class TodoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // handler : controller 의 메서드
        log.info(handler);
        try {
            HandlerMethod method = (HandlerMethod) handler;

            log.info("TodoInterceptor");
            log.info(method.getMethod().getName());
            JWTAuth annotation = method.getMethodAnnotation(JWTAuth.class);
            if (annotation != null) {
                log.info("Required JWT");
            }
        } catch (ClassCastException e) {
            log.error(e.getMessage());
        }
        return true;
    }
}
