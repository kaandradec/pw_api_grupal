package uce.edu.ec.api.service.To;

import java.math.BigDecimal;
import java.util.List;

import uce.edu.ec.api.repository.modelo.dto.BodegaTo;
import uce.edu.ec.api.repository.modelo.dto.ImpuestoDto;

public class ProductoTo {
    private Integer id;
    private String codigoBarras;
    private String nombre;
    private String categoria;
    private Integer stock;
    private BigDecimal precio;
    private List<ImpuestoDto> impuestos;
    private BodegaTo bodega;

    public BodegaTo getBodega() {
    return bodega;
    }

    public void setBodega(BodegaTo bodega) {
        this.bodega = bodega;
    }

    public ProductoTo() {
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
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Integer getStock() {
        return stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<ImpuestoDto> getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(List<ImpuestoDto> impuestos) {
        this.impuestos = impuestos;
    }
}
    
