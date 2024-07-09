package com.thevmin.movie_store_with_security.configurations;

public class Constants {

    private Constants(){
        throw new IllegalStateException("Utility class");
    }

    public static final String AUTH_URL = "/api/v1/auth";
    public static final String MOVIE_URL = "/api/v1/movies";
    public static final String USER_URL = "/api/v1/users";
    public static final String REVIEW_URL = "/api/v1/reviews";

    public static final String LOGIN_URL_CONSTANT = "/login";
    public static final String REFRESH_URL_CONSTANT = "/refresh";
    public static final String LOGOUT_URL_CONSTANT = "/logout";
    public static final String REGISTER_URL_CONSTANT = "/register";

}
