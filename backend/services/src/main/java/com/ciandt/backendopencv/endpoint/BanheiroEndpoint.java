package com.ciandt.backendopencv.endpoint;

import com.ciandt.backendopencv.entity.Banheiro;
import com.ciandt.backendopencv.service.BanheiroService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;
import com.google.api.server.spi.response.UnauthorizedException;

import java.util.List;

import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by rodrigosclosa on 29/08/16.
 */
@Api(
        name = "banheiros",
        version = "v1",
        namespace = @ApiNamespace(
            ownerDomain = "endpoint.backendopencv.ciandt.com",
            ownerName = "endpoint.backendopencv.ciandt.com",
            packagePath = ""
        )
)
public class BanheiroEndpoint {

    private BanheiroService banheiroService;

    public BanheiroEndpoint() {
        banheiroService = new BanheiroService();
    }

    @ApiMethod(name = "getBanheiros", path = "get", httpMethod = "GET")
    public List<Banheiro> getBanheiros(@Nullable @Named("predio") String predio) throws NotFoundException {
        if(predio == null)
            return banheiroService.list();
        else
            return banheiroService.list(predio);
    }

    @ApiMethod(name = "getBanheiro", path = "get/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public Banheiro getBanheiro(@Named("id") String id) throws NotFoundException {
        return banheiroService.getById(id);
    }

    @ApiMethod(name = "insertBanheiro", path = "new", httpMethod = ApiMethod.HttpMethod.POST)
    public Banheiro insertBanheiro(Banheiro item) throws ConflictException, NotFoundException {
        return banheiroService.insert(item);
    }

    @ApiMethod(name = "updateBanheiro", path = "update", httpMethod = ApiMethod.HttpMethod.PUT)
    public void updateBanheiro(Banheiro item) throws NotFoundException, ConflictException {
        banheiroService.update(item);
    }

    @ApiMethod(name = "removeBanheiro", path = "delete/{id}", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void removeBanheiro(@Named("id") String id) throws NotFoundException, ConflictException {
        banheiroService.remove(id);
    }
}
