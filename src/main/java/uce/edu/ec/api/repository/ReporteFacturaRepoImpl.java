package uce.edu.ec.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.ec.api.repository.modelo.dto.ReporteFacturaDto;

@Transactional
@ApplicationScoped
public class ReporteFacturaRepoImpl implements IReporteFacturaRepo {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<ReporteFacturaDto> seleccionarTodos() {
    TypedQuery<ReporteFacturaDto> query = this.entityManager
        .createQuery("""
            SELECT NEW uce.edu.ec.api.repository.modelo.dto.ReporteFacturaDto(
                f.numeroDocumento,
                c.cedula,
                CONCAT(c.nombre, ' ', c.apellido),
                CAST(COUNT(fd.id) AS INTEGER),
                f.totalImpuestos,
                f.total
            )
            FROM Factura f
            JOIN f.cliente c
            LEFT JOIN f.detalles fd
            GROUP BY f.id, f.numeroDocumento, c.cedula, c.nombre, c.apellido, f.totalImpuestos, f.total
            ORDER BY f.fechaEmision DESC
            """, ReporteFacturaDto.class);

    return query.getResultList();
  }

}
