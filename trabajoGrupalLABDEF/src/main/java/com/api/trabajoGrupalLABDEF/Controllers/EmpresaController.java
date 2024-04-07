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

    @GetMapping
    public ArrayList<Empresa> getUsers(){
        return this.empresaService.getEmpresas();
    }

    @PostMapping
    public Empresa saveEmpresa(@RequestBody Empresa empresa){
        return this.empresaService.SaveEmpresas(empresa);
    }

    @GetMapping(path = "/{id}")
    public Optional<Empresa> getEmpresaByID(@PathVariable Long id){
        return this.empresaService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Empresa UpdateUser(@RequestBody Empresa request,@PathVariable("id")Long id){
        return this.empresaService.updateById(request,id);
    }

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
