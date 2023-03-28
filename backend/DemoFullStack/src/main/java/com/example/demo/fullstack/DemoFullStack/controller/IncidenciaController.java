package com.example.demo.fullstack.DemoFullStack.controller;

import com.example.demo.fullstack.DemoFullStack.model.Incidencia;
import com.example.demo.fullstack.DemoFullStack.model.UnidadNegocio;
import com.example.demo.fullstack.DemoFullStack.service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/incidencia")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    @GetMapping
    public ResponseEntity<List<Incidencia>> getAllIncidencia(){
        return ResponseEntity.ok(incidenciaService.getAllIncidencias());
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Incidencia>> getIncidenciasByStatus(@PathVariable String status){
        return ResponseEntity.ok(incidenciaService.findByStatus(status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incidencia> getById(@PathVariable Integer id){
        return ResponseEntity.ok(incidenciaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Incidencia> crearIncidencia(@RequestBody Incidencia incidencia){
        System.out.println("INCIDENCIA RECIBIDA => " + incidencia.toString());
        incidencia.setFecha(new Date());
        return ResponseEntity.ok(incidenciaService.createIncidencia(incidencia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Incidencia> editarIncidencia(@RequestBody Incidencia incidencia, @PathVariable Integer id){
        return ResponseEntity.ok(incidenciaService.updateIncidencia(incidencia, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Incidencia> eliminarIncidencia(@PathVariable Integer id){
        return ResponseEntity.ok(incidenciaService.deleteIncidencia(id));
    }
}
