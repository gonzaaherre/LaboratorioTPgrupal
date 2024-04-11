package com.api.trabajoGrupalLABDEF.Repositories;

import com.api.trabajoGrupalLABDEF.Entidades.Empresa;
import com.api.trabajoGrupalLABDEF.Entidades.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
    @Query("SELECT n FROM Noticia n WHERE n.empresa.id = :empresaId")
    List<Noticia> findByNoticias_Empresa_Id(Long empresaId);
}
