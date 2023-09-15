package com.agenda.contactos.service;

import com.agenda.contactos.modelo.Contacto;

import com.agenda.contactos.repositorio.ContactoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoServiceImpl implements ContactoService {
    @Autowired
    ContactoRepositorio repositorio;

    @Override
    public List<Contacto> listarTodosLosContactos() {
        return repositorio.findAll();
    }

    @Override
    public Contacto guardarContactos(Contacto contacto) {
        return repositorio.save(contacto);
    }

    @Override
    public Contacto obtenerContactoPorId(Integer id) {
        return repositorio.findById(id).get();

    }

    @Override
    public Contacto actualizarContacto(Contacto contacto) {
        return repositorio.save(contacto);
    }

    @Override
    public void eliminarContacto(Integer id) {
        repositorio.deleteById(id);
    }

    @Override
    public void eliminarContatoPasandoContacto(Contacto contacto) {
        repositorio.delete(contacto);
    }

    @Override
    public List<Contacto> encontrarFiltrado(String param) {
        return repositorio.encontrarFiltrado(param);
    }






}
