package uce.edu.ec.api.repository;

import java.time.LocalDate;
import java.util.ArrayList;
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

  @Override
  public List<ReporteFacturaDto> seleccionarConFiltros(
      String numeroDocumento,
      String identificacionCliente,
      LocalDate fechaInicio,
      LocalDate fechaFin) {

    StringBuilder jpql = new StringBuilder("""
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
        WHERE 1=1
        """);

    // Lista para parámetros
    List<String> condiciones = new ArrayList<>();

    // Agregar filtros dinámicamente
    if (numeroDocumento != null && !numeroDocumento.trim().isEmpty()) {
      condiciones.add(" AND f.numeroDocumento LIKE :numeroDocumento");
    }

    if (identificacionCliente != null && !identificacionCliente.trim().isEmpty()) {
      condiciones.add(" AND c.cedula LIKE :identificacionCliente");
    }

    if (fechaInicio != null) {
      condiciones.add(" AND f.fechaEmision >= :fechaInicio");
    }

    if (fechaFin != null) {
      condiciones.add(" AND f.fechaEmision <= :fechaFin");
    }

    // Agregar condiciones a la consulta
    condiciones.forEach(c -> {
      jpql.append(c);
    });

    jpql.append("""
         GROUP BY f.id, f.numeroDocumento, c.cedula, c.nombre, c.apellido, f.totalImpuestos, f.total
         ORDER BY f.fechaEmision DESC
        """);

    // Crear query
    TypedQuery<ReporteFacturaDto> query = this.entityManager
        .createQuery(jpql.toString(), ReporteFacturaDto.class);

    if (numeroDocumento != null && !numeroDocumento.trim().isEmpty()) {
      query.setParameter("numeroDocumento", "%" + numeroDocumento + "%");
    }

    if (identificacionCliente != null && !identificacionCliente.trim().isEmpty()) {
      query.setParameter("identificacionCliente", "%" + identificacionCliente + "%");
    }

    if (fechaInicio != null) {
      query.setParameter("fechaInicio", fechaInicio);
    }

    if (fechaFin != null) {
      query.setParameter("fechaFin", fechaFin);
    }

    return query.getResultList();
  }

}
