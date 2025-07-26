package uce.edu.ec.api.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Factura")
public class Factura {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "fact_Ruc_empresa")
    private String rucEmpresa;
     @Column(name = "fact_numero_documento")
    private String numeroDocumento; 
    @Column(name = "fact_establecimiento")
    private String establecimiento;
    @Column(name = "fact_punto_emisicion")
    private String puntoEmision;
    @Column(name = "fact_ide_cliente")
    private String ideCliente;
    @Column(name = "fact_nombre_cliente")
    private String nombreCliente;
    @Column(name = "fact_direccion")
    private String direccion;
    @Column(name = "fact_correo")
    private String correo;
    @Column(name = "fact_subtotal")
    private Double SubTotal;
    @Column(name = "fact_total_impuesto")
    private Double totalImpuesto;
    @Column(name = "fact_total")
    private Double total;

    @OneToMany(mappedBy ="factura")
    private List<DetalleFactura> DetalleFactura;

    @ManyToOne()
    @JoinColumn(name = "cliente_cedula")
    private Cliente cliente;

    
    //GET y SET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRucEmpresa() {
        return rucEmpresa;
    }

    public void setRucEmpresa(String rucEmpresa) {
        this.rucEmpresa = rucEmpresa;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getPuntoEmision() {
        return puntoEmision;
    }

    public void setPuntoEmision(String puntoEmision) {
        this.puntoEmision = puntoEmision;
    }

    public String getIdeCliente() {
        return ideCliente;
    }

    public void setIdeCliente(String ideCliente) {
        this.ideCliente = ideCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(Double subTotal) {
        SubTotal = subTotal;
    }

    public Double getTotalImpuesto() {
        return totalImpuesto;
    }

    public void setTotalImpuesto(Double totalImpuesto) {
        this.totalImpuesto = totalImpuesto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<DetalleFactura> getDetalleFactura() {
        return DetalleFactura;
    }

    public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
        DetalleFactura = detalleFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Factura [id=" + id + ", rucEmpresa=" + rucEmpresa + ", numeroDocumento=" + numeroDocumento
                + ", establecimiento=" + establecimiento + ", puntoEmision=" + puntoEmision + ", ideCliente="
                + ideCliente + ", nombreCliente=" + nombreCliente + ", direccion=" + direccion + ", correo=" + correo
                + ", SubTotal=" + SubTotal + ", totalImpuesto=" + totalImpuesto + ", total=" + total
                + ", DetalleFactura=" + DetalleFactura + ", cliente=" + cliente + "]";
    }
    

}
