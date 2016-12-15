package com.ciandt.backendopencv.service;


import com.ciandt.backendopencv.dao.StatusDAO;
import com.ciandt.backendopencv.entity.Status;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.List;

/**
 * Created by Garage on 27/09/16.
 */

public class StatusService {
    private StatusDAO statusDAO;

    public StatusService() {
        statusDAO = new StatusDAO();
    }

    public List<Status> list() {
        return statusDAO.listAll();
    }

    public List<Status> list(String idBanheiro) throws NotFoundException {
        List<Status> list = statusDAO.listByProperty("idBanheiro", idBanheiro);

        if (list == null || list.size() == 0) {
            throw new NotFoundException(String.format("Status não encontrado para o banheiro %s", idBanheiro));
        }

        return list;
    }

    public Status getById(String id) throws NotFoundException{
        Status status = statusDAO.getByKey(id);

        if(status == null){
            throw new NotFoundException("Status não encontrado!");
        }

        return status;
    }

    public Status insert (Status item) throws ConflictException, NotFoundException{

        if(item == null){
            throw new ConflictException("Status não informado");

        }else if(item.getData()== null){

            throw new ConflictException("Data Não informada");

        }else if(item.getManutencao()== null){

            throw new ConflictException("Manutenção Não informado");

        }else if(item.getIdBanheiro()== null){

            throw new ConflictException("IdBanheiro Não informado");

        }

        return statusDAO.insert(item);


    }

    public void update (Status item) throws ConflictException, NotFoundException{

        if(item == null){
            throw new ConflictException("Status não informado");

        }else if(item.getData()== null){

            throw new ConflictException("Data Não informada");

        }else if(item.getManutencao()== null){

            throw new ConflictException("Manutenção Não informado");

        }else if(item.getIdBanheiro()== null){

            throw new ConflictException("IdBanheiro Não informado");

        }

        statusDAO.update(item);
    }

    public void remove (String id) throws ConflictException, NotFoundException {
        Status item = statusDAO.getByKey(id);

        if (item == null) {
            throw new NotFoundException("Status não encontrado");
        }

        statusDAO.delete(item);
    }

}
