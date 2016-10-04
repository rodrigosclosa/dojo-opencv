package com.ciandt.backendopencv.endpoint;

import com.ciandt.backendopencv.entity.Banheiro;
import com.ciandt.backendopencv.entity.Status;
import com.ciandt.backendopencv.service.BanheiroService;
import com.ciandt.backendopencv.service.StatusService;
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
        name = "status",
        version = "v1",
        namespace = @ApiNamespace(
            ownerDomain = "endpoint.backendopencv.ciandt.com",
            ownerName = "endpoint.backendopencv.ciandt.com",
            packagePath = ""
        )
)
public class StatusEndpoint {

    private StatusService statusService;

    public StatusEndpoint() {
        statusService = new StatusService();
    }

    @ApiMethod(name = "getAllStatus", path = "get", httpMethod = "GET")
    public List<Status> getAllStatus(@Nullable @Named("banheiro") String banheiro) throws NotFoundException {
        if(banheiro == null)
            return statusService.list();
        else
            return statusService.list(banheiro);
    }

    @ApiMethod(name = "getStatus", path = "get/{id}", httpMethod = ApiMethod.HttpMethod.GET)
    public Status getStatus(@Named("id") String id) throws NotFoundException {
        return statusService.getById(id);
    }

    @ApiMethod(name = "insertStatus", path = "new", httpMethod = ApiMethod.HttpMethod.POST)
    public Status insertStatus(Status item) throws ConflictException, NotFoundException {
        return statusService.insert(item);
    }

    @ApiMethod(name = "updateStatus", path = "update", httpMethod = ApiMethod.HttpMethod.PUT)
    public void updateStatus(Status item) throws NotFoundException, ConflictException {
        statusService.update(item);
    }

    @ApiMethod(name = "removeStatus", path = "delete/{id}", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void removeStatus(@Named("id") String id) throws NotFoundException, ConflictException {
        statusService.remove(id);
    }
}
