package com.ciandt.backendopencv.util;

import com.ciandt.backendopencv.entity.Banheiro;
import com.ciandt.backendopencv.entity.Contador;
import com.ciandt.backendopencv.entity.Status;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

/**
 * Created by rodrigosclosa on 29/08/16.
 */
public class OfyService {

    static {
        ObjectifyService.register(Banheiro.class);
        ObjectifyService.register(Contador.class);
        ObjectifyService.register(Status.class);

    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }

}
