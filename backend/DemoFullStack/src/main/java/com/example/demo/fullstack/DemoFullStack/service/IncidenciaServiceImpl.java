package com.example.demo.fullstack.DemoFullStack.service;

import com.example.demo.fullstack.DemoFullStack.common.exception.BusinessException;
import com.example.demo.fullstack.DemoFullStack.model.Incidencia;
import com.example.demo.fullstack.DemoFullStack.model.Persona;
import com.example.demo.fullstack.DemoFullStack.model.UnidadNegocio;
import com.example.demo.fullstack.DemoFullStack.repository.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IncidenciaServiceImpl implements IncidenciaService{

    @Autowired
    private IncidenciaRepository incidenciaRepository;

    @Override
    public List<Incidencia> getAllIncidencias() {
        return incidenciaRepository.findAll();
    }

    @Override
    public Incidencia findById(Integer id) {
        return incidenciaRepository.findById(id).get();
    }

    @Override
    public List<Incidencia> findByStatus(String status) {
        return incidenciaRepository.findByStatus(status);
    }

    @Override
    public Incidencia createIncidencia(Incidencia incidencia) {
        return incidenciaRepository.save(incidencia);
    }

    @Override
    public Incidencia updateIncidencia(Incidencia incidencia, Integer id) {
        Optional<Incidencia> incidenciaForUpdate = incidenciaRepository.findById(id);
        if (!incidenciaForUpdate.isPresent()){
            throw new BusinessException("ID de incidencia, inváido", HttpStatus.BAD_REQUEST);
        }
        incidenciaForUpdate.get().setReporta(incidencia.getReporta());
        incidenciaForUpdate.get().setReportado(incidencia.getReportado());
        incidenciaForUpdate.get().setDescripcion(incidencia.getDescripcion());
        incidenciaForUpdate.get().setStatus(incidencia.getStatus());
        return incidenciaRepository.save(incidenciaForUpdate.get());
    }

    @Override
    public Incidencia deleteIncidencia(Integer id) {
        Optional<Incidencia> incidencia = incidenciaRepository.findById(id);
        if (!incidencia.isPresent()){
            throw new BusinessException("", HttpStatus.BAD_REQUEST);
        }
        incidencia.get().setStatus("Eliminado");
        return incidenciaRepository.save(incidencia.get());
    }

    @Override
    public List<Incidencia> findByReporta(Persona reporta) {
        return incidenciaRepository.findByReporta(reporta);
    }

    @Override
    public List<Incidencia> findByReportado(Persona reportado) {
        return incidenciaRepository.findByReportado(reportado);
    }

    @Override
    public List<Incidencia> findByReportaAndReportado(Persona reporta, Persona reportado) {
        return incidenciaRepository.findByReportaAndReportado(reporta, reportado);
    }

    @Override
    public List<Incidencia> findByFecha(Date fecha) {
        return incidenciaRepository.findByFecha(fecha);
    }

    @Override
    public List<Incidencia> findByFechaBetween(Date fechaInicio, Date fechaFin) {
        return incidenciaRepository.findByFechaBetween(fechaInicio, fechaFin);
    }

    @Override
    public List<Incidencia> findByFechaGreaterThanEqual(Date fecha) {
        return incidenciaRepository.findByFechaGreaterThanEqual(fecha);
    }

    @Override
    public List<Incidencia> findByFechaLessThanEqual(Date fecha) {
        return incidenciaRepository.findByFechaLessThanEqual(fecha);
    }

    @Override
    public List<Incidencia> findByFechaAfter(Date fecha) {
        return incidenciaRepository.findByFechaAfter(fecha);
    }

    @Override
    public List<Incidencia> findByFechaBefore(Date fecha) {
        return incidenciaRepository.findByFechaBefore(fecha);
    }

    @Override
    public List<Incidencia> findByUnidadNegocioReportado(UnidadNegocio unidadNegocio) {
        return incidenciaRepository.findByUnidadNegocioReportado(unidadNegocio);
    }

    @Override
    public List<Incidencia> findByUnidadNegocioReporta(UnidadNegocio unidadNegocio) {
        return incidenciaRepository.findByUnidadNegocioReporta(unidadNegocio);
    }

    @Override
    public List<Incidencia> findByFechaBetweenFechaInicioAndFechaFin(Date fechaInicio, Date fechaFin) {
        return incidenciaRepository.findByFechaBetweenFechaInicioAndFechaFin(fechaInicio, fechaFin);
    }

    @Override
    public List<Incidencia> findByFechaGreaterThanEqualQuery(Date fecha) {
        return incidenciaRepository.findByFechaGreaterThanEqualQuery(fecha);
    }

    @Override
    public List<Incidencia> findByFechaLessThanEqualQuery(Date fecha) {
        return incidenciaRepository.findByFechaLessThanEqualQuery(fecha);
    }
}
