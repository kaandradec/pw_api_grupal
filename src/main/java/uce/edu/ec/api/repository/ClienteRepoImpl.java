package uce.edu.ec.api.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.ec.api.repository.modelo.Cliente;

import java.util.List;

@ApplicationScoped
@Transactional
public class ClienteRepoImpl implements IClienteRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cliente buscarPorId(Integer id) {
        return this.entityManager.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> obtenerTodos() {
        TypedQuery<Cliente> query = this.entityManager.createQuery("FROM Cliente", Cliente.class);
        return query.getResultList();
    }

    @Override
    public void insertar(Cliente cliente) {
        this.entityManager.persist(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
        this.entityManager.merge(cliente);
    }

    @Override
    public void actualizarParcial(Cliente cliente) {
        this.entityManager.merge(cliente);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.buscarPorId(id));
    }
}
