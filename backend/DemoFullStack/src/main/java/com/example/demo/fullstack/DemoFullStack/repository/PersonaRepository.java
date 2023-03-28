package com.example.demo.fullstack.DemoFullStack.repository;

import com.example.demo.fullstack.DemoFullStack.model.Persona;
import com.example.demo.fullstack.DemoFullStack.model.UnidadNegocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    List<Persona> findByStatus(Boolean status);

    List<Persona> findBySupervisor(Persona supervisor);

    List<Persona> findByUnidadNegocio(UnidadNegocio unidadNegocio);
}
