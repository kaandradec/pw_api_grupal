package uce.edu.ec.api.service.to;

import java.util.Map;


public class BodegaTo {

    private Integer id;
    private String codigo;
    private String nombre;
    private String ubicacion;



    public BodegaTo(Integer id, String codigo, String nombre, String ubicacion, Map<String, String> _links) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;

    }
    

    public BodegaTo() {
       
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "BodegaTo [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", ubicacion=" + ubicacion + "]";
    }
   
    

}
