package com.ciandt.backendopencv.entity;

import com.ciandt.backendopencv.Enum.TipoBanheiro;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.OnLoad;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.beans.Transient;
import java.util.List;

import javax.jdo.annotations.Transactional;

import static com.ciandt.backendopencv.util.OfyService.ofy;

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

    @Ignore
    private Boolean statusBanheiro;

    @OnLoad
    void onLoad(){
        System.out.println("passou  ");
        ofy().clear();
        Status statusretorno = null;
        List<Status> statusList = ofy().transactionless().load().type(Status.class).filter("idBanheiro",this.id).list();
        for(Status status : statusList){

            if(statusretorno == null || status.getData().after(statusretorno.getData())){
                statusretorno = status;
            }
        }

        if(statusretorno != null ){
            setStatusBanheiro(statusretorno.getManutencao());
        }else{
            setStatusBanheiro(false);
        }
    }

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

    public Boolean getStatusBanheiro() {
        return statusBanheiro;
    }

    public void setStatusBanheiro(Boolean statusBanheiro) {
        this.statusBanheiro = statusBanheiro;
    }


    public Banheiro() {
    }
}
