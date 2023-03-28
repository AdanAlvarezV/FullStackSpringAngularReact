package com.example.demo.fullstack.DemoFullStack.service;


import com.example.demo.fullstack.DemoFullStack.model.Persona;
import com.example.demo.fullstack.DemoFullStack.model.UnidadNegocio;

import java.util.List;

public interface PersonaService {

    List<Persona> getAllPersona();

    Persona findById(Integer id);

    List<Persona> findByStatus(Boolean status);

    List<Persona> findBySupervisor(Persona supervisor);

    List<Persona> findByUnidadNegocio(UnidadNegocio unidadNegocio);

    Persona createPersona(Persona persona);

    Persona updatePersona(Persona persona, Integer id);

    Persona deletePersona(Integer id);
}
