package com.ciandt.backendopencv.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.Date;

/**
 * Created by Garage on 20/09/16.
 */
@Entity
public class Status {
    @Id
    private Long id;

    @Index
    private String idBanheiro;

    private Date data;

    private Boolean manutencao;

    public Status() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdBanheiro() {
        return idBanheiro;
    }

    public void setIdBanheiro(String idBanheiro) {
        this.idBanheiro = idBanheiro;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Boolean getManutencao() {
        return manutencao;
    }

    public void setManutencao(Boolean manutencao) {
        this.manutencao = manutencao;
    }
}
