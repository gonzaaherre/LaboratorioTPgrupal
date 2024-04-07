package com.api.trabajoGrupalLABDEF.Controllers;

import com.api.trabajoGrupalLABDEF.Entidades.Empresa;
import com.api.trabajoGrupalLABDEF.Entidades.Noticia;
import com.api.trabajoGrupalLABDEF.Services.NoticiaService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/noticias")
public class NoticiaController {
    @Autowired
    NoticiaService noticiaService;

    @GetMapping
    public ArrayList<Noticia> getUsers(){
        return this.noticiaService.getNoticias();
    }
    @PostMapping
    public Noticia saveNoticia(@RequestBody Noticia noticia){

        return this.noticiaService.SaveNoticias(noticia);
    }

    @GetMapping(path = "/{id}")
    public Optional<Noticia> getNoticiaByID(@PathVariable Long id){

        return this.noticiaService.getNoticiaByid(id);
    }

    @PutMapping(path = "/{id}")
    public Noticia UpdateNoticia(@RequestBody Noticia request, @PathVariable("id")Long id){
        return this.noticiaService.updateNoticiaById(request,id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteNoticiaById(@PathVariable("id")Long id){
        boolean ok = this.noticiaService.deleteNoticia(id);

        if (ok){
            return "noticia con id "+ id +" eliminado";
        }else {
            return "error no se pudo eliminar la noticia con id: "+ id;
        }
    }

}
