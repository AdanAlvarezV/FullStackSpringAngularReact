package com.example.demo.fullstack.DemoFullStack.controller;

import com.example.demo.fullstack.DemoFullStack.common.util.ErrorMessagesUtil;
import com.example.demo.fullstack.DemoFullStack.model.UnidadNegocio;
import com.example.demo.fullstack.DemoFullStack.service.UnidadNegocioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/unidadnegocio")
public class UnidadNegocioController {

    @Autowired
    private UnidadNegocioService unidadNegocioService;

    @GetMapping
    public ResponseEntity<List<UnidadNegocio>> getAllUnidadNegocio(){
        return ResponseEntity.ok(unidadNegocioService.getAllUnidades());
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<UnidadNegocio>> getAllUnidadNegocio(@PathVariable Boolean status){
        return ResponseEntity.ok(unidadNegocioService.findByStatus(status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadNegocio> getById(@PathVariable Integer id){
        return ResponseEntity.ok(unidadNegocioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UnidadNegocio> crearUnidad(@Valid @RequestBody UnidadNegocio unidadNegocio, BindingResult result){
        System.out.println("UNIDAD RECIBIDA => " + unidadNegocio.toString());
        if (result.hasErrors()){
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessagesUtil.formatMEssageError(result));
            //return ResponseEntity.badRequest().body(ErrorMessagesUtil.validar(result));
            return (ResponseEntity<UnidadNegocio>) ErrorMessagesUtil.validar(result);
        }
        return ResponseEntity.ok(unidadNegocioService.createUnidadNegocio(unidadNegocio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadNegocio> editarUnidad(@RequestBody UnidadNegocio unidadNegocio, @PathVariable Integer id, BindingResult result){
        System.out.println("UNIDAD RECIBIDA => " + unidadNegocio.toString());
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessagesUtil.formatMEssageError(result));
        }
        return ResponseEntity.ok(unidadNegocioService.updateUnidadNegocio(unidadNegocio, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UnidadNegocio> eliminarUnidad(@PathVariable Integer id){
        return ResponseEntity.ok(unidadNegocioService.deleteUnidadNegocio(id));
    }
}
