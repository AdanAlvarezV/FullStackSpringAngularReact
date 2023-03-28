package com.example.demo.fullstack.DemoFullStack.repository;

import com.example.demo.fullstack.DemoFullStack.model.UnidadNegocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadNegocioRepository extends JpaRepository<UnidadNegocio, Integer> {

    List<UnidadNegocio> findByStatus(Boolean status);

    List<UnidadNegocio> findByUnidadPadre(UnidadNegocio unidadNegocio);

}
