package uce.edu.ec.api.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="detalle_Factura")
public class DetalleFactura {

 @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "detallef_codigo_barra")
private String CodigoBarra;
@Column(name = "detallef_nombre")
private String nombre;
@Column(name = "detallef_cantidad")
private Integer cantidad;
@Column(name = "detallef_precio")
private Double precio;
@Column(name = "detallef_subtotal")
private Double SubTotal;

@ManyToOne()
@JoinColumn(name = "factura_id")
private Factura factura;
//SET Y GET
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

public Factura getFactura() {
    return factura;
}

public void setFactura(Factura factura) {
    this.factura = factura;
}

@Override
public String toString() {
    return "DetalleFactura [CodigoBarra=" + CodigoBarra + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio="
            + precio + ", SubTotal=" + SubTotal + ", factura=" + factura + "]";
}
 

}
