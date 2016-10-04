package com.ciandt.backendopencv.endpoint;

import com.ciandt.backendopencv.entity.Banheiro;
import com.ciandt.backendopencv.entity.Contador;
import com.ciandt.backendopencv.service.BanheiroService;
import com.ciandt.backendopencv.service.ContadorService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.List;

import javax.inject.Named;


/**
 * Created by rodrigosclosa on 29/08/16.
 */
@Api(
        name = "contadores",
        version = "v1",
        namespace = @ApiNamespace(
            ownerDomain = "endpoint.backendopencv.ciandt.com",
            ownerName = "endpoint.backendopencv.ciandt.com",
            packagePath = ""
        )
)
public class ContadorEndpoint {

    private ContadorService contadorService;

    public ContadorEndpoint() {
        contadorService = new ContadorService();
    }

    @ApiMethod(name = "getContadores", path = "get", httpMethod = "GET")
    public List<Contador> getContadores(@Nullable @Named("idBanheiro") String idBanheiro) throws NotFoundException {
        if(idBanheiro == null)
            return contadorService.list();
        else
            return contadorService.list(idBanheiro);
    }

    @ApiMethod(name = "getContador", path = "get/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public Contador getContador(@Named("id") String id) throws NotFoundException {
        return contadorService.getById(id);
    }

    @ApiMethod(name = "insertContador", path = "new", httpMethod = ApiMethod.HttpMethod.POST)
    public Contador insertContador(Contador item) throws ConflictException, NotFoundException {
        return contadorService.insert(item);
    }

    @ApiMethod(name = "updateContador", path = "update", httpMethod = ApiMethod.HttpMethod.PUT)
    public void updateContador(Contador item) throws NotFoundException, ConflictException {
        contadorService.update(item);
    }

    @ApiMethod(name = "removeContador", path = "delete/{id}", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void removeContador(@Named("id") String id) throws NotFoundException, ConflictException {
        contadorService.remove(id);
    }
}
