package uce.edu.ec.api.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import uce.edu.ec.api.repository.modelo.Producto;
import uce.edu.ec.api.repository.modelo.ProductoImpuesto;
import uce.edu.ec.api.repository.modelo.dto.ProductoCompletoDto;

public class ProductoCompletoMapper {
    
    public static ProductoCompletoDto toDto(Producto producto) {
        if (producto == null) {
            return null;
        }
        
        ProductoCompletoDto dto = new ProductoCompletoDto();
        dto.setId(producto.getId());
        dto.setCodigoBarras(producto.getCodigoBarras());
        dto.setNombre(producto.getNombre());
        dto.setCategoria(producto.getCategoria());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        
        // Bodega
        if (producto.getBodega() != null) {
            dto.setBodega(BodegaMapper.toDto(producto.getBodega()));
        }
        
        // Impuestos
        if (producto.getImpuestos() != null && !producto.getImpuestos().isEmpty()) {
            List<uce.edu.ec.api.repository.modelo.dto.ImpuestoDto> impuestosDto = producto.getImpuestos().stream()
                .filter(pi -> pi != null && pi.getImpuesto() != null)
                .map(ProductoImpuesto::getImpuesto)
                .map(ImpuestoMapper::toDto)
                .collect(Collectors.toList());
            dto.setImpuestos(impuestosDto);
        }
        
        return dto;
    }
} 