package uce.edu.ec.api.repository.modelo.dto;

import java.math.BigDecimal;

import uce.edu.ec.api.service.To.ProductoTo;

public class FacturaDetalleTo {
    private Integer id;
    private Integer cantidad;
    private BigDecimal precio;
    private BigDecimal subtotal;
    private ProductoTo producto;

    public FacturaDetalleTo() {
    }

    public FacturaDetalleTo(Integer id, Integer cantidad, BigDecimal precio, BigDecimal subtotal, ProductoTo producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.producto = producto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public ProductoTo getProducto() {
        return producto;
    }

    public void setProducto(ProductoTo producto) {
        this.producto = producto;
    }
} 