package uce.edu.ec.api.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto_servicio")
public class ProductoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(name = "prod_codigo_barras")
    private String codigoBarras;
    @Column(name = "prod_nombre")
    private String nombre;
    @Column(name = "prod_categoria")
    private Integer categoria;
    @Column(name = "prod_stock")
    private Integer stock;
    @Column(name = "prod_precio")
    private Double precio;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "producto_impuesto", 
               joinColumns = @JoinColumn(name = "producto_id"), 
               inverseJoinColumns = @JoinColumn(name = "impuesto_id"))
    private List<Impuesto> impuestos;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "prod_fk_bodega")
    private Bodega bodega;

     @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "prod_factura")
    private Factura Factura;

         // set y get
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

     public Integer getCategoria() {
         return categoria;
     }

     public void setCategoria(Integer categoria) {
         this.categoria = categoria;
     }

     public Integer getStock() {
         return stock;
     }

     public void setStock(Integer stock) {
         this.stock = stock;
     }

     public Double getPrecio() {
         return precio;
     }

     public void setPrecio(Double precio) {
         this.precio = precio;
     }

     public List<Impuesto> getImpuestos() {
         return impuestos;
     }

     public void setImpuestos(List<Impuesto> impuestos) {
         this.impuestos = impuestos;
     }

     public Bodega getBodega() {
         return bodega;
     }

     public void setBodega(Bodega bodega) {
         this.bodega = bodega;
     }

     public Factura getFactura() {
         return Factura;
     }

     public void setFactura(Factura factura) {
         Factura = factura;
     }

   

   
}
