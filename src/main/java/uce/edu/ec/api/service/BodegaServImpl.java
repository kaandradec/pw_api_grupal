package uce.edu.ec.api.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.api.repository.IBodegaRepo;
import uce.edu.ec.api.repository.modelo.Bodega;
import uce.edu.ec.api.service.to.BodegaTo;


@ApplicationScoped
public class BodegaServImpl implements IBodegaServi{

    @Inject
    private IBodegaRepo bodegaRepo;

    @Override
    public void crearBodega(BodegaTo bodegaTo) {
        // TODO Auto-generated method stub
        this.bodegaRepo.crearBodega(this.toBodega(bodegaTo));
    }

    @Override
    public List<BodegaTo> buscarTodos() {
      List<Bodega> bodegas = this.bodegaRepo.buscarTodos();
        List<BodegaTo> bodegTo = new ArrayList<>();
        for(Bodega bodega : bodegas){
            bodegTo.add(this.toTo(bodega));
        }
        return bodegTo;
    }

    @Override
    public BodegaTo buscarPorId(Integer id) {
        return this.toTo(this.bodegaRepo.buscarPorId(id));
    }

    @Override
    public BodegaTo buscarPorCodigo(String codigoB) {
     return this.toTo(this.bodegaRepo.buscarPorCodigo(codigoB));
 }

    @Override
    public void actualizarBodega(BodegaTo bodegaTo) {
         Bodega bodega = this.bodegaRepo.buscarPorCodigo(bodegaTo.getCodigo());
        if(bodega!=null){
            bodega.setCodigo(bodegaTo.getCodigo());
           bodega.setNombre(bodegaTo.getNombre());
           bodega.setUbicacion(bodegaTo.getUbicacion());
            this.bodegaRepo.actualizarBodega(bodega);
        }
    }

    @Override
    public void eliminarBodega(Integer id) {
        this.bodegaRepo.eliminarBodega(id);
    }

     public static BodegaTo toTo(Bodega bodega) {
        BodegaTo bodegaTo = new BodegaTo();
        bodegaTo.setId(bodega.getId());
        bodegaTo.setCodigo(bodega.getCodigo());
        bodegaTo.setNombre(bodega.getNombre());
        bodegaTo.setUbicacion(bodega.getUbicacion());
        return bodegaTo;
    }

      public static Bodega toBodega(BodegaTo bodegaTo) {
        Bodega bodega = new Bodega();
        bodega.setId(bodegaTo.getId());
        bodega.setCodigo(bodegaTo.getCodigo());
        bodega.setNombre(bodegaTo.getNombre());
        bodega.setUbicacion(bodegaTo.getUbicacion());
        return bodega;
    }
}
