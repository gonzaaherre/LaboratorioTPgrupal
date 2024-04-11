package com.api.trabajoGrupalLABDEF.Services;

import com.api.trabajoGrupalLABDEF.Entidades.Empresa;
import com.api.trabajoGrupalLABDEF.Entidades.Noticia;
import com.api.trabajoGrupalLABDEF.Repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;

    public ArrayList<Empresa> getEmpresas(){
        return (ArrayList<Empresa>) empresaRepository.findAll();
    }

    public List<Noticia> obtenerNoticiasPorEmpresaId(Long empresaId) {
        return empresaRepository.findByNoticias_Empresa_Id(empresaId);
    }

    public Empresa SaveEmpresas(Empresa empresa){
        return this.empresaRepository.save(empresa);
    }

    public Optional<Empresa> getById(Long id){
        return empresaRepository.findById(id);
    }

    public Empresa updateById(Empresa request, Long id){
        Empresa empresa = empresaRepository.findById(id).get();
        empresa.setDenominacion(request.getDenominacion());
        empresa.setTelefono(request.getTelefono());
        empresa.setHorarioAtencion(request.getHorarioAtencion());
        empresa.setQuienesSomos(request.getQuienesSomos());
        empresa.setLatitud(request.getLatitud());
        empresa.setLongitud(request.getLongitud());
        empresa.setDomicilio(request.getDomicilio());
        empresa.setEmail(request.getEmail());
        return empresa;
    }

    public Boolean deleteEmpresa(Long id){
        try {
            empresaRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
