package uce.edu.ec.api.service;

import java.time.LocalDate;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.api.repository.IReporteFacturaRepo;
import uce.edu.ec.api.repository.modelo.dto.ReporteFacturaDto;

@ApplicationScoped
public class ReporteFacturaServiceImpl implements IReporteFacturaService {

  @Inject
  private IReporteFacturaRepo iReporteFacturaRepo;

  @Override
  public List<ReporteFacturaDto> buscarTodos() {
    return this.iReporteFacturaRepo.seleccionarTodos();
  }

  @Override
  public List<ReporteFacturaDto> buscarConFiltros(
      String numeroDocumento,
      String identificacionCliente,
      LocalDate fechaInicio,
      LocalDate fechaFin) {

    // Si no hay filtros, buscar sin filtros
    boolean sinFiltros = (numeroDocumento == null || numeroDocumento.trim().isEmpty()) &&
        (identificacionCliente == null || identificacionCliente.trim().isEmpty()) &&
        fechaInicio == null && fechaFin == null;

    if (sinFiltros) {
      return this.buscarTodos();
    }

    return this.iReporteFacturaRepo.seleccionarConFiltros(
        numeroDocumento, identificacionCliente, fechaInicio, fechaFin);
  }
}
