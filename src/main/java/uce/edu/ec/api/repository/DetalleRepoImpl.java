package uce.edu.ec.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.TransactionScoped;
import uce.edu.ec.api.repository.modelo.DetalleFactura;

@TransactionScoped
@ApplicationScoped
public class DetalleRepoImpl implements IDetalleRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void crearDetalle(DetalleFactura detalle) {
        this.entityManager.persist(detalle);
    }

    @Override
    public List<DetalleFactura> buscarPorNumeroDocumento(String numeroDocumento) {
      TypedQuery<DetalleFactura> myQuery = this.entityManager.createQuery("SELECT d FROM DetalleFactura d where d.Factura.numeroDocumento=: numDocu", DetalleFactura.class);
      myQuery.setParameter("numDocu", numeroDocumento);
      return myQuery.getResultList();

    }

}
