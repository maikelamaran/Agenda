package com.agenda.contactos.repositorio;

import com.agenda.contactos.modelo.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactoRepositorio extends JpaRepository<Contacto, Integer>{
    @Query("SELECT c FROM Contacto c WHERE c.nombre LIKE %?1%")
    public List<Contacto> encontrarFiltrado(String param);


}
