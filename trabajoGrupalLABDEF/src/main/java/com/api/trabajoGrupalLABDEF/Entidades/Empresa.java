package com.api.trabajoGrupalLABDEF.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denominacion;
    private String telefono;
    private String horarioAtencion;
    private String quienesSomos;
    private double latitud;
    private double longitud;
    private String domicilio;
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Empresa_id")
    private List<Noticia> noticias = new ArrayList<>();

}
