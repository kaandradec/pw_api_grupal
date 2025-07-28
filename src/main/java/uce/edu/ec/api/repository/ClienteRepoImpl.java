package uce.edu.ec.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.ec.api.repository.modelo.Cliente;

@Transactional
@ApplicationScoped
public class ClienteRepoImpl implements IClienteRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Cliente cliente) {
        this.entityManager.persist(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
        this.entityManager.merge(cliente);
    }

    @Override
    public Cliente buscarPorId(Integer id) {
        return this.entityManager.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        TypedQuery<Cliente> query = this.entityManager
                .createQuery("SELECT c FROM Cliente c ORDER BY c.nombre", Cliente.class);
        return query.getResultList();
    }

    @Override
    public void eliminar(Integer id) {
        Cliente cliente = this.buscarPorId(id);
        if (cliente != null) {
            this.entityManager.remove(cliente);
        }
    }

    @Override
    public Cliente buscarPorCedula(String cedula) {
        TypedQuery<Cliente> query = this.entityManager
                .createQuery("SELECT c FROM Cliente c WHERE c.cedula = :cedula", Cliente.class);
        query.setParameter("cedula", cedula);
        return query.getResultList().stream().findFirst().orElse(null);
    }
} 