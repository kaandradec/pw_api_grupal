package uce.edu.ec.api.service.mapper;

import uce.edu.ec.api.repository.modelo.Bodega;
import uce.edu.ec.api.repository.modelo.dto.BodegaTo;

public class BodegaMapper {

    public static BodegaTo toDto(Bodega bodega) {
        if (bodega == null) {
            return null;
        }
        BodegaTo bodegaTo = new BodegaTo();
        bodegaTo.setId(bodega.getId());
        bodegaTo.setCodigo(bodega.getCodigo());
        bodegaTo.setNombre(bodega.getNombre());
        bodegaTo.setUbicacion(bodega.getUbicacion());
        return bodegaTo;
    }

    public static Bodega toEntity(BodegaTo bodegaTo) {
        if (bodegaTo == null) {
            return null;
        }
        Bodega bodega = new Bodega();
        bodega.setId(bodegaTo.getId());
        bodega.setCodigo(bodegaTo.getCodigo());
        bodega.setNombre(bodegaTo.getNombre());
        bodega.setUbicacion(bodegaTo.getUbicacion());
        return bodega;
    }

}
