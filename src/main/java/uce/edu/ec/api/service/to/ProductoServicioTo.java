package uce.edu.ec.api.service.to;


public class ProductoServicioTo {

    private Integer id;
    private String codigoBarras;
    private String nombre;
    private Integer categoria;
    private Integer stock;
    private Double precio;
    
    public ProductoServicioTo(Integer id, String codigoBarras, String nombre, Integer categoria, Integer stock,
            Double precio) {
        this.id = id;
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
        this.precio = precio;
    }
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
    @Override
    public String toString() {
        return "ProductoServicioTo [id=" + id + ", codigoBarras=" + codigoBarras + ", nombre=" + nombre + ", categoria="
                + categoria + ", stock=" + stock + ", precio=" + precio + "]";
    }


}
