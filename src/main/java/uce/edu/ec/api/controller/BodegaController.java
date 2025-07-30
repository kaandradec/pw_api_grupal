package uce.edu.ec.api.controller;

import java.net.URI;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import uce.edu.ec.api.repository.modelo.dto.BodegaTo;
import uce.edu.ec.api.service.IBodegaService;

@Path("/bodegas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BodegaController {

    @Inject
    private IBodegaService bodegaService;

    @GET
    public Response listar() {
        List<BodegaTo> lista = bodegaService.buscarTodos();
        return Response.ok(lista).build();
    }

    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") Integer id) {
        BodegaTo bodega = bodegaService.buscarPorId(id);
        if (bodega == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(bodega).build();
    }

    // POST /bodegas
    @POST
    public Response crear(BodegaTo bodegaTo, @Context UriInfo uriInfo) {
        bodegaService.guardar(bodegaTo);
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(bodegaTo.getId())).build();
        return Response.created(uri).build();
    }

    // PUT /bodegas
    @PUT
    public Response actualizar(BodegaTo bodegaTo) {
        BodegaTo existente = bodegaService.buscarPorId(bodegaTo.getId());
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        bodegaService.actualizar(bodegaTo);
        return Response.noContent().build();
    }

    // DELETE /bodegas/{id}
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Integer id) {
        BodegaTo existente = bodegaService.buscarPorId(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        bodegaService.eliminar(id);
        return Response.noContent().build();
    }

    // GET /bodegas/codigo/{codigo}
    @GET
    @Path("/codigo/{codigo}")
    public Response buscarPorCodigo(@PathParam("codigo") String codigo) {
        BodegaTo bodega = bodegaService.buscarPorCodigo(codigo);
        if (bodega == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(bodega).build();
    }

    @PATCH
    @Path("/{id}")
    @Transactional
    public Response actualizarParcial(@PathParam("id") Integer id, BodegaTo parcial) {
        BodegaTo existente = bodegaService.buscarPorId(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        if (parcial.getCodigo() != null)
            existente.setCodigo(parcial.getCodigo());
        if (parcial.getNombre() != null)
            existente.setNombre(parcial.getNombre());
        if (parcial.getUbicacion() != null)
            existente.setUbicacion(parcial.getUbicacion());

        bodegaService.actualizar(existente);
        return Response.ok().build();
    }

}
