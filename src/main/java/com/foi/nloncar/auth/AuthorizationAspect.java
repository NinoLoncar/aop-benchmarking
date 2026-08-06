package com.foi.nloncar.auth;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AuthorizationAspect {

    @Before("execution(* com.foi.nloncar.auth.AccountService.withAspectCheck(..))")
    public void checkPermission() {
        if (!"READ".equals(SecurityContext.currentPermission())) {
            throw new AuthorizationException("missing permission READ");
        }
    }
}
