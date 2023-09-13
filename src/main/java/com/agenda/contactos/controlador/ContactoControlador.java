package com.agenda.contactos.controlador;

import com.agenda.contactos.modelo.Contacto;
import com.agenda.contactos.repositorio.ContactoRepositorio;
import com.agenda.contactos.service.ContactoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class ContactoControlador {

    @Autowired
    private ContactoService servicio;

    @GetMapping({"/", ""})
    public String verPaginaDeInicio(Model modelo) {
        List<Contacto> contactos = servicio.listarTodosLosContactos();
        modelo.addAttribute("contactos", contactos);
        return "index";
    }

    @GetMapping({"/nuevo"})
    public String mostrarFormularioRegistroContacto(Model modelo) {
        modelo.addAttribute("contacto", new Contacto());
        return "nuevo";
    }

    @PostMapping({"/nuevo"})
    //@Validated para que sepas que vamos a validar el objeto contacto
    //BindingResult tiene que estar al lado del objeto que vamos a validar
    public String guardarContacto(@Validated Contacto contacto, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
        if (bindingResult.hasErrors()) {
            modelo.addAttribute("contacto", contacto);
            return "nuevo";
        }

        servicio.guardarContactos(contacto);
        redirect.addFlashAttribute("mesgexito", "El contacto se agrego con éxito");
        return "redirect:/";
    }

    @GetMapping({"/{Id}/editar/"})
    public String mostrarFormulariodeEditarContacto(@PathVariable Integer Id, Model modelo) {
        Contacto contacto = servicio.obtenerContactoPorId(Id);
        modelo.addAttribute("contacto", contacto);
        return "nuevo";
    }


    @PostMapping({"/{Id}/editar/"})
    //@Validated para que sepas que vamos a validar el objeto contacto
    //BindingResult tiene que estar al lado del objeto que vamos a validar
    public String actualizarContacto(@PathVariable Integer Id, @Validated Contacto contacto, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
        Contacto contactoDB = servicio.obtenerContactoPorId(Id);
        if (bindingResult.hasErrors()) {
            modelo.addAttribute("contacto", contacto);
            return "nuevo";
        }
        contactoDB.setNombre(contacto.getNombre());
        contactoDB.setDebe(contacto.getDebe());
        contactoDB.setEmail(contacto.getEmail());
        contactoDB.setDueno(contacto.getDueno());
        contactoDB.setCelular(contacto.getCelular());
        contactoDB.setProducto(contacto.getProducto());
        contactoDB.setRevender(contacto.getRevender());
        contactoDB.setFechaPago(contacto.getFechaPago());
        contactoDB.setFechaVenta(contacto.getFechaVenta());

        servicio.guardarContactos(contacto);
        redirect.addFlashAttribute("mesgexito", "El contacto se actualizó correctamente");
        return "redirect:/";
    }

    //    @GetMapping({"/{Id}/eliminar/"})
//    public String eliminarContacto(@PathVariable Integer Id, RedirectAttributes redirect)
//    {
//
//        servicio.eliminarContacto(Id);
//        redirect.addFlashAttribute("mesgexito", "El contacto saldó la deuda, ha sido eliminado");
//        return "redirect:/";
//    }
    @PostMapping({"/{Id}/eliminar/"})
    public String eliminarContacto(@PathVariable Integer Id, RedirectAttributes redirect) {
        Contacto contacto = servicio.obtenerContactoPorId(Id);
        servicio.eliminarContatoPasandoContacto(contacto);

        redirect.addFlashAttribute("mesgexito", "El contacto saldó la deuda, se eliminó");
        return "redirect:/";
    }

}

