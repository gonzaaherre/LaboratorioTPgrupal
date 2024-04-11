package com.api.trabajoGrupalLABDEF.Controllers;

import com.api.trabajoGrupalLABDEF.Entidades.Empresa;
import com.api.trabajoGrupalLABDEF.Entidades.Noticia;
import com.api.trabajoGrupalLABDEF.Entidades.NoticiaConEmpresaDTO;
import com.api.trabajoGrupalLABDEF.Entidades.NoticiaDTO;
import com.api.trabajoGrupalLABDEF.Services.NoticiaService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/noticias")
public class NoticiaController {
    @Autowired
    NoticiaService noticiaService;
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping
    public ArrayList<Noticia> getUsers(){
        return this.noticiaService.getNoticias();
    }


    //buscar noticia por resumen
    @GetMapping("/buscarPorResumen")
    public List<Noticia> buscarPorTitulo(@RequestParam String resumen) {
        return noticiaService.buscarPorResumen(resumen);
    }

    @PostMapping("/insertar")
    public ResponseEntity<String> insertarNoticiaConEmpresaId(@RequestParam  NoticiaDTO noticiaDTO, @PathVariable Long empresaId) {
        noticiaService.insertNoticiaWithEmpresaId(noticiaDTO.getTitulo(), noticiaDTO.getResumen(), noticiaDTO.getImagen(), noticiaDTO.getContenidoHtml(), noticiaDTO.isPublicada(), noticiaDTO.getFechaPublicacion(), empresaId);
        return ResponseEntity.ok("Noticia creada correctamente");
    }



    
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public Noticia saveNoticia(@RequestBody Noticia noticia){

        return this.noticiaService.SaveNoticias(noticia);
    }


    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/{id}")
    public NoticiaConEmpresaDTO obtenerNoticiaConEmpresa(@PathVariable Long id) {
        return noticiaService.obtenerNoticiaConEmpresa(id);
    }


    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PutMapping(path = "/{id}")
    public Noticia UpdateNoticia(@RequestBody Noticia request, @PathVariable("id")Long id){
        return this.noticiaService.updateNoticiaById(request,id);
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
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
