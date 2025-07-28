package uce.edu.ec.api.service.mapper;

import uce.edu.ec.api.repository.modelo.Producto;
import uce.edu.ec.api.repository.modelo.dto.ProductoTo;

public class ProductoMapper {
    
    public static ProductoTo convertir(Producto producto) {
        if (producto == null) {
            return null;
        }
        
        return new ProductoTo(
            producto.getId(),
            producto.getCodigoBarras(),
            producto.getNombre(),
            producto.getCategoria(),
            producto.getPrecio(),
            producto.getStock()
        );
    }
    
    public static Producto convertir(ProductoTo productoTo) {
        if (productoTo == null) {
            return null;
        }
        
        Producto producto = new Producto();
        producto.setId(productoTo.getId());
        producto.setCodigoBarras(productoTo.getCodigoBarras());
        producto.setNombre(productoTo.getNombre());
        producto.setCategoria(productoTo.getCategoria());
        producto.setPrecio(productoTo.getPrecio());
        producto.setStock(productoTo.getStock());
        
        return producto;
    }
}