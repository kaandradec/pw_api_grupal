package uce.edu.ec.api.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.api.repository.IBodegaRepo;
import uce.edu.ec.api.repository.modelo.Bodega;
import uce.edu.ec.api.repository.modelo.dto.BodegaTo;
import uce.edu.ec.api.service.mapper.BodegaMapper;

@ApplicationScoped
public class BodegaServiceImpl implements IBodegaService {

    @Inject
    private IBodegaRepo bodegaRepo;

    @Override
    @Transactional
    public void eliminar(Integer id) {
        this.bodegaRepo.eliminar(id);
    }

    @Override
    public BodegaTo buscarPorId(Integer id) {
        return BodegaMapper.toDto(this.bodegaRepo.seleccionarPorId(id));
    }

    @Override
    public BodegaTo buscarPorCodigo(String codigo) {
        return BodegaMapper.toDto(this.bodegaRepo.seleccionarPorCodigo(codigo));
    }

    @Override
    public List<BodegaTo> buscarTodos() {
        return this.bodegaRepo.seleccionarTodas()
                .stream()
                .map(BodegaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void actualizar(BodegaTo bodega) {
        this.bodegaRepo.actualizar(BodegaMapper.toEntity(bodega));
    }

    @Override
    @Transactional
    public void guardar(BodegaTo bodega) {
        this.bodegaRepo.insertar(BodegaMapper.toEntity(bodega));

    }

    //metodos auxiliares 

    public Bodega buscarEntidadPorId(Integer id) {
        return bodegaRepo.seleccionarPorId(id);
    }

    @Transactional
    public void actualizarEntidad(Bodega bodega) {
        bodegaRepo.actualizar(bodega);
    }

}
