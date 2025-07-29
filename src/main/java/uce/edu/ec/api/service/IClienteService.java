package uce.edu.ec.api.service;


import uce.edu.ec.api.repository.modelo.Cliente;

import java.util.List;

public interface IClienteService {

    public Cliente buscarPorId(Integer id);
    public List<Cliente> obtenerTodos();
    public void insertar(Cliente cliente);
    public void actualizar(Cliente cliente);
    public void actualizarParcial(Cliente cliente);
    public void eliminar(Integer id);
}
