package uce.edu.ec.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.ec.api.repository.modelo.Impuesto;
import uce.edu.ec.api.repository.modelo.dto.ImpuestoDto;
import uce.edu.ec.api.service.ImpuestoService;
import uce.edu.ec.api.service.mapper.ImpuestoMapper;

@Path("/impuestos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ImpuestoController {
    
    @Inject
    private ImpuestoService impuestoService;
    
    @GET
    public Response listarTodos() {
        try {
            List<ImpuestoDto> impuestos = impuestoService.buscarTodos().stream()
                .map(ImpuestoMapper::toDto)
                .collect(Collectors.toList());
            return Response.ok(impuestos).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error: " + e.getMessage()).build();
        }
    }
    
    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Integer id) {
        try {
            Impuesto impuesto = impuestoService.buscarPorId(id);
            if (impuesto == null) {
                return Response.status(Response.Status.NOT_FOUND)
                    .entity("Impuesto no encontrado").build();
            }
            return Response.ok(ImpuestoMapper.toDto(impuesto)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error: " + e.getMessage()).build();
        }
    }
    
    @POST
    public Response crear(ImpuestoDto impuestoDto) {
        try {
            if (impuestoDto == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Datos del impuesto requeridos").build();
            }
            
            Impuesto impuesto = ImpuestoMapper.toEntity(impuestoDto);
            impuestoService.guardar(impuesto);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("Error al crear: " + e.getMessage()).build();
        }
    }
    
    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") Integer id, ImpuestoDto impuestoDto) {
        try {
            if (impuestoDto == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Datos del impuesto requeridos").build();
            }
            
            impuestoDto.setId(id);
            Impuesto impuesto = ImpuestoMapper.toEntity(impuestoDto);
            impuestoService.actualizar(impuesto);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("Error al actualizar: " + e.getMessage()).build();
        }
    }
    
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Integer id) {
        try {
            impuestoService.eliminarPorId(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("Error al eliminar: " + e.getMessage()).build();
        }
    }
}