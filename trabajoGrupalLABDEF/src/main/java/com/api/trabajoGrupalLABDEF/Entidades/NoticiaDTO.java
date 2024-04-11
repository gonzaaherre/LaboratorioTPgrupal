package com.api.trabajoGrupalLABDEF.Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoticiaDTO {
    private String titulo;
    private String resumen;
    private String imagen;
    private String contenidoHtml;
    private boolean publicada;
    private Date fechaPublicacion;
    private Long empresaId;
}
