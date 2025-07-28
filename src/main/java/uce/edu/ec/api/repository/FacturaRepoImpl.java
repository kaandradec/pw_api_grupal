package uce.edu.ec.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.ec.api.repository.modelo.Factura;

@Transactional
@ApplicationScoped
public class FacturaRepoImpl implements IFacturaRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Factura factura) {
        this.entityManager.persist(factura);
    }

    @Override
    public void actualizar(Factura factura) {
        this.entityManager.merge(factura);
    }

    @Override
    public Factura buscarPorId(Integer id) {
        return this.entityManager.find(Factura.class, id);
    }

    @Override
    public List<Factura> buscarTodos() {
        TypedQuery<Factura> query = this.entityManager
                .createQuery("SELECT f FROM Factura f ORDER BY f.fechaEmision DESC", Factura.class);
        return query.getResultList();
    }

    @Override
    public void eliminar(Integer id) {
        Factura factura = this.buscarPorId(id);
        if (factura != null) {
            this.entityManager.remove(factura);
        }
    }

    @Override
    public Factura buscarPorNumeroDocumento(String numeroDocumento) {
        TypedQuery<Factura> query = this.entityManager
                .createQuery("SELECT f FROM Factura f WHERE f.numeroDocumento = :numeroDocumento", Factura.class);
        query.setParameter("numeroDocumento", numeroDocumento);
        return query.getResultList().stream().findFirst().orElse(null);
    }
} 