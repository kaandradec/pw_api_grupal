package uce.edu.ec.api.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Integer id;
    @Column(name = "producto_codigoBarras")
    private String codigoBarras;
    @Column(name = "producto_nombre")
    private String nombre;
    @Column(name = "producto_categoria")
    private String categoria;
    @Column(name = "producto_precio")
     private BigDecimal precio;
    @Column(name = "producto_stock")
    private Integer stock;
    // Impuestos individuales
    @Column(name = "producto_iva")
    private BigDecimal iva;
    @Column(name = "producto_ice")
    private BigDecimal ice;
    @Column(name = "producto_isd")
    private BigDecimal isd;
    //S_G
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
    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public BigDecimal getIva() {
        return iva;
    }
    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }
    public BigDecimal getIce() {
        return ice;
    }
    public void setIce(BigDecimal ice) {
        this.ice = ice;
    }
    public BigDecimal getIsd() {
        return isd;
    }
    public void setIsd(BigDecimal isd) {
        this.isd = isd;
    }
 
}
