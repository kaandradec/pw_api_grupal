package uce.edu.ec.api.controller;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.ec.api.repository.modelo.Producto;
import uce.edu.ec.api.service.IProductoServi;
import uce.edu.ec.api.service.To.ProductoTo;
import uce.edu.ec.api.service.mapper.ProductoMapper;


@Path("/productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoController {
    @Inject
    private IProductoServi iProductoServi;
    
    @GET
    @Path("/{id}")
        public Response consultarPorId(@PathParam("id") Integer id) {
        Producto producto = iProductoServi.buscarPorId(id);
        if (producto == null) {
            return Response.status(Response.Status.NOT_FOUND)
                        .entity("Producto no encontrado").build();
        }
        ProductoTo productoTo = ProductoMapper.toTo(producto);
        return Response.ok(productoTo).build();
    }

    @GET
    @Path("")
    public Response consultarTodo(@QueryParam("codigoBarras") String codigoBarras) {

        List<ProductoTo>productoTos = this.iProductoServi.buscarTodo(codigoBarras).stream()
        .map(ProductoMapper::toTo).toList();

        return Response.status(Response.Status.OK).entity(productoTos).build();
    }

    @POST
    @Path("")
    public void guardar(@RequestBody ProductoTo productoTo) {
    Producto producto = ProductoMapper.toEntity(productoTo);
    this.iProductoServi.guardar(producto);
    }

    @PUT
    @Path("/{id}")
    public void actualizarPorId(@RequestBody ProductoTo productoTo, @PathParam("id") Integer id) {
    productoTo.setId(id);
    Producto producto = ProductoMapper.toEntity(productoTo);
    this.iProductoServi.actualizarPorId(producto);
    }

//    @PATCH
//     @Path("/{id}")
//     public void actualizarParcialPorId(@RequestBody ProductoTo productoTo, @PathParam("id") Integer id) {
//         Producto productoExistente = iProductoServi.buscarPorId(id);
//         if (productoExistente == null) {
//             throw new WebApplicationException("Producto no encontrado", 404);
//         }
//         if (productoTo.getCodigoBarras() != null) {
//             productoExistente.setCodigoBarras(productoTo.getCodigoBarras());
//         }
//         if (productoTo.getNombre() != null) {
//             productoExistente.setNombre(productoTo.getNombre());
//         }
//         if (productoTo.getCategoria() != null) {
//             productoExistente.setCategoria(productoTo.getCategoria());
//         }
//         if (productoTo.getPrecio() != null) {
//             productoExistente.setPrecio(productoTo.getPrecio());
//         }
//         if (productoTo.getStock() != null) {
//             productoExistente.setStock(productoTo.getStock());
//         }
//         if (productoTo.getIva() != null) {
//          productoExistente.setIva(productoTo.getIva());
//         }   
//         if (productoTo.getIce() != null) {
//                 productoExistente.setIce(productoTo.getIce());
//         }
//         if (productoTo.getIsd() != null) {
//                 productoExistente.setIsd(productoTo.getIsd());
//         }
           
//         this.iProductoServi.actualizarParcialPorId(productoExistente);
//     }

    @DELETE
    @Path("/{id}")
    public void eliminarPorId(@PathParam("id") Integer id) {
       this.iProductoServi.eliminarPorId(id);
    }

}
