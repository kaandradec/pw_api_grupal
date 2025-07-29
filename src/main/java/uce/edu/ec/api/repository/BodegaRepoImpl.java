package uce.edu.ec.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import uce.edu.ec.api.repository.modelo.Bodega;

@ApplicationScoped
@Transactional
public class BodegaRepoImpl implements IBodegaRepo {

    @Inject
    private EntityManager entityManager;

    @Override
    public void insertar(Bodega bodega) {
        entityManager.persist(bodega);
    }

    @Override
    public void actualizar(Bodega bodega) {
        entityManager.merge(bodega);
    }

    @Override
    public void eliminar(Integer id) {
        Bodega bodega = entityManager.find(Bodega.class, id);
        if (bodega != null) {
            entityManager.remove(bodega);
        }
    }

    @Override
    public Bodega seleccionarPorId(Integer id) {
        return entityManager.find(Bodega.class, id);
    }

    @Override
    public List<Bodega> seleccionarTodas() {
        return entityManager.createQuery("SELECT b FROM Bodega b", Bodega.class).getResultList();
    }

    @Override
    public Bodega seleccionarPorCodigo(String codigo) {
        return entityManager.createQuery("SELECT b FROM Bodega b WHERE b.codigo = :codigo", Bodega.class)
                .setParameter("codigo", codigo)
                .getSingleResult();
    }

}   
