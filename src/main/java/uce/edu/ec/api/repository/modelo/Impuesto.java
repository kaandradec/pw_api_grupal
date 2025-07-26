package uce.edu.ec.api.repository.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "impuesto")
public class Impuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imp_id")
    private Integer id;
    @Column(name = "imp_nombre")
    private String nombre;
    @Column(name = "imp_porcentaje")
    private Double porcentaje;

    @OneToMany(mappedBy = "impuestos")
    @JsonIgnore
    private List<ProductoServicio> ProductoServicio;

    // get y set

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public List<ProductoServicio> getProductoServicio() {
        return ProductoServicio;
    }

    public void setProductoServicio(List<ProductoServicio> productoServicio) {
        ProductoServicio = productoServicio;
    }

}
