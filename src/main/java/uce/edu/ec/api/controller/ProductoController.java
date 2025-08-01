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
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.ec.api.repository.modelo.Producto;
import uce.edu.ec.api.repository.modelo.dto.ProductoCompletoDto;
import uce.edu.ec.api.service.IProductoServi;
import uce.edu.ec.api.service.To.ProductoTo;
import uce.edu.ec.api.service.mapper.ProductoCompletoMapper;
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
        try {
            Producto producto = iProductoServi.buscarPorId(id);
            if (producto == null) {
                return Response.status(Response.Status.NOT_FOUND)
                    .entity("Producto no encontrado").build();
            }
            ProductoTo productoTo = ProductoMapper.toTo(producto);
            return Response.ok(productoTo).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error: " + e.getMessage()).build();
        }
    }

      @GET
@Path("/traer/{codigoBarras}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response consultarPorCodBarras(@PathParam("codigoBarras") String codigoBarras) {
    try {
        Producto producto = iProductoServi.buscarPorCodBarras(codigoBarras);

        if (producto == null) {
            return Response.status(Response.Status.NOT_FOUND)
                .entity("Producto no encontrado para código de barras: " + codigoBarras)
                .build();
        }

        ProductoTo productoTo = ProductoMapper.toTo(producto);
        return Response.ok(productoTo).build();

    } catch (Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity("Error interno: " + e.getMessage())
            .build();
    }
}

    @GET
    @Path("/{id}/completo")
    public Response consultarProductoCompleto(@PathParam("id") Integer id) {
        try {
            Producto producto = iProductoServi.buscarPorId(id);
            if (producto == null) {
                return Response.status(Response.Status.NOT_FOUND)
                    .entity("Producto no encontrado").build();
            }
            
            ProductoCompletoDto productoCompleto = ProductoCompletoMapper.toDto(producto);
            return Response.ok(productoCompleto).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("")
    public Response consultarTodo(@QueryParam("codigoBarras") String codigoBarras) {
        try {
            List<ProductoTo> productoTos = this.iProductoServi.buscarTodo(codigoBarras).stream()
                .map(ProductoMapper::toTo).toList();
            return Response.status(Response.Status.OK).entity(productoTos).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/buscar")
    public Response buscarProductoCompleto(@QueryParam("codigoBarras") String codigoBarras) {
        try {
            if (codigoBarras == null || codigoBarras.trim().isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Código de barras es requerido").build();
            }
            
            List<Producto> productos = this.iProductoServi.buscarTodo(codigoBarras);
            if (productos.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                    .entity("Producto no encontrado").build();
            }
            
            Producto producto = productos.get(0); // Tomar el primero
            ProductoCompletoDto productoCompleto = ProductoCompletoMapper.toDto(producto);
            return Response.ok(productoCompleto).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error: " + e.getMessage()).build();
        }
    }

    @POST
    @Path("")
    public Response guardar(@RequestBody ProductoTo productoTo) {
        try {
            if (productoTo == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Datos del producto requeridos").build();
            }

            if (productoTo.getBodega() == null || productoTo.getBodega().getId() == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Debe seleccionar una bodega para el producto").build();
            }

            Producto producto = ProductoMapper.toEntity(productoTo);
            this.iProductoServi.guardar(producto);
            return Response.status(Response.Status.CREATED)
                    .entity("Producto guardado correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("Error al guardar: " + e.getMessage()).build();
        }
    }


    @POST
    @Path("/conimpuesto")
    public Response guardarConImpuesto(@RequestBody ProductoTo productoTo) {
        try {
            if (productoTo == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Datos del producto requeridos").build();
            }

            iProductoServi.guardarDesdeTo(productoTo);
            return Response.status(Response.Status.CREATED)
                    .entity("Producto con impuestos guardado exitosamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al guardar el producto con impuestos: " + e.getMessage()).build();
        }
    }


    @PUT
    @Path("/{id}")
    public Response actualizarPorId(@RequestBody ProductoTo productoTo, @PathParam("id") Integer id) {
        try {
            if (productoTo == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Datos del producto requeridos").build();
            }

            if (productoTo.getBodega() == null || productoTo.getBodega().getId() == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Debe seleccionar una bodega para el producto").build();
            }

            productoTo.setId(id);
            Producto producto = ProductoMapper.toEntity(productoTo);
            this.iProductoServi.actualizarPorId(producto);
            return Response.ok("Producto actualizado correctamente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("Error al actualizar: " + e.getMessage()).build();
        }
    }

    @PATCH
    @Path("/{id}")
    public Response actualizarParcial(@PathParam("id") Integer id, ProductoTo productoTo) {
        try {
            if (productoTo == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Datos para actualización requeridos").build();
            }
            
            productoTo.setId(id);
            
            iProductoServi.actualizarParcial(productoTo);
            
            return Response.ok("Producto actualizado parcialmente").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("Error al actualizar parcialmente: " + e.getMessage()).build();
        }
    }


    @DELETE
    @Path("/{id}")
    public Response eliminarPorId(@PathParam("id") Integer id) {
        try {
            this.iProductoServi.eliminarPorId(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("Error al eliminar: " + e.getMessage()).build();
        }
    }
}