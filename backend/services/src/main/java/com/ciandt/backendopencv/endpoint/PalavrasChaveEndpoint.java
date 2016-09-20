package com.ciandt.backendopencv.endpoint;

import com.ciandt.sulamerica.sas_reembolso.entity.PalavrasChave;
import com.ciandt.sulamerica.sas_reembolso.service.PalavrasChaveService;
import com.ciandt.sulamerica.sas_reembolso.util.Constants;
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
        name = "palavras",
        version = "v1",
        namespace = @ApiNamespace(
            ownerDomain = "endpoint.sas_reembolso.sulamerica.ciandt.com",
            ownerName = "endpoint.sas_reembolso.sulamerica.ciandt.com",
            packagePath = ""
        )
)
public class PalavrasChaveEndpoint {

    private PalavrasChaveService palavrasChaveService;

    public PalavrasChaveEndpoint() {
        palavrasChaveService = new PalavrasChaveService();
    }

    @ApiMethod(name = "getPalavras", path = "get", httpMethod = "GET")
    public List<PalavrasChave> getPalavras(HttpServletRequest req, @Nullable @Named("palavra") String palavra) throws NotFoundException, UnauthorizedException {
        if(palavra == null)
            return palavrasChaveService.list(req);
        else
            return palavrasChaveService.list(req, palavra);
    }

    @ApiMethod(name = "getPalavra", path = "get/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public PalavrasChave getPalavra(HttpServletRequest req, @Named("id") Long id) throws NotFoundException, UnauthorizedException {
        return palavrasChaveService.getById(req, id);
    }

    @ApiMethod(name = "insertPalavra", path = "new", httpMethod = ApiMethod.HttpMethod.POST)
    public PalavrasChave insertPalavra(HttpServletRequest req, PalavrasChave item) throws ConflictException, NotFoundException, UnauthorizedException {
        return palavrasChaveService.insert(req, item);
    }

    @ApiMethod(name = "updatePalavra", path = "update", httpMethod = ApiMethod.HttpMethod.PUT)
    public PalavrasChave updatePalavra(HttpServletRequest req, PalavrasChave item) throws NotFoundException, ConflictException, UnauthorizedException {
        return palavrasChaveService.update(req, item);
    }

    @ApiMethod(name = "removePalavra", path = "delete/{id}", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void removePalavra(HttpServletRequest req, @Named("id") Long id) throws NotFoundException, ConflictException, UnauthorizedException {
        palavrasChaveService.remove(req, id);
    }

    @ApiMethod(name = "seedData", path = "seed", httpMethod = ApiMethod.HttpMethod.POST)
    public void seedData(HttpServletRequest req) throws NotFoundException, ConflictException, UnauthorizedException {
        palavrasChaveService.seedData(req);
    }
}
