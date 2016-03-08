package com.ciandt.opencv;

import javax.inject.Named;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

/**
 * Add your first API methods in this class, or you may create another class. In that case, please update your web.xml
 * accordingly.
 *
 * @author Pedro Felipe Marques Moreira
 * @since 6 de mar de 2016
 */
@Api(name = "myApi", version = "v1")
public class YourFirstAPI {

    @ApiMethod
    public MyBean test(@Named("content") final String content,
            @Named("firmwareVersion") final String firmwareVersion) {

        return new MyBean(content, firmwareVersion);
    }

}