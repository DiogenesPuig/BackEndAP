/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.controller;


import java.util.Date;
import java.util.List;
import com.example.backend.model.Studies;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend.service.IStudiesServices;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hdppu
 */
@RestController
@RequestMapping("/studies")
@CrossOrigin(origins = "http://localhost:4200")
public class StudiesController {
    
    @Autowired
    private IStudiesServices stuInter;
    
    @GetMapping("/get")
    public List<Studies> getStudy(){
        return stuInter.getStudies();
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> createStudies(@RequestBody Studies stu){
        if(stu.getNombre().isBlank()){
            return new ResponseEntity (("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }else{
            stuInter.save(stu);
            return new ResponseEntity ("Se creo exitosamente",HttpStatus.OK);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteStudy(@PathVariable Long id){
        stuInter.delete(id);
        return "Se elimino exitosamente";
    }
    
    @PutMapping("/edit/{id}")
    public Studies editPersona(@PathVariable Long id,
                                @RequestParam ("nombre") String nombreNuevo,
                                @RequestParam ("descripcion") String descrNuevo,
                                @RequestParam ("inicio") Date iniNueva,
                                @RequestParam ("fin") Date finNueva){
        
        Studies perso = stuInter.findStudies(id);
        
        perso.setNombre(nombreNuevo);
        perso.setDescripcion(descrNuevo);
        perso.setInicio(iniNueva);
        perso.setFin(finNueva);
        
        stuInter.save(perso);
        
        return perso;
    }
    
}
