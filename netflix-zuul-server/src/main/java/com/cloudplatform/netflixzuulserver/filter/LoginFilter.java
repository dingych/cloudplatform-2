package com.cloudplatform.netflixzuulserver.filter;

import com.cloudplatform.common.utils.IpUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Component
public class LoginFilter extends ZuulFilter {

    public static final List<String> PASS_STR = Arrays.asList("config");

    private static Logger log = LoggerFactory.getLogger(LoginFilter.class);


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 拦截路径过滤以及放行执定服务的请求,返回true则进入权限判定，返回false则直接请求网关对应的服务
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        log.info("真实IP:" + IpUtil.getIPAddress(request));
        // 遍历查询url是否包含list中的字符串 ,包含则跳过登录校验
        if (PASS_STR.stream().anyMatch(x -> {
            if (request.getRequestURI().contains(x)) {
                log.info("放弃拦截：" + x + " 服务");
                return true;
            }
            return false;
        })) {
            return false;
        }
        log.info("成功拦截，进入run方法");
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        boolean pass = false;
        log.info("拦截请求路径:" + request.getRequestURI());
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userId")) {
                    pass = true;
                    break;
                }
            }
        }
        // cookie 验证不通过
        if (!pass) {
            try {
                ctx.addZuulResponseHeader("Access-Control-Allow-Headers", "content-type,x-requested-with");
                ctx.addZuulResponseHeader("Access-Control-Allow-Origin", "*");
                ctx.addZuulResponseHeader("Access-Control-Allow-Credentials", "true");
                ctx.addZuulResponseHeader("content-type", "application/json;charset=utf-8");
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(200);
                ctx.getResponse().setContentType("text/html;charset=utf-8");
                ctx.getResponse().setCharacterEncoding("UTF-8");
                ctx.getResponse().getWriter().write("请登录");
            } catch (Exception e) {
            }
        }
        log.info("已登录，继续操作");
        return null;
    }
}
