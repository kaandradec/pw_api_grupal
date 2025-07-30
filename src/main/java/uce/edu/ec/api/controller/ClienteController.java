package uce.edu.ec.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import uce.edu.ec.api.repository.modelo.Cliente;
import uce.edu.ec.api.repository.modelo.dto.ClienteTo;
import uce.edu.ec.api.service.IClienteService;
import uce.edu.ec.api.service.mapper.ClienteMapper;


import java.util.List;
import java.util.stream.Collectors;

@Path("/clientes")
public class ClienteController {

    @Inject
    public IClienteService clienteService;

    @Path("/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorId(@PathParam("id") Integer id) {
        ClienteTo cliente = ClienteMapper.toTo(this.clienteService.buscarPorId(id));
       return Response.status(Response.Status.ACCEPTED).entity(cliente).build();
    }

    @Path("/traer/{cedula}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorCedula(@PathParam("cedula") String cedula) {
        ClienteTo cliente = ClienteMapper.toTo(this.clienteService.buscarPorCedula(cedula));
       return Response.status(Response.Status.OK).entity(cliente).build();
    }

    @GET
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarTodos(){
        List<ClienteTo> clientes = this.clienteService.obtenerTodos().stream().map(ClienteMapper::toTo)
                .collect(Collectors.toList());
        return Response.status(Response.Status.OK).entity(clientes).build();
    }
    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardar(@RequestBody ClienteTo clienteto){
        Cliente cliente = ClienteMapper.ToEntity(clienteto);
        this.clienteService.insertar(cliente);
      return Response.status(Response.Status.ACCEPTED).entity(cliente).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@PathParam("id") Integer id, @RequestBody ClienteTo clienteto){
        clienteto.setId(id);
        Cliente cliente = ClienteMapper.ToEntity(clienteto);
        this.clienteService.actualizar(cliente);
        return Response.status(Response.Status.OK).entity(cliente).build();
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarParcial(@PathParam("id") Integer id, @RequestBody ClienteTo clienteTo){
        Cliente cliente = this.clienteService.buscarPorId(id);

        if(cliente.getNombre()!= null){
            cliente.setNombre(clienteTo.getNombre());
        }
        if(cliente.getCedula()!= null){
            cliente.setCedula(clienteTo.getCedula());
        }
        if(cliente.getRazonSocial()!= null){
            cliente.setRazonSocial(clienteTo.getRazonSocial());
        }
        if(cliente.getApellido()!= null){
            cliente.setApellido(clienteTo.getApellido());
        }
        if(cliente.getTelefono()!= null){
            cliente.setTelefono(clienteTo.getTelefono());
        }
        if(cliente.getDireccion()!= null){
            cliente.setDireccion(clienteTo.getDireccion());
        }
        if (cliente.getEmail()!= null){
            cliente.setEmail(clienteTo.getEmail());
        }
        if (cliente.getDireccion()!= null){
            cliente.setDireccion(clienteTo.getDireccion());
        }
        this.clienteService.actualizarParcial(cliente);
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response borrarPorId(@PathParam("id")Integer id){
        this.clienteService.eliminar(id);
        return Response.status(Response.Status.OK).build();
    }

}
