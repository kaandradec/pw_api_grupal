package uce.edu.ec.api.service;

import java.time.LocalDate;
import java.util.List;
import uce.edu.ec.api.repository.modelo.dto.ReporteFacturaDto;

public interface IReporteFacturaService {
  List<ReporteFacturaDto> buscarTodos();

  List<ReporteFacturaDto> buscarConFiltros(
      String numeroDocumento,
      String identificacionCliente,
      LocalDate fechaInicio,
      LocalDate fechaFin);
}
