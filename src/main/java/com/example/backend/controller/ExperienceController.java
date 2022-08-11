/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.controller;

import com.example.backend.dto.ExperienceDto;
import com.example.backend.dto.Message;
import java.util.List;
import com.example.backend.model.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend.service.IExperienceServices;
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
@RequestMapping("/experience")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienceController {
    
    @Autowired
    private IExperienceServices perInter;
    
    @GetMapping("/get")
    public List<Experience> getStudy(){
        return perInter.getExperiences();
    }
    
    @GetMapping("/get/{id}")
    public Experience getExperience(@PathVariable Long id){
        return perInter.findExperiences(id);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienceDto expdto){
        if(expdto.getNombre().isBlank()){
            return new ResponseEntity (new Message("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }else{
            Experience experience = new Experience(
                    expdto.getNombre(),expdto.getDescripcion()
            );
            
            perInter.save(experience);
            return new ResponseEntity ( new Message("Se creo exitosamente"),HttpStatus.OK);
        }
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteExperience(@PathVariable Long id){
        perInter.delete(id);
        return new ResponseEntity(new Message("Se elimino exitosamente"),HttpStatus.OK);
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editExperience(@PathVariable Long id,
                                @RequestBody ExperienceDto expdto){
        
        Experience perso = perInter.findExperiences(id);  
        perso.setNombre(expdto.getNombre());
        perso.setDescripcion(expdto.getDescripcion());
        
        perInter.save(perso);
        
        return new ResponseEntity(new Message("Experiencia actualizado"), HttpStatus.OK);
    }
}
