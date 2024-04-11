package com.api.trabajoGrupalLABDEF.Repositories;

import com.api.trabajoGrupalLABDEF.Entidades.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    @Query("SELECT n, n.empresa.id FROM Noticia n JOIN n.empresa WHERE n.id = :noticiaId")
    Optional<Object[]> findNoticiaWithEmpresaId(Long noticiaId);
}
//findByIdWithEmpresa