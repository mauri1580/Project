package com.team1.bb.config.security;

/**
 * Contains an array of urls that should be unprotected by Spring Security
 */
public class PermitAllUrls {

    public static String[] getUrls() {
        return new String[]{
                "/",
                "/index.html",
                "/build/**",
                "/assets/**",
                "/login/**",
                "/management/info",
                "/management/health",
                "/h2-console/**",
                "/api/authenticated"
        };
    }

}
