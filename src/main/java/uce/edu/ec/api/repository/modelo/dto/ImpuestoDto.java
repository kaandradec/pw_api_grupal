package uce.edu.ec.api.repository.modelo.dto;

import java.math.BigDecimal;

public class ImpuestoDto {
    private Integer id;
    private String codigo;
    private String nombre;
    private BigDecimal porcentaje;

    public ImpuestoDto() {
    }

    public ImpuestoDto(Integer id, String codigo, String nombre, BigDecimal porcentaje) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
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