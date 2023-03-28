package com.example.demo.fullstack.DemoFullStack.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UnidadNegocio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Nombre unidad de negocio no puede ser nulo")
    @NotBlank(message = "Nombre unidad de negocio no puede estar vacio")
    private String nombre;

    @JoinColumn(name = "unidadPadre", referencedColumnName = "id")
    @ManyToOne
    //@NotNull(message = "Unidad de negocio padre no puede ser nulo")
    //@JsonManagedReference
    private UnidadNegocio unidadPadre;
/*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadPadre", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<UnidadNegocio> hijas;
*/
    @JoinColumn(name = "gerente", referencedColumnName = "id")
    @ManyToOne
    private Persona gerente;

    private Boolean status;

    public Persona getGerente() {
        if (this.gerente != null)
            gerente.setUnidadNegocio(null);
        return gerente;
    }
}
