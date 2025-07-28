package uce.edu.ec.api.repository;

import java.util.List;

import uce.edu.ec.api.repository.modelo.dto.ReporteFacturaDto;

public interface IReporteFacturaRepo {
  List<ReporteFacturaDto> seleccionarTodos();
}
