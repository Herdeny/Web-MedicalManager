package com.github.herdeny.webmedicalmanager.interceptors;

import com.github.herdeny.webmedicalmanager.utils.JwtUtil;
import com.github.herdeny.webmedicalmanager.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        //令牌验证
        String token = request.getHeader("Authorization");
        //验证token
        try {
            System.out.println(token);
            Map<String, Object> UserMap = JwtUtil.parseToken(token);
            System.out.println(UserMap);
            ThreadLocalUtil.set(UserMap);
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, Exception ex) {
        ThreadLocalUtil.remove();
    }

}
