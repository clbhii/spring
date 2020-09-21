package com.cl.security.core.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * by cl at 2020/8/24 0024
 */
public class SysSecurityContextHolder {

    private static ThreadLocal<String> sysIdThreadLocal = new ThreadLocal<>();

    public static CurrentSysUser getCurrentUser(){
        SecurityContext context = SecurityContextHolder.getContext();
        if(context == null) {
            return null;
        }
        Authentication authentication = context.getAuthentication();
        if(authentication == null) {
            return null;
        }
        return (CurrentSysUser) authentication.getPrincipal();
    }

    public static void setSysId(String sysId){
        sysIdThreadLocal.set(sysId);
    }
    public static void getSysId(){
        sysIdThreadLocal.get();
    }
    public static void removeSysId(){
        sysIdThreadLocal.remove();
    }
}
