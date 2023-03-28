package com.example.demo.fullstack.DemoFullStack.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fecha;
    @JoinColumn(name = "reporta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persona reporta;
    @JoinColumn(name = "reportado", referencedColumnName = "id")
    @ManyToOne
    private Persona reportado;
    private String descripcion;
    private String status;
}
