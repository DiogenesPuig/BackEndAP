/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.controller;

import com.example.backend.dto.Message;
import com.example.backend.dto.SkillsDto;
import java.util.Date;
import java.util.List;
import com.example.backend.model.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend.service.ISkillsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hdppu
 */
@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "https://frontargprogrdp.web.app")
public class SkillsController {
 
    @Autowired
    private ISkillsServices stuInter;
    
    @GetMapping("/get")
    public List<Skills> getStudy(){
        return stuInter.getSkills();
    }
    
    @GetMapping("/get/{id}")
    public Skills getSkill(@PathVariable Long id){
        return stuInter.findSkills(id);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> createSkills(@RequestBody SkillsDto skdto){
        if(skdto.getNombre().isBlank()){
            return new ResponseEntity (new Message("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }else{
            Skills skill = new Skills(
            skdto.getNombre());
            stuInter.save(skill);
            return new ResponseEntity(new Message("Se creo exitosamente"), HttpStatus.OK);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSkills(@PathVariable Long id){
        stuInter.delete(id);
        return new ResponseEntity(new Message("Se elimino exitosamente"),HttpStatus.OK);
    }
    

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editSkills(@PathVariable Long id,
                                @RequestBody SkillsDto skdto){
        
        Skills perso = stuInter.findSkills(id);
        perso.setNombre(skdto.getNombre());
        
        stuInter.save(perso);
        
        return new ResponseEntity(new Message("habilidad actualizada"), HttpStatus.OK);
    }
}
