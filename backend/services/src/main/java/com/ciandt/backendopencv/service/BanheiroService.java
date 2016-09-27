package com.ciandt.backendopencv.service;

import com.ciandt.backendopencv.dao.BanheiroDAO;
import com.ciandt.backendopencv.dao.ContadorDAO;
import com.ciandt.backendopencv.entity.Banheiro;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.List;

/**
 * Created by Garage on 27/09/16.
 */

public class BanheiroService {
    private BanheiroDAO banheiroDAO;

    public BanheiroService() {
        banheiroDAO = new BanheiroDAO();
    }

    public List<Banheiro> list() {
        return banheiroDAO.listAll();
    }

    public List<Banheiro> list(String predio) throws NotFoundException {
        List<Banheiro> list = banheiroDAO.listByProperty("predio", predio);

        if (list == null || list.size() == 0) {
            throw new NotFoundException(String.format("Banheiros não encontrados para o prédio %s", predio));
        }

        return list;
    }

    public Banheiro getById(String id) throws NotFoundException{
        Banheiro banheiro = banheiroDAO.getByKey(id);

        if(banheiro == null){
            throw new NotFoundException("Banheiro não encontrado!");
        }

        return banheiro;
    }

    public Banheiro insert (Banheiro item) throws ConflictException, NotFoundException{

        if(item == null){
            throw new ConflictException("Banheiro não informado");

        }else if(item.getId()== null){

            throw new ConflictException("Id Não informado");

        }else if(item.getDescricao()== null){

            throw new ConflictException("Descricao Não informado");

        }else if(item.getPredio()== null){

            throw new ConflictException("Predio Não informado");

        }else if(item.getAndar()== null){

            throw new ConflictException("Andar Não informado");

        }else if(item.getTipo()== null){

            throw new ConflictException("Tipo Não informado");
        }

        Banheiro b = banheiroDAO.getByKey(item.getId());

        if(b != null){

            throw new ConflictException("Banheiro já cadastrado");
        }

        return banheiroDAO.insert(item);


    }

    public void update (Banheiro item) throws ConflictException, NotFoundException{

        if(item == null){
            throw new ConflictException("Banheiro não informado");

        }else if(item.getId()== null){

            throw new ConflictException("Id Não informado");

        }else if(item.getDescricao()== null){

            throw new ConflictException("Descricao Não informado");

        }else if(item.getPredio()== null){

            throw new ConflictException("Predio Não informado");

        }else if(item.getAndar()== null){

            throw new ConflictException("Andar Não informado");

        }else if(item.getTipo()== null){

            throw new ConflictException("Tipo Não informado");
        }

        Banheiro b = banheiroDAO.getByKey(item.getId());

        if(b == null){
            throw new NotFoundException("Banheiro não encontrado");
        }

        banheiroDAO.update(item);
    }

    public void remove (String id) throws ConflictException, NotFoundException {
        Banheiro item = banheiroDAO.getByKey(id);

        if (item == null) {
            throw new NotFoundException("Banheiro não encontrado");
        }

        banheiroDAO.delete(item);
    }

}
