package uce.edu.ec.api.repository;

import java.time.LocalDate;
import java.util.List;

import uce.edu.ec.api.repository.modelo.dto.ReporteFacturaDto;

public interface IReporteFacturaRepo {
  List<ReporteFacturaDto> seleccionarTodos();

  List<ReporteFacturaDto> seleccionarConFiltros(
      String numeroDocumento,
      String identificacionCliente,
      LocalDate fechaInicio,
      LocalDate fechaFin);
}
