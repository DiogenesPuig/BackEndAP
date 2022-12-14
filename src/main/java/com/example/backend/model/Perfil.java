/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.model;

/**
 *
 * @author hdppu
 */


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Perfil {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String descripcion;
    private Date nacimiento;
    private String mail;
    private String telefono;

    public Perfil(String nombre, String descripcion, Date nacimiento, String mail, String telefono) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nacimiento = nacimiento;
        this.mail = mail;
        this.telefono = telefono;
    }

    public Perfil() {
    }
    
    
    
}
