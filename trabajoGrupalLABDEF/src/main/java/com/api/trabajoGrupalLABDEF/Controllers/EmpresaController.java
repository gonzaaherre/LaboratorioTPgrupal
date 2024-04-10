package com.api.trabajoGrupalLABDEF.Controllers;

import com.api.trabajoGrupalLABDEF.Entidades.Empresa;
import com.api.trabajoGrupalLABDEF.Services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping
    public ArrayList<Empresa> getUsers(){
        return this.empresaService.getEmpresas();
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public Empresa saveEmpresa(@RequestBody Empresa empresa){
        return this.empresaService.SaveEmpresas(empresa);
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/{id}")
    public Optional<Empresa> getEmpresaByID(@PathVariable Long id){
        return this.empresaService.getById(id);
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PutMapping(path = "/{id}")
    public Empresa UpdateUser(@RequestBody Empresa request,@PathVariable("id")Long id){
        return this.empresaService.updateById(request,id);
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id")Long id){
        boolean ok = this.empresaService.deleteEmpresa(id);

        if (ok){
            return "empresa con id "+ id +" eliminado";
        }else {
            return "error no se pudo eliminar la empresa con id: "+ id;
        }
    }

}
