package uce.edu.ec.api.repository;

import java.util.List;

import uce.edu.ec.api.repository.modelo.Cliente;

public interface IClienteRepo {
    void insertar(Cliente cliente);
    void actualizar(Cliente cliente);
    Cliente buscarPorId(Integer id);
    List<Cliente> buscarTodos();
    void eliminar(Integer id);
    Cliente buscarPorCedula(String cedula);
} 