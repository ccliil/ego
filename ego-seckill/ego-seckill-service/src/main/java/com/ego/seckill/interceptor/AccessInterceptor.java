package com.ego.seckill.interceptor;

import com.ego.auth.entity.UserInfo;
import com.ego.common.response.CodeMsg;
import com.ego.common.response.Result;
import com.ego.common.utils.JsonUtils;
import com.ego.seckill.access.AccessLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;


@Service
public class AccessInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            AccessLimit accessLimit = handlerMethod.getMethodAnnotation(AccessLimit.class);
            if (accessLimit == null){
                return true;
            }

            //获取用户信息
            UserInfo userInfo = LoginInterceptor.getLoginUser();
            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maxCount();
            boolean needLogin = accessLimit.needLogin();
            String key = request.getRequestURI();
            if (needLogin){
                if (userInfo == null){
                    render(response, CodeMsg.LOGIN_ERROR);
                    return false;
                }
                key += "_" + userInfo.getId();
            }else {
                //不需要登录，则什么也不做
            }
            String count = redisTemplate.opsForValue().get(key);
            if (count == null){
                redisTemplate.opsForValue().set(key,"1",seconds, TimeUnit.SECONDS);
            }else if(Integer.valueOf(count) < maxCount){
                redisTemplate.opsForValue().increment(key,1);
            }else {
                render(response,CodeMsg.ACCESS_LIMIT_REACHED);
            }

        }

        return super.preHandle(request, response, handler);
    }

    private void render(HttpServletResponse response, CodeMsg cm) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        String str  = JsonUtils.serialize(Result.error(cm));
        out.write(str.getBytes("UTF-8"));
        out.flush();
        out.close();
    }
}
