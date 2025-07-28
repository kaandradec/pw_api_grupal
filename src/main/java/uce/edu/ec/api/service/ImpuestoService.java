package uce.edu.ec.api.service;


import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.ec.api.repository.modelo.Impuesto;

@ApplicationScoped
@Transactional
public class ImpuestoService {
    
    @Inject
    EntityManager entityManager;
    
    public List<Impuesto> buscarTodos() {
        TypedQuery<Impuesto> query = entityManager.createQuery(
            "SELECT i FROM Impuesto i", Impuesto.class);
        return query.getResultList();
    }
    
    public Impuesto buscarPorId(Integer id) {
        return entityManager.find(Impuesto.class, id);
    }
    
    public void guardar(Impuesto impuesto) {
        entityManager.persist(impuesto);
    }
    
    public void actualizar(Impuesto impuesto) {
        entityManager.merge(impuesto);
    }
    
    public void eliminarPorId(Integer id) {
        Impuesto impuesto = entityManager.find(Impuesto.class, id);
        if (impuesto != null) {
            entityManager.remove(impuesto);
        }
    }
}