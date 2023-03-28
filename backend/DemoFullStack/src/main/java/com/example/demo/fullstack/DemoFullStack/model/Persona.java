package com.example.demo.fullstack.DemoFullStack.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    @JoinColumn(name = "supervisor", referencedColumnName = "id")
    @ManyToOne
    //@JsonManagedReference
    private Persona supervisor;
/*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subordinados", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Persona> subordinados;
*/
    @JoinColumn(name = "unidadNegocio", referencedColumnName = "id")
    @ManyToOne
    private UnidadNegocio unidadNegocio;

    private Boolean status;

    public UnidadNegocio getUnidadNegocio() {
        if (this.unidadNegocio != null)
            unidadNegocio.setGerente(null);
        return unidadNegocio;
    }
}
