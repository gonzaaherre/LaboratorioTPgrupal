package com.api.trabajoGrupalLABDEF.Repositories;

import com.api.trabajoGrupalLABDEF.Entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
}
