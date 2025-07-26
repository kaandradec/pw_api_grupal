package uce.edu.ec.api.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "clie_cedula")
    private String cedula;
    @Column(name = "clie_nombre")
    private String nombre;
    @Column(name = "clie_apellido")
    private String apellido;
    @Column(name = "clie_razon_social")
    private String razonSocial;
    @Column(name = "clie_direccion")
    private String direccion;
    @Column(name = "clie_telefono")
    private String telefono;
    @Column(name = "clie_email")
    private String email;

    @OneToMany(mappedBy ="Cliente")
    private List<Factura> factura;

    // get y set

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Factura> getFactura() {
        return factura;
    }

    public void setFactura(List<Factura> factura) {
        this.factura = factura;
    }

    @Override
    public String toString() {
        return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", razonSocial="
                + razonSocial + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email
                + ", factura=" + factura + "]";
    }


}
