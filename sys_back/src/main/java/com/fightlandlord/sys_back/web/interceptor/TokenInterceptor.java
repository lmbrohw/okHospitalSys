package com.fightlandlord.sys_back.web.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fightlandlord.sys_back.util.JwtToken;
import com.fightlandlord.sys_back.util.Response;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    private JwtToken jwtToken ;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = request.getParameter("token");
        System.out.println("token:" + token);
        int result = 0;
        if(token != null){
            result = JwtToken.verify(token);
            if(result == 1){
                return true;
            }
        }
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        try{
            Map<String, Object> jsonMap = new HashMap<String, Object>();
            jsonMap.put("success", false);
            jsonMap.put("code", 404);
            jsonMap.put("message", "认证失败！");
            jsonMap.put("data", null);

            response.getWriter().print(new JSONObject(jsonMap));
        }catch (Exception e){
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
