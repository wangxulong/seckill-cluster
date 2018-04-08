package com.wang.demo.seckill.util;

import org.springframework.http.HttpRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    private final static String COOKIE_DOMAIN = ".";
    private final static String COOKIE_LOGIN_TOKEN="cookie_login_token";

    public static void writeLoginToken(HttpServletResponse response,String token){
        Cookie cookie = new Cookie(COOKIE_LOGIN_TOKEN,token);
        cookie.setDomain(COOKIE_DOMAIN);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24*39);
        response.addCookie(cookie);
    }

    public static String readLoginToken(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals(COOKIE_LOGIN_TOKEN)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void delLoginToken(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals(COOKIE_LOGIN_TOKEN)){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }

    }

}
