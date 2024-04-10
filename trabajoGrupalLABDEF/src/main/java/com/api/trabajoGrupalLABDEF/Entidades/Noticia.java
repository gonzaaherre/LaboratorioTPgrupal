package com.api.trabajoGrupalLABDEF.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="noticia")
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String resumen;
    private String imagen;
    private String contenidoHtml;
    private boolean publicada;
    private Date fechaPublicacion;
    @ManyToOne()
    @JoinColumn(name = "Empresa_id")
    @JsonIgnore
    private Empresa empresa;



}
