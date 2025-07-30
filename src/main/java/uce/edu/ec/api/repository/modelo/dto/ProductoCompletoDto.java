package uce.edu.ec.api.repository.modelo.dto;

import java.math.BigDecimal;
import java.util.List;

public class ProductoCompletoDto {
    private Integer id;
    private String codigoBarras;
    private String nombre;
    private String categoria;
    private BigDecimal precio;
    private Integer stock;
    private BodegaTo bodega;
    private List<ImpuestoDto> impuestos;

    public ProductoCompletoDto() {
    }

    public ProductoCompletoDto(Integer id, String codigoBarras, String nombre, String categoria, 
                              BigDecimal precio, Integer stock, BodegaTo bodega, List<ImpuestoDto> impuestos) {
        this.id = id;
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.bodega = bodega;
        this.impuestos = impuestos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BodegaTo getBodega() {
        return bodega;
    }

    public void setBodega(BodegaTo bodega) {
        this.bodega = bodega;
    }

    public List<ImpuestoDto> getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(List<ImpuestoDto> impuestos) {
        this.impuestos = impuestos;
    }
} 