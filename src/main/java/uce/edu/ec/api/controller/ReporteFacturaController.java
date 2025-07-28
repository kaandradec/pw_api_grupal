package uce.edu.ec.api.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.ec.api.repository.modelo.dto.ReporteFacturaDto;
import uce.edu.ec.api.service.IReporteFacturaService;

@Path("/reportes")
@Produces(MediaType.APPLICATION_JSON)
public class ReporteFacturaController {

  @Inject
  private IReporteFacturaService iReporteFacturaService;

  @GET
  @Path("")
  public Response buscarTodos() {
    try {
      List<ReporteFacturaDto> reportes = this.iReporteFacturaService.buscarTodos();
      return Response.status(Response.Status.OK).entity(reportes).build();
    } catch (Exception e) {
      e.printStackTrace();
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }

}
