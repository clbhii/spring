package com.cl.security.core.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class SysIdFilter extends OncePerRequestFilter  {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        log.info("sysId filter");
        String sysId = request.getParameter("sysId");
//        try{
//
//            if(StringUtils.isEmpty(sysId)){
//                throw new RuntimeException("sysId不能为空");
//            }
//            CurrentSysUser currentUser = SysSecurityContextHolder.getCurrentUser();
//            if(currentUser != null) {
//                if(sysId.equals(currentUser.getSysId())){
//                    throw new RuntimeException("当前用户和系统不匹配");
//                }
//            }
//
//        }catch (Exception e) {
//            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            response.setContentType("application/json;charset=UTF-8");
//            response.getWriter().write(e.getMessage());
//            return;
//        }

        try{
            SysSecurityContextHolder.setSysId(sysId);
            chain.doFilter(request, response);
        } finally {
            SysSecurityContextHolder.removeSysId();
        }

    }

}