package com.example.demo.fullstack.DemoFullStack.service;

import com.example.demo.fullstack.DemoFullStack.model.UnidadNegocio;

import java.util.List;

public interface UnidadNegocioService {

    List<UnidadNegocio> getAllUnidades();

    UnidadNegocio findById(Integer id);

    List<UnidadNegocio> findByStatus(Boolean status);

    List<UnidadNegocio> findByUnidadPadre(UnidadNegocio unidadNegocio);

    UnidadNegocio createUnidadNegocio(UnidadNegocio unidadNegocio);

    UnidadNegocio updateUnidadNegocio(UnidadNegocio unidadNegocio, Integer id);

    UnidadNegocio deleteUnidadNegocio(Integer id);
}
