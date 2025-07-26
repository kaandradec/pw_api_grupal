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
@Table(name="bodega")
public class Bodega {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="bod-codigo")
    private String codigo;
    @Column(name="bod-nombre")
    private String nombre;
    @Column(name="bod-ubicacion")
    private String ubicacion;

    @OneToMany(mappedBy = "bodegas")
    private List<ProductoServicio> ProductoServicio;
    

    //get y set

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    @Override
    public String toString() {
        return "Bodega [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", ubicacion=" + ubicacion + "]";
    }
  

    
}
