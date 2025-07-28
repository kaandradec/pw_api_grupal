package uce.edu.ec.api.dto;

import java.math.BigDecimal;

public class ReporteFacturaDto {
    private String numeroDocumento;
    private String identificacionCliente;
    private String nombreCliente;
    private Integer cantidadItems;
    private BigDecimal totalImpuestos;
    private BigDecimal total;

    public ReporteFacturaDto() {
    }

    public ReporteFacturaDto(String numeroDocumento, String identificacionCliente, 
                           String nombreCliente, Integer cantidadItems, 
                           BigDecimal totalImpuestos, BigDecimal total) {
        this.numeroDocumento = numeroDocumento;
        this.identificacionCliente = identificacionCliente;
        this.nombreCliente = nombreCliente;
        this.cantidadItems = cantidadItems;
        this.totalImpuestos = totalImpuestos;
        this.total = total;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    
    public String getIdentificacionCliente() {
        return identificacionCliente;
    }
    
    public void setIdentificacionCliente(String identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    public Integer getCantidadItems() {
        return cantidadItems;
    }
    
    public void setCantidadItems(Integer cantidadItems) {
        this.cantidadItems = cantidadItems;
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
}
