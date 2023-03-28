package com.example.demo.fullstack.DemoFullStack.service;

import com.example.demo.fullstack.DemoFullStack.common.exception.BusinessException;
import com.example.demo.fullstack.DemoFullStack.model.UnidadNegocio;
import com.example.demo.fullstack.DemoFullStack.repository.UnidadNegocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UnidadNegocioServiceImpl implements UnidadNegocioService{

    @Autowired
    private UnidadNegocioRepository unidadNegocioRepository;

    @Override
    public List<UnidadNegocio> getAllUnidades() {
        return unidadNegocioRepository.findAll();
    }

    @Override
    public UnidadNegocio findById(Integer id) {
        return unidadNegocioRepository.findById(id).get();
    }

    @Override
    public List<UnidadNegocio> findByStatus(Boolean status) {
        return unidadNegocioRepository.findByStatus(status);
    }

    @Override
    public List<UnidadNegocio> findByUnidadPadre(UnidadNegocio unidadNegocio) {
        return unidadNegocioRepository.findByUnidadPadre(unidadNegocio);
    }

    @Override
    public UnidadNegocio createUnidadNegocio(UnidadNegocio unidadNegocio) {
        return unidadNegocioRepository.save(unidadNegocio);
    }

    @Override
    public UnidadNegocio updateUnidadNegocio(UnidadNegocio unidadNegocio, Integer id) {
        Optional<UnidadNegocio> unidadForUpdate = unidadNegocioRepository.findById(id);
        if (!unidadForUpdate.isPresent()){
            throw new BusinessException("ID de unidad, inváido", HttpStatus.BAD_REQUEST);
        }
        unidadForUpdate.get().setNombre(unidadNegocio.getNombre());
        unidadForUpdate.get().setUnidadPadre(unidadNegocio.getUnidadPadre());
        unidadForUpdate.get().setGerente(unidadNegocio.getGerente());
        return unidadNegocioRepository.save(unidadForUpdate.get());
    }

    @Override
    public UnidadNegocio deleteUnidadNegocio(Integer id) {
        Optional<UnidadNegocio> unidadNegocio = unidadNegocioRepository.findById(id);
        if (!unidadNegocio.isPresent()){
            throw new BusinessException("", HttpStatus.BAD_REQUEST);
        }
        unidadNegocio.get().setStatus(Boolean.FALSE);
        return unidadNegocioRepository.save(unidadNegocio.get());
    }
}
