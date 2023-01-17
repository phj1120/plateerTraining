package com.plateer.todo.todo.controller.interceptor;

import com.google.gson.Gson;
import com.plateer.todo.common.annotations.JWTAuth;
import com.plateer.todo.common.util.JWTUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
public class TodoInterceptor implements HandlerInterceptor {

    private final JWTUtil jwtUtil;

    private static enum ERRORCODE {
        NOTOKEN(401, "NOTOKEN"),
        BADKEY(401, "BADKEY"),
        EXPIRED(403, "EXPIRED"),
        MALFORMED(403, "MALFORMED");

        private int code;
        private String msg;

        ERRORCODE(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }

        log.info("TodoInterceptor1.........................");

        HandlerMethod method = (HandlerMethod) handler;
        Annotation jwtAuth = method.getMethodAnnotation(JWTAuth.class);
        if (jwtAuth == null) {
            return true;
        }

        //Authorization header 추출 -
        //헤더가 없다면 'NOTOKEN 401'
        String headerValue = request.getHeader("Authorization");

        log.info("headerValue :" + headerValue);

        if (headerValue == null) {
            sendErrorMsg(ERRORCODE.NOTOKEN, response);
            return false;
        }

        log.info("TodoInterceptor2.........................");
        log.info(jwtUtil);

        //7 Bearer
        String acessTokenStr = headerValue.substring(7);

        log.info("TodoInterceptor3.........................");

        try {
            jwtUtil.validateToken(acessTokenStr);
        } catch (SignatureException se) {
            sendErrorMsg(ERRORCODE.BADKEY, response);
            return false;
        } catch (ExpiredJwtException je) {
            sendErrorMsg(ERRORCODE.EXPIRED, response);
            return false;
        } catch (MalformedJwtException me) {
            sendErrorMsg(ERRORCODE.MALFORMED, response);
            return false;
        }

        log.info("TodoInterceptor4.........................");
        log.info("TodoInterceptor5.........................");


        return true;
    }

    private void sendErrorMsg(ERRORCODE errorcode, HttpServletResponse response) {

        int code = errorcode.getCode();
        String msg = errorcode.getMsg();

        response.setStatus(code);

        Gson gson = new Gson();

        String jsonStr = gson.toJson(Map.of("msg", msg));

        response.setContentType("application/json");

        try (PrintWriter out = response.getWriter()) {

            out.write(jsonStr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}















