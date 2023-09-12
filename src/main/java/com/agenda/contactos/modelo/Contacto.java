package com.agenda.contactos.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity

@NoArgsConstructor
@AllArgsConstructor
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @NotEmpty(message = "Debe ingresar un nombre")
    private String nombre;
    @Email
    private String email;

   // @Size(min = 8,max = 8,message = "celular debe tener 8 digitos")
    //@NotBlank(message = "8 dígitos")

    @NotNull(message = "Debes ingresar un celular,son 8 dígitos.")
    @Min(value = 50000000)
    @Max(value=59999999)
    private Integer celular;
    @NotEmpty(message = "Debe ingresar un producto")
    private String producto;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Debe ingresar su fecha de venta")
    private LocalDate fechaVenta;
    @NotNull(message = "Debes especificar el precio")
    @Min(value = 1, message = "El precio mínimo es 1")
    private Float debe;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future
    @NotNull(message = "Debe ingresar su fecha de pago")
    private LocalDate fechaPago;

    @NotEmpty(message = "Debe ingresar un Dueño")
    private String dueno;
    private String revender;

    @PrePersist
    public void asignarFechaVentaFechaPAgo() {
//        fechaVenta = LocalDate.now();
//        fechaPago = fechaVenta.plusDays(30);
        //revender = "no";
        //dueno = "carucha";
        //email = "--NO LO DIO--";
    }

//    @PrePersist
//    public void asignarFechaPago() {
//        LocalDateTime today = LocalDateTime.now();     //Today
//        //LocalDateTime tomorrow = today.plusDays(1);     //Plus 1 day
//        //LocalDateTime yesterday = today.minusDays(1);   //Minus 1 day
//        fechaPago = today.plusDays(30);
//    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Float getDebe() {
        return debe;
    }

    public void setDebe(Float debe) {
        this.debe = debe;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public String getRevender() {
        return revender;
    }

    public void setRevender(String revender) {
        this.revender = revender;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
