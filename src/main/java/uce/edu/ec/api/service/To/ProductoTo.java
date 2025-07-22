package uce.edu.ec.api.service.To;

import java.math.BigDecimal;
public class ProductoTo {
    private Integer id;
    private String codigoBarras;
    private String nombre;
    private String categoria;
    private Integer stock;
    private BigDecimal precio;
    //impuestos
    private BigDecimal iva;
    private BigDecimal ice;
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
    
