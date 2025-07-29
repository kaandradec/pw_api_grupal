package uce.edu.ec.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.api.repository.IClienteRepo;
import uce.edu.ec.api.repository.modelo.Cliente;


import java.util.List;

@ApplicationScoped
public class ClienteServiceImpl implements IClienteService{

    @Inject
    private IClienteRepo clienteRepo;

    @Override
    public Cliente buscarPorId(Integer id) {
        return this.clienteRepo.buscarPorId(id);
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return this.clienteRepo.obtenerTodos();
    }

    @Override
    public void insertar(Cliente cliente) {
        this.clienteRepo.insertar(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
        this.clienteRepo.actualizar(cliente);
    }

    @Override
    public void actualizarParcial(Cliente cliente) {
        this.clienteRepo.actualizarParcial(cliente);
    }

    @Override
    public void eliminar(Integer id) {
        this.clienteRepo.eliminar(id);
    }
}
