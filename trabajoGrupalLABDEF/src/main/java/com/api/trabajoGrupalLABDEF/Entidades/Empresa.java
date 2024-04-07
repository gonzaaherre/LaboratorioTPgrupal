package com.api.trabajoGrupalLABDEF.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToOne(mappedBy = "empresa", cascade = CascadeType.ALL)
    private Noticia noticia;

}
