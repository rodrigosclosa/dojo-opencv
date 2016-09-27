package com.ciandt.backendopencv.entity;

import com.ciandt.backendopencv.Enum.TipoBanheiro;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by Garage on 20/09/16.
 */

@Entity
public class Banheiro {
    @Id
    private String id;

    private String descricao;
    @Index
    private String predio;

    private String andar;
    @Index
    private TipoBanheiro tipo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPredio() {
        return predio;
    }

    public void setPredio(String predio) {
        this.predio = predio;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public TipoBanheiro getTipo() {
        return tipo;
    }

    public void setTipo(TipoBanheiro tipo) {
        this.tipo = tipo;
    }

    public Banheiro() {
    }
}
