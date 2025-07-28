package uce.edu.ec.api.service.To;

public class ErrorResponseTo {
  private String error;
  private String mensaje;
  private String codigo;

  public ErrorResponseTo() {
  }

  public ErrorResponseTo(String mensaje) {
    this.mensaje = mensaje;
  }

  public ErrorResponseTo(String error, String mensaje) {
    this.error = error;
    this.mensaje = mensaje;
  }

  public ErrorResponseTo(String error, String mensaje, String codigo) {
    this.error = error;
    this.mensaje = mensaje;
    this.codigo = codigo;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
}
