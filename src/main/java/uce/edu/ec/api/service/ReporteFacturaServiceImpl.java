package uce.edu.ec.api.service;

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

}
