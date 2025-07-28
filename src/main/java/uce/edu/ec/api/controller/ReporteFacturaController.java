package uce.edu.ec.api.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.ec.api.repository.modelo.dto.ReporteFacturaDto;
import uce.edu.ec.api.service.IReporteFacturaService;
import uce.edu.ec.api.service.To.ErrorResponseTo;

@Path("/reportes")
@Produces(MediaType.APPLICATION_JSON)
public class ReporteFacturaController {

  @Inject
  private IReporteFacturaService iReporteFacturaService;

  @GET
  @Path("")
  public Response buscarReportes(
      @QueryParam("numeroDocumento") String numeroDocumento,
      @QueryParam("identificacionCliente") String identificacionCliente,
      @QueryParam("fechaInicio") String fechaInicioStr,
      @QueryParam("fechaFin") String fechaFinStr) {

    LocalDate fechaInicio = null;
    LocalDate fechaFin = null;

    if (fechaInicioStr != null
        && fechaFinStr != null
        && !fechaInicioStr.trim().isEmpty()
        && !fechaFinStr.trim().isEmpty()) {
      try {
        fechaInicio = LocalDate.parse(fechaInicioStr);
        fechaFin = LocalDate.parse(fechaFinStr);
      } catch (DateTimeParseException e) {
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(new ErrorResponseTo("Formato de fecha inicio inválido. Use YYYY-MM-DD"))
            .build();
      }
    }

    try {

      // Buscar reportes con filtros
      List<ReporteFacturaDto> reportes = this.iReporteFacturaService.buscarConFiltros(
          numeroDocumento, identificacionCliente, fechaInicio, fechaFin);

      return Response.status(Response.Status.OK).entity(reportes).build();

    } catch (Exception e) {
      e.printStackTrace();
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
          .build();
    }
  }
}
