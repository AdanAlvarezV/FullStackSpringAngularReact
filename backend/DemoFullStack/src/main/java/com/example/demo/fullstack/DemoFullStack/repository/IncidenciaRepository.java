package com.example.demo.fullstack.DemoFullStack.repository;

import com.example.demo.fullstack.DemoFullStack.model.Incidencia;
import com.example.demo.fullstack.DemoFullStack.model.Persona;
import com.example.demo.fullstack.DemoFullStack.model.UnidadNegocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, Integer> {

    List<Incidencia> findByReporta(Persona reporta);

    List<Incidencia> findByReportado(Persona reportado);

    List<Incidencia> findByReportaAndReportado(Persona reporta, Persona reportado);

    List<Incidencia> findByStatus(String status);

    List<Incidencia> findByFecha(Date fecha);

    List<Incidencia> findByFechaBetween(Date fechaInicio, Date fechaFin);

    List<Incidencia> findByFechaGreaterThanEqual(Date fecha);

    List<Incidencia> findByFechaLessThanEqual(Date fecha);

    List<Incidencia> findByFechaAfter(Date fecha);

    List<Incidencia> findByFechaBefore(Date fecha);

    @Query("SELECT i FROM Incidencia i WHERE i.reportado.unidadNegocio = :unidadNegocio")
    List<Incidencia> findByUnidadNegocioReportado(UnidadNegocio unidadNegocio);

    @Query("SELECT i FROM Incidencia i WHERE i.reporta.unidadNegocio = :unidadNegocio")
    List<Incidencia> findByUnidadNegocioReporta(UnidadNegocio unidadNegocio);

    @Query("SELECT i FROM Incidencia i WHERE i.fecha BETWEEN :fechaInicio AND :fechaFin")
    List<Incidencia> findByFechaBetweenFechaInicioAndFechaFin(Date fechaInicio, Date fechaFin);

    @Query("SELECT i FROM Incidencia i WHERE i.fecha >= :fecha")
    List<Incidencia> findByFechaGreaterThanEqualQuery(Date fecha);

    @Query("SELECT i FROM Incidencia i WHERE i.fecha <= :fecha")
    List<Incidencia> findByFechaLessThanEqualQuery(Date fecha);
}
