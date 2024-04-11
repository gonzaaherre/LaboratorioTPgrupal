package com.api.trabajoGrupalLABDEF.Services;

import com.api.trabajoGrupalLABDEF.Entidades.Noticia;
import com.api.trabajoGrupalLABDEF.Entidades.NoticiaConEmpresaDTO;
import com.api.trabajoGrupalLABDEF.Repositories.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService {
    @Autowired
    NoticiaRepository noticiaRepository;

    public ArrayList<Noticia> getNoticias(){
        return (ArrayList<Noticia>) noticiaRepository.findAll();
    }
    public Noticia SaveNoticias(Noticia noticia){
        return this.noticiaRepository.save(noticia);
    }

    //busca por titulo
    public List<Noticia> buscarPorResumen(String resumen) {
        return noticiaRepository.findByResumen(resumen);
    }

    //insertar noticia con idempresa
    public void insertNoticiaWithEmpresaId(String titulo, String resumen, String imagen, String contenidoHtml, boolean publicada, Date fechaPublicacion, Long empresaId) {
        noticiaRepository.insertNoticiaWithEmpresaId(titulo, resumen, imagen, contenidoHtml, publicada, fechaPublicacion, empresaId);
    }

    public NoticiaConEmpresaDTO obtenerNoticiaConEmpresa(Long noticiaId) {
        Optional<Object[]> result = noticiaRepository.findNoticiaWithEmpresaId(noticiaId);

        if (result.isPresent()) {
            Object[] objects = result.get();
            Noticia noticia = (Noticia) objects[0]; // La noticia está en la posición 0 del array
            Long idEmpresa = (Long) objects[1]; // El ID de la empresa está en la posición 1 del array
            return new NoticiaConEmpresaDTO(noticia, idEmpresa);
        } else {
            return null;
        }
    }
    public Noticia updateNoticiaById(Noticia request, Long id){
        Noticia noticia = noticiaRepository.findById(id).get();
        noticia.setTitulo(request.getTitulo());
        noticia.setResumen(request.getResumen());
        noticia.setImagen(request.getImagen());
        noticia.setContenidoHtml(request.getContenidoHtml());
        noticia.setPublicada(request.isPublicada());
        noticia.setFechaPublicacion(request.getFechaPublicacion());
        return noticia;
    }

    public Boolean deleteNoticia(Long id){
        try {
            noticiaRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
