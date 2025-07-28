package uce.edu.ec.api.service.mapper;

import uce.edu.ec.api.repository.modelo.FacturaDetalle;
import uce.edu.ec.api.repository.modelo.dto.FacturaDetalleTo;

public class FacturaDetalleMapper {
    
    public static FacturaDetalleTo convertir(FacturaDetalle detalle) {
        if (detalle == null) {
            return null;
        }
        
        return new FacturaDetalleTo(
            detalle.getId(),
            detalle.getCantidad(),
            detalle.getPrecio(),
            detalle.getSubtotal(),
            ProductoMapper.convertir(detalle.getProducto())
        );
    }
    
    public static FacturaDetalle convertir(FacturaDetalleTo detalleTo) {
        if (detalleTo == null) {
            return null;
        }
        
        FacturaDetalle detalle = new FacturaDetalle();
        detalle.setId(detalleTo.getId());
        detalle.setCantidad(detalleTo.getCantidad());
        detalle.setPrecio(detalleTo.getPrecio());
        detalle.setSubtotal(detalleTo.getSubtotal());
        
        if (detalleTo.getProducto() != null) {
            detalle.setProducto(ProductoMapper.convertir(detalleTo.getProducto()));
        }
        
        return detalle;
    }
} 