package uce.edu.ec.api.service.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import uce.edu.ec.api.repository.modelo.Impuesto;
import uce.edu.ec.api.repository.modelo.Producto;
import uce.edu.ec.api.repository.modelo.ProductoImpuesto;
import uce.edu.ec.api.repository.modelo.dto.ImpuestoDto;
import uce.edu.ec.api.service.To.ProductoTo;

public class ProductoMapper {
    
    public static ProductoTo toTo(Producto producto) {
        ProductoTo productoTo = new ProductoTo();
        productoTo.setId(producto.getId());
        productoTo.setCodigoBarras(producto.getCodigoBarras());
        productoTo.setNombre(producto.getNombre());
        productoTo.setCategoria(producto.getCategoria());
        productoTo.setPrecio(producto.getPrecio());
        productoTo.setStock(producto.getStock());
        
        try {
            if (producto.getImpuestos() != null && !producto.getImpuestos().isEmpty()) {
                List<ImpuestoDto> impuestosDto = producto.getImpuestos().stream()
                    .filter(pi -> pi != null && pi.getImpuesto() != null)
                    .map(ProductoImpuesto::getImpuesto)
                    .map(ImpuestoMapper::toDto)
                    .collect(Collectors.toList());
                productoTo.setImpuestos(impuestosDto);
            }
        } catch (Exception e) {
            System.err.println("Error al cargar impuestos: " + e.getMessage());
        }
        
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

        if (productoTo.getImpuestos() != null && !productoTo.getImpuestos().isEmpty()) {
            List<ProductoImpuesto> listaProductoImpuesto = new ArrayList<>();
            for (ImpuestoDto impDto : productoTo.getImpuestos()) {
                ProductoImpuesto pi = new ProductoImpuesto();
                pi.setProducto(producto);
                
                pi.setImpuesto(new Impuesto(impDto.getId())); 
                
                listaProductoImpuesto.add(pi);
            }
            producto.setImpuestos(listaProductoImpuesto);
        }

        return producto;
    }
}
