package com.ciandt.backendopencv.Enum;

/**
 * Created by Garage on 20/09/16.
 */

public enum TipoBanheiro {
    M(1, "M"),
    F(2, "F");

    int codigo;
    String descricao;

    TipoBanheiro(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
