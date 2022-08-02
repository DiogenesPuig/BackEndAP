/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.controller;

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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hdppu
 */
@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillsController {
 
    @Autowired
    private ISkillsServices stuInter;
    
    @GetMapping("/get")
    public List<Skills> getStudy(){
        return stuInter.getSkills();
    }
    
    @PostMapping("/create")
    public String createStudies(@RequestBody Skills stu){
        stuInter.save(stu);
        return "Se creo exitosamente";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteStudy(@PathVariable Long id){
        stuInter.delete(id);
        return "Se elimino exitosamente";
    }
    
    @PutMapping("/edit/{id}")
    public Skills editPersona(@PathVariable Long id,
                                @RequestParam ("nombre") String nombreNuevo){
        
        Skills perso = stuInter.findSkills(id);
        
        perso.setNombre(nombreNuevo);

        
        stuInter.save(perso);
        
        return perso;
    }
}
