package com.example.demo.fullstack.DemoFullStack.service;

import com.example.demo.fullstack.DemoFullStack.model.Incidencia;
import com.example.demo.fullstack.DemoFullStack.model.Persona;
import com.example.demo.fullstack.DemoFullStack.model.UnidadNegocio;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface IncidenciaService {

    List<Incidencia> getAllIncidencias();

    Incidencia findById(Integer id);

    Incidencia createIncidencia(Incidencia incidencia);

    Incidencia updateIncidencia(Incidencia incidencia, Integer id);

    Incidencia deleteIncidencia(Integer id);

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

    List<Incidencia> findByUnidadNegocioReportado(UnidadNegocio unidadNegocio);

    List<Incidencia> findByUnidadNegocioReporta(UnidadNegocio unidadNegocio);

    List<Incidencia> findByFechaBetweenFechaInicioAndFechaFin(Date fechaInicio, Date fechaFin);

    List<Incidencia> findByFechaGreaterThanEqualQuery(Date fecha);

    List<Incidencia> findByFechaLessThanEqualQuery(Date fecha);
}
