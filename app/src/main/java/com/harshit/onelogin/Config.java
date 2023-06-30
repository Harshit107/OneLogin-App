package com.harshit.onelogin;

public class Config {

    private static final String DEV_SERVER = "http://localhost:3001/";
    private static final String PROD_SERVER = "http://localhost:3001/";

    public static final String LOGIN = DEV_SERVER + "public/users/login";
    public static final String CREATE = DEV_SERVER + "public/users/create";
    public static final String IS_VERIFIED = DEV_SERVER + "public/users/isVerified";
    public static final String IS_LOGIN = DEV_SERVER + "public/users/isLogedIn";
    public static final String PROFILE = DEV_SERVER + "public/users/profile";


    public static final String LOGOUT = DEV_SERVER + "public/users/logout";
    public static final String LOGOUT_FROM_ALL_DEVICE = DEV_SERVER + "public/users/logout/all";
    public static final String LOGOUT_FROM_SPECIFIC_DEVICE = DEV_SERVER + "public/users/logout/device";
    public static final String LOGOUT_FROM_ALL_EXCEPT_CURRENT = DEV_SERVER + "public/users/logout/all/current";



}
