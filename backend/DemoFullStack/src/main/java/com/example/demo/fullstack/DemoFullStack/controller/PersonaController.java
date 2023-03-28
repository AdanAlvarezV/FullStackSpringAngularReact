package com.example.demo.fullstack.DemoFullStack.controller;

import com.example.demo.fullstack.DemoFullStack.model.Persona;
import com.example.demo.fullstack.DemoFullStack.model.UnidadNegocio;
import com.example.demo.fullstack.DemoFullStack.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersona(){
        return ResponseEntity.ok(personaService.getAllPersona());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getById(@PathVariable Integer id){
        return ResponseEntity.ok(personaService.findById(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Persona>> getAllPersona(@PathVariable Boolean status){
        return ResponseEntity.ok(personaService.findByStatus(status));
    }

    @GetMapping("/active")
    public ResponseEntity<List<Persona>> getAllPersonaActivas(){
        return ResponseEntity.ok(personaService.findByStatus(Boolean.TRUE));
    }

    @PostMapping
    public ResponseEntity<Persona> crearUnidad(@RequestBody Persona persona){
        return ResponseEntity.ok(personaService.createPersona(persona));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> editarUnidad(@RequestBody Persona persona, @PathVariable Integer id){
        return ResponseEntity.ok(personaService.updatePersona(persona, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Persona> eliminarUnidad(@PathVariable Integer id){
        return ResponseEntity.ok(personaService.deletePersona(id));
    }
}
