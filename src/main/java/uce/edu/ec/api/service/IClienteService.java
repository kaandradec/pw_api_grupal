package uce.edu.ec.api.service;

import java.util.List;

import uce.edu.ec.api.repository.modelo.dto.ClienteTo;

public interface IClienteService {
    void crear(ClienteTo clienteTo);
    void actualizar(ClienteTo clienteTo);
    ClienteTo buscarPorId(Integer id);
    List<ClienteTo> buscarTodos();
    void eliminar(Integer id);
    ClienteTo buscarPorCedula(String cedula);
} 