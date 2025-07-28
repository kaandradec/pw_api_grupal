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
import uce.edu.ec.api.repository.modelo.dto.ClienteTo;
import uce.edu.ec.api.service.IClienteService;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteController {

    @Inject
    private IClienteService iClienteService;

    @POST
    @Path("")
    public Response crear(ClienteTo clienteTo) {
        try {
            iClienteService.crear(clienteTo);
            return Response.status(Response.Status.CREATED).entity("Cliente creado exitosamente").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error al crear cliente: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") Integer id, ClienteTo clienteTo) {
        try {
            clienteTo.setId(id);
            iClienteService.actualizar(clienteTo);
            return Response.status(Response.Status.OK).entity("Cliente actualizado exitosamente").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error al actualizar cliente: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Integer id) {
        try {
            ClienteTo cliente = iClienteService.buscarPorId(id);
            if (cliente != null) {
                return Response.status(Response.Status.OK).entity(cliente).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Cliente no encontrado").build();
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
            List<ClienteTo> clientes = iClienteService.buscarTodos();
            return Response.status(Response.Status.OK).entity(clientes).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Integer id) {
        try {
            iClienteService.eliminar(id);
            return Response.status(Response.Status.OK).entity("Cliente eliminado exitosamente").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error al eliminar cliente: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/buscar")
    public Response buscarPorCedula(@QueryParam("cedula") String cedula) {
        try {
            ClienteTo cliente = iClienteService.buscarPorCedula(cedula);
            if (cliente != null) {
                return Response.status(Response.Status.OK).entity(cliente).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Cliente no encontrado").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
} 