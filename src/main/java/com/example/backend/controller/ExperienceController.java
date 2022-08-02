/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.controller;

import java.util.List;
import com.example.backend.model.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend.service.IExperienceServices;
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
    
    @PostMapping("/create")
    public String createStudies(@RequestBody Experience stu){
        perInter.save(stu);
        return "Se creo exitosamente";
    }
    
    @DeleteMapping("delete/{id}")
    public String deleteStudy(@PathVariable Long id){
        perInter.delete(id);
        return "Se elimino exitosamente";
    }
    
    @PutMapping("/edit/{id}")
    public Experience editPersona(@PathVariable Long id,
                                @RequestParam ("nombre") String nombreNuevo,
                                @RequestParam ("descripcion") String descrNuevo){
        
        Experience perso = perInter.findExperiences(id);
        
        perso.setNombre(nombreNuevo);
        perso.setDescripcion(descrNuevo);
        
        perInter.save(perso);
        
        return perso;
    }
}
