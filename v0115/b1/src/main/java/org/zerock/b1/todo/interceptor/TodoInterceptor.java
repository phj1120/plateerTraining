package org.zerock.b1.todo.interceptor;


import lombok.extern.log4j.Log4j2;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.zerock.b1.common.annotations.JWTAuth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class TodoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // handler : controller 의 메서드
        HandlerMethod method = (HandlerMethod) handler;
        log.info("TodoInterceptor.....");
        log.info(method.getMethod().getName());
        JWTAuth authAnnotation = method.getMethodAnnotation(JWTAuth.class);
        log.info(authAnnotation);
        if (authAnnotation != null) {
            log.info("CHECK JWT");
        }

        return true;
    }
}
