package com.ciandt.opencv;

/**
 * Contains the client IDs and scopes for allowed clients consuming your API.
 *
 * @author Pedro Felipe Marques Moreira
 * @since 6 de mar de 2016
 */
public class Constants {

    public static final String WEB_CLIENT_ID = "dojo-opencv";
    public static final String ANDROID_CLIENT_ID = "replace this with your Android client ID";
    public static final String IOS_CLIENT_ID = "replace this with your iOS client ID";
    public static final String ANDROID_AUDIENCE = WEB_CLIENT_ID;

    public static final String EMAIL_SCOPE = "https://www.googleapis.com/auth/userinfo.email";

    /** This line is needed for testing of OAuth protected methods in the APIs Explorer. */
    public static final String API_EXPLORER_CLIENT_ID = com.google.api.server.spi.Constant.API_EXPLORER_CLIENT_ID;
}
