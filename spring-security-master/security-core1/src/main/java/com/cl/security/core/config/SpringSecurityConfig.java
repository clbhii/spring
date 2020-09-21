package com.cl.security.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@Configuration
@EnableWebSecurity //1
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    @Autowired
    private SysIdFilter sysIdFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http
                // 关闭csrf防护
                .csrf().disable()
                .headers().frameOptions().disable()
                .and();
//        http.formLogin()  //2
//            .and()
//                .authorizeRequests() //3
//                .antMatchers("/index","/").permitAll() //4
//                .anyRequest().authenticated(); //6

        http.formLogin().loginPage("/loginPage").loginProcessingUrl("/form")
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(customAuthenticationFailureHandler)
                .and()
                .authorizeRequests() //3
                .antMatchers("/index","/", "/loginPage", "/login", "/form", "/favicon.ico").permitAll() //4
                .anyRequest().authenticated(); //

        http.addFilterAfter(sysIdFilter, AbstractPreAuthenticatedProcessingFilter.class);
    }
}