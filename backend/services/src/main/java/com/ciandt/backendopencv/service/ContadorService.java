package com.ciandt.backendopencv.service;

import com.ciandt.backendopencv.dao.ContadorDAO;
import com.ciandt.backendopencv.dao.ContadorDAO;
import com.ciandt.backendopencv.entity.Contador;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.List;

/**
 * Created by Garage on 27/09/16.
 */

public class ContadorService {
    private ContadorDAO contadorDAO;

    public ContadorService() {
        contadorDAO = new ContadorDAO();
    }

    public List<Contador> list() {
        return contadorDAO.listAll();
    }

    public List<Contador> list(String idBanheiro) throws NotFoundException {
        List<Contador> list = contadorDAO.listByProperty("idBanheiro", idBanheiro);

        if (list == null || list.size() == 0) {
            throw new NotFoundException(String.format("Contadores não encontrados para o banheiro %s", idBanheiro));
        }

        return list;
    }

    public Contador getById(String id) throws NotFoundException{
        Contador banheiro = contadorDAO.getByKey(id);

        if(banheiro == null){
            throw new NotFoundException("Contador não encontrado!");
        }

        return banheiro;
    }

    public Contador insert (Contador item) throws ConflictException, NotFoundException{

        if(item == null){
            throw new ConflictException("Contador não informado");
        }else if(item.getId()== null){
            throw new ConflictException("Id Não informado");
        }else if(item.getContador()== null){
            throw new ConflictException("Contador Não informado");
        }else if(item.getData()== null){
            throw new ConflictException("Data Não informada");
        }else if(item.getIdBanheiro()== null) {
            throw new ConflictException("Banheiro Não informado");
        }

        Contador b = contadorDAO.getByKey(item.getId());

        if(b != null){
            throw new ConflictException("Contador já cadastrado");
        }

        return contadorDAO.insert(item);
    }

    public void update (Contador item) throws ConflictException, NotFoundException{

        if(item == null){
            throw new ConflictException("Contador não informado");
        }else if(item.getId()== null){
            throw new ConflictException("Id Não informado");
        }else if(item.getContador()== null){
            throw new ConflictException("Contador Não informado");
        }else if(item.getData()== null){
            throw new ConflictException("Data Não informada");
        }else if(item.getIdBanheiro()== null) {
            throw new ConflictException("Banheiro Não informado");

        }

        Contador b = contadorDAO.getByKey(item.getId());

        if(b == null){
            throw new NotFoundException("Contador não encontrado");
        }

        contadorDAO.update(item);
    }

    public void remove (String id) throws ConflictException, NotFoundException {
        Contador item = contadorDAO.getByKey(id);

        if (item == null) {
            throw new NotFoundException("Contador não encontrado");
        }

        contadorDAO.delete(item);
    }

}
