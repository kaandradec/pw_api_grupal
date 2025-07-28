package uce.edu.ec.api.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "impuesto")
public class Impuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "impu_id")
    private Integer id;
    
    @Column(name = "impu_codigo")
    private String codigo;
    
    @Column(name = "impu_nombre")
    private String nombre;
    
    @Column(name = "impu_porcentaje")
    private BigDecimal porcentaje;

    public Impuesto(Integer id) {
        this.id = id;
    }

    public Impuesto() {
    }
    
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
    
    public BigDecimal getPorcentaje() {
        return porcentaje;
    }
    
    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }
    
}

/*
 	INSERT INTO impuesto (impu_codigo, impu_nombre, impu_porcentaje)
VALUES ('456', 'ICE', 10.00);

INSERT INTO impuesto (impu_codigo, impu_nombre, impu_porcentaje)
VALUES ('789', 'ISD', 5.00);

	INSERT INTO impuesto (impu_codigo, impu_nombre, impu_porcentaje)
VALUES ('123', 'IVA', 30.00);
 */