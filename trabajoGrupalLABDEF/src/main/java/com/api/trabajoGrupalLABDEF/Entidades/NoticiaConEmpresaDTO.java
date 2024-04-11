package com.api.trabajoGrupalLABDEF.Entidades;

public class NoticiaConEmpresaDTO {
    private Noticia noticia;
    private Long idEmpresa;

    public NoticiaConEmpresaDTO(Noticia noticia, Long idEmpresa) {
        this.noticia = noticia;
        this.idEmpresa = idEmpresa;
    }
}
