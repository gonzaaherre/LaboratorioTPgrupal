package com.api.trabajoGrupalLABDEF.Services;

import com.api.trabajoGrupalLABDEF.Entidades.Noticia;
import com.api.trabajoGrupalLABDEF.Repositories.NoticiaRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Optional<Noticia> getNoticiaByid(Long id){
        return this.noticiaRepository.findById(id);
    }
    public Noticia updateNoticiaById(Noticia request, Long id){
        Noticia noticia = noticiaRepository.findById(id).get();
        noticia.setTitulo(request.getTitulo());
        noticia.setResumen(request.getResumen());
        noticia.setImagen(request.getImagen());
        noticia.setContenidoHtml(request.getContenidoHtml());
        noticia.setPublicada(request.isPublicada());
        noticia.setFechaPublicacion(request.getFechaPublicacion());
        noticia.setEmpresa(request.getEmpresa());
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
