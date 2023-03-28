package com.example.demo.fullstack.DemoFullStack.service;

import com.example.demo.fullstack.DemoFullStack.common.exception.BusinessException;
import com.example.demo.fullstack.DemoFullStack.model.Persona;
import com.example.demo.fullstack.DemoFullStack.model.UnidadNegocio;
import com.example.demo.fullstack.DemoFullStack.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> getAllPersona() {
        return personaRepository.findAll();
    }

    @Override
    public Persona findById(Integer id) {
        return personaRepository.findById(id).get();
    }

    @Override
    public List<Persona> findByStatus(Boolean status) {
        return personaRepository.findByStatus(status);
    }

    @Override
    public List<Persona> findBySupervisor(Persona supervisor) {
        return personaRepository.findBySupervisor(supervisor);
    }

    @Override
    public List<Persona> findByUnidadNegocio(UnidadNegocio unidadNegocio) {
        return personaRepository.findByUnidadNegocio(unidadNegocio);
    }

    @Override
    public Persona createPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona updatePersona(Persona persona, Integer id) {
        Optional<Persona> personaForUpdate = personaRepository.findById(id);
        if (!personaForUpdate.isPresent()){
            throw new BusinessException("ID de persona, invalido", HttpStatus.BAD_REQUEST);
        }
        personaForUpdate.get().setNombre(persona.getNombre());
        personaForUpdate.get().setUnidadNegocio(persona.getUnidadNegocio());
        personaForUpdate.get().setSupervisor(persona.getSupervisor());
        return personaRepository.save(personaForUpdate.get());
    }

    @Override
    public Persona deletePersona(Integer id) {
        Optional<Persona> persona = personaRepository.findById(id);
        if (!persona.isPresent()){
            throw new BusinessException("ID de persona, invalido", HttpStatus.BAD_REQUEST);
        }
        persona.get().setStatus(Boolean.FALSE);
        return personaRepository.save(persona.get());
    }
}
