package uce.edu.ec.api.repository.modelo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class FacturaTo {
    private Integer id;
    private String rucEmpresa;
    private String numeroDocumento;
    private String establecimiento;
    private String puntoEmision;
    private LocalDate fechaEmision;
    private BigDecimal subtotal;
    private BigDecimal totalImpuestos;
    private BigDecimal total;
    private ClienteTo cliente;
    private List<FacturaDetalleTo> detalles;

    public FacturaTo() {
    }

    public FacturaTo(Integer id, String rucEmpresa, String numeroDocumento, String establecimiento,
            String puntoEmision, LocalDate fechaEmision, BigDecimal subtotal, BigDecimal totalImpuestos,
            BigDecimal total, ClienteTo cliente, List<FacturaDetalleTo> detalles) {
        this.id = id;
        this.rucEmpresa = rucEmpresa;
        this.numeroDocumento = numeroDocumento;
        this.establecimiento = establecimiento;
        this.puntoEmision = puntoEmision;
        this.fechaEmision = fechaEmision;
        this.subtotal = subtotal;
        this.totalImpuestos = totalImpuestos;
        this.total = total;
        this.cliente = cliente;
        this.detalles = detalles;
    }

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

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotalImpuestos() {
        return totalImpuestos;
    }

    public void setTotalImpuestos(BigDecimal totalImpuestos) {
        this.totalImpuestos = totalImpuestos;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public ClienteTo getCliente() {
        return cliente;
    }

    public void setCliente(ClienteTo cliente) {
        this.cliente = cliente;
    }

    public List<FacturaDetalleTo> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<FacturaDetalleTo> detalles) {
        this.detalles = detalles;
    }
} 