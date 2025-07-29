package uce.edu.ec.api.service.mapper;

import uce.edu.ec.api.repository.modelo.Cliente;
import uce.edu.ec.api.repository.modelo.dto.ClienteTo;

public class ClienteMapper {

    public static ClienteTo toTo(Cliente cliente) {
        ClienteTo cTo = new ClienteTo();
        cTo.setId(cliente.getId());
        cTo.setRazonSocial(cliente.getRazonSocial());
        cTo.setCedula(cliente.getCedula());
        cTo.setNombre(cliente.getNombre());
        cTo.setApellido(cliente.getApellido());
        cTo.setEmail(cliente.getEmail());
        cTo.setTelefono(cliente.getTelefono());
        cTo.setDireccion(cliente.getDireccion());

        return cTo;
    }

    public static Cliente ToEntity(ClienteTo clienteTo) {
        Cliente c = new Cliente();
        c.setId(clienteTo.getId());
        c.setCedula(clienteTo.getCedula());
        c.setRazonSocial(clienteTo.getRazonSocial());
        c.setNombre(clienteTo.getNombre());
        c.setApellido(clienteTo.getApellido());
        c.setEmail(clienteTo.getEmail());
        c.setTelefono(clienteTo.getTelefono());
        c.setDireccion(clienteTo.getDireccion());
        return c;
    }

    public static ClienteTo convertir(Cliente cliente) {
        return null;
    }
}
