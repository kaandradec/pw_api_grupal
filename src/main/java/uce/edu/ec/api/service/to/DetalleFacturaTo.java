package uce.edu.ec.api.service.to;


public class DetalleFacturaTo {


private String CodigoBarra;

private String nombre;

private Integer cantidad;

private Double precio;

private Double SubTotal;

public DetalleFacturaTo(String codigoBarra, String nombre, Integer cantidad, Double precio, Double subTotal) {
    CodigoBarra = codigoBarra;
    this.nombre = nombre;
    this.cantidad = cantidad;
    this.precio = precio;
    SubTotal = subTotal;
}
//Get y SET
public String getCodigoBarra() {
    return CodigoBarra;
}

public void setCodigoBarra(String codigoBarra) {
    CodigoBarra = codigoBarra;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public Integer getCantidad() {
    return cantidad;
}

public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
}

public Double getPrecio() {
    return precio;
}

public void setPrecio(Double precio) {
    this.precio = precio;
}

public Double getSubTotal() {
    return SubTotal;
}

public void setSubTotal(Double subTotal) {
    SubTotal = subTotal;
}


}
