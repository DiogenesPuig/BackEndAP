/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.controller;

import com.example.backend.dto.Message;
import com.example.backend.dto.PerfilDto;
import java.util.Date;
import java.util.List;
import com.example.backend.model.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend.service.IPerfilService;
import com.example.backend.service.PerfilService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author hdppu
 */
@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "http://localhost:4200")
public class PerfilController {
    
    @Autowired
    private IPerfilService perInter;
    
    @GetMapping("/get")
    public List<Perfil> getProfiles(){
        return perInter.getProfile();
    }
    
    @GetMapping("/get/{id}")
    public Perfil getProfile(@PathVariable Long id){
        return perInter.findProfile(id);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> createPerfil(@RequestBody PerfilDto studto){
        Perfil perfil = new Perfil(
        studto.getNombre(),studto.getDescripcion(),studto.getNacimiento(),studto.getMail(),studto.getTelefono());
        perInter.save(perfil);
        return new ResponseEntity(new Message("Se creo exitosamente"),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePerfil(@PathVariable Long id){
        perInter.delete(id);
        return new ResponseEntity(new Message("Se elimino exitosamente"),HttpStatus.OK);
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editPerfil(@PathVariable Long id,
                                @RequestBody PerfilDto perdto){
        
        Perfil perso = perInter.findProfile(id);
        
        perso.setNombre(perdto.getNombre());
        perso.setDescripcion(perdto.getDescripcion());
        perso.setNacimiento(perdto.getNacimiento());
        perso.setMail(perdto.getMail());
        perso.setTelefono(perdto.getTelefono());
        
        perInter.save(perso);
        
       return new ResponseEntity(new Message("Perfil actualizado"), HttpStatus.OK);
    }
}
