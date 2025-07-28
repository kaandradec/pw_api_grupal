package uce.edu.ec.api.service.mapper;

import uce.edu.ec.api.repository.modelo.Impuesto;
import uce.edu.ec.api.repository.modelo.dto.ImpuestoDto;

public class ImpuestoMapper {
    
    public static ImpuestoDto toDto(Impuesto impuesto) {
        if (impuesto == null) {
            return null;
        }
        
        ImpuestoDto dto = new ImpuestoDto();
        dto.setId(impuesto.getId());
        dto.setCodigo(impuesto.getCodigo());
        dto.setNombre(impuesto.getNombre());
        dto.setPorcentaje(impuesto.getPorcentaje());
        return dto;
    }
    
    public static Impuesto toEntity(ImpuestoDto dto) {
        if (dto == null) {
            return null;
        }
        
        if (dto.getId() != null && (dto.getCodigo() == null || dto.getNombre() == null)) {
            return new Impuesto(dto.getId());
        }
        
        Impuesto impuesto = new Impuesto();
        impuesto.setId(dto.getId());
        impuesto.setCodigo(dto.getCodigo());
        impuesto.setNombre(dto.getNombre());
        impuesto.setPorcentaje(dto.getPorcentaje());
        return impuesto;
    }
}
