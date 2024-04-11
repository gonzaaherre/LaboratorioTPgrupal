package com.api.trabajoGrupalLABDEF.Repositories;

import com.api.trabajoGrupalLABDEF.Entidades.Noticia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    @Query("SELECT n, n.empresa.id FROM Noticia n JOIN n.empresa WHERE n.id = :noticiaId")
    Optional<Object[]> findNoticiaWithEmpresaId(Long noticiaId);

    @Query("SELECT n FROM Noticia n JOIN FETCH n.empresa WHERE n.id = :noticiaId")
    Optional<Noticia> findNoticiaWithEmpresa(Long noticiaId);

    @Query("SELECT n FROM Noticia n WHERE n.empresa.id = :empresaId")
    List<Noticia> findByNoticias_Empresa_Id(Long empresaId);

    @Query("SELECT n FROM Noticia n WHERE LOWER(n.resumen) LIKE %:resumen%")
    List<Noticia> findByResumen(String resumen);

    @PersistenceContext
    EntityManager entityManager = null;

    @Transactional
    public default void insertNoticiaWithEmpresaId(String titulo, String resumen, String imagen, String contenidoHtml, boolean publicada, Date fechaPublicacion, Long empresaId) {
        String query = "INSERT INTO noticia (titulo, resumen, imagen, contenido_html, publicada, fecha_publicacion, empresa_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        Query nativeQuery = (Query) entityManager.createNativeQuery(query);
        ((jakarta.persistence.Query) nativeQuery).setParameter(1, titulo);
        ((jakarta.persistence.Query) nativeQuery).setParameter(2, resumen);
        ((jakarta.persistence.Query) nativeQuery).setParameter(3, imagen);
        ((jakarta.persistence.Query) nativeQuery).setParameter(4, contenidoHtml);
        ((jakarta.persistence.Query) nativeQuery).setParameter(5, publicada);
        ((jakarta.persistence.Query) nativeQuery).setParameter(6, fechaPublicacion);
        ((jakarta.persistence.Query) nativeQuery).setParameter(7, empresaId);
        ((jakarta.persistence.Query) nativeQuery).executeUpdate();
    }
}

//findByIdWithEmpresa