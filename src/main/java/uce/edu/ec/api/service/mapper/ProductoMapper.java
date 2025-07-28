package uce.edu.ec.api.service.mapper;

import uce.edu.ec.api.repository.modelo.Producto;
import uce.edu.ec.api.service.To.ProductoTo;

public class ProductoMapper {
    public static ProductoTo toTo (Producto producto){
        ProductoTo productoTo = new ProductoTo();
        productoTo.setId(producto.getId());
        productoTo.setCodigoBarras(producto.getCodigoBarras());
        productoTo.setNombre(producto.getNombre());
        productoTo.setCategoria(producto.getCategoria());
        productoTo.setPrecio(producto.getPrecio());
        productoTo.setStock(producto.getStock());
        // productoTo.setIva(producto.getIva());
        // productoTo.setIce(producto.getIce());
        // productoTo.setIsd(producto.getIsd());
        return productoTo;
        
    }

public static Producto toEntity(ProductoTo productoTo) {
    Producto producto = new Producto();
    producto.setId(productoTo.getId());
    producto.setCodigoBarras(productoTo.getCodigoBarras());
    producto.setNombre(productoTo.getNombre());
    producto.setCategoria(productoTo.getCategoria());
    producto.setPrecio(productoTo.getPrecio());
    producto.setStock(productoTo.getStock());
    // producto.setIva(productoTo.getIva());
    // producto.setIce(productoTo.getIce());
    // producto.setIsd(productoTo.getIsd());
    return producto;
    }
}