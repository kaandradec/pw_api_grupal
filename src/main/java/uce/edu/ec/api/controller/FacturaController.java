package uce.edu.ec.api.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.ec.api.repository.modelo.dto.FacturaTo;
import uce.edu.ec.api.service.IFacturaService;

@Path("/facturas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FacturaController {

    @Inject
    private IFacturaService iFacturaService;

    @POST
    @Path("")
    public Response crear(FacturaTo facturaTo) {
        try {
            iFacturaService.crear(facturaTo);
            return Response.status(Response.Status.CREATED).entity("Factura creada exitosamente").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error al crear factura: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") Integer id, FacturaTo facturaTo) {
        try {
            facturaTo.setId(id);
            iFacturaService.actualizar(facturaTo);
            return Response.status(Response.Status.OK).entity("Factura actualizada exitosamente").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error al actualizar factura: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Integer id) {
        try {
            FacturaTo factura = iFacturaService.buscarPorId(id);
            if (factura != null) {
                return Response.status(Response.Status.OK).entity(factura).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Factura no encontrada").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("")
    public Response buscarTodos() {
        try {
            List<FacturaTo> facturas = iFacturaService.buscarTodos();
            return Response.status(Response.Status.OK).entity(facturas).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Integer id) {
        try {
            iFacturaService.eliminar(id);
            return Response.status(Response.Status.OK).entity("Factura eliminada exitosamente").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error al eliminar factura: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/buscar")
    public Response buscarPorNumeroDocumento(@QueryParam("numeroDocumento") String numeroDocumento) {
        try {
            FacturaTo factura = iFacturaService.buscarPorNumeroDocumento(numeroDocumento);
            if (factura != null) {
                return Response.status(Response.Status.OK).entity(factura).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Factura no encontrada").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
} 