package uce.edu.ec.api.service.to;


public class FacturaTo {

   
    private Integer id;
    private String rucEmpresa;
    private String numeroDocumento; 
    private String establecimiento;
    private String puntoEmision;
    private String ideCliente;
    private String nombreCliente;
    private String direccion;
    private String correo;
    private Double SubTotal;
    private Double totalImpuesto;
    private Double total;

    public FacturaTo(Integer id, String rucEmpresa, String numeroDocumento, String establecimiento, String puntoEmision,
            String ideCliente, String nombreCliente, String direccion, String correo, Double subTotal,
            Double totalImpuesto, Double total) {
        this.id = id;
        this.rucEmpresa = rucEmpresa;
        this.numeroDocumento = numeroDocumento;
        this.establecimiento = establecimiento;
        this.puntoEmision = puntoEmision;
        this.ideCliente = ideCliente;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.correo = correo;
        SubTotal = subTotal;
        this.totalImpuesto = totalImpuesto;
        this.total = total;
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

    
    
}
