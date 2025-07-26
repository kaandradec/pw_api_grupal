package uce.edu.ec.api.service.to;

public class ImpuestoTo {

    private Integer id;
    private String nombre;
    private Double porcentaje;
    
    public ImpuestoTo(Integer id, String nombre, Double porcentaje) {
        this.id = id;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return "ImpuestoTo [id=" + id + ", nombre=" + nombre + ", porcentaje=" + porcentaje + "]";
    }

    
}
