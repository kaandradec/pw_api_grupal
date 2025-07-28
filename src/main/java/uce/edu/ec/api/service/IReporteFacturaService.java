package uce.edu.ec.api.service;

import java.util.List;

import uce.edu.ec.api.repository.modelo.dto.ReporteFacturaDto;

public interface IReporteFacturaService {
  List<ReporteFacturaDto> buscarTodos();
}
