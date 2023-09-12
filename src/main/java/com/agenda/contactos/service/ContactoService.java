package com.agenda.contactos.service;

import com.agenda.contactos.modelo.Contacto;


import java.util.List;


public interface ContactoService {
    public List<Contacto> listarTodosLosContactos();
    public Contacto guardarContactos(Contacto contacto);
    public Contacto obtenerContactoPorId(Integer id);
    public Contacto actualizarContacto(Contacto estudiante);
    public void eliminarContacto(Integer id);
    public void eliminarContatoPasandoContacto(Contacto contacto);

}
