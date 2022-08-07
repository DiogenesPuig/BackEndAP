/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.controller;


import com.example.backend.dto.Message;
import com.example.backend.dto.StudiesDto;
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
    public List<Studies> getStudies(){
        return stuInter.getStudies();
    }
    
    @GetMapping("/get/{id}")
    public Studies getStudy(@PathVariable Long id){
        return stuInter.findStudies(id);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> createStudy(@RequestBody StudiesDto studto){
        if(studto.getNombre().isBlank()){
            return new ResponseEntity (new Message("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }else{
            Studies studies = new Studies(studto.getNombre(),studto.getDescripcion(),studto.getInicio(),studto.getFin());
            stuInter.save(studies);
            return new ResponseEntity (new Message("Se creo exitosamente"),HttpStatus.OK);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudy(@PathVariable Long id){
        stuInter.delete(id);
        return new ResponseEntity(new Message("Se elimino exitosamente"),HttpStatus.OK);
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editStudies(@PathVariable Long id,@RequestBody StudiesDto studto){
        
         
        Studies perso = stuInter.findStudies(id);
        perso.setNombre(studto.getNombre());
        perso.setDescripcion(studto.getDescripcion());
        perso.setInicio(studto.getInicio());
        perso.setFin(studto.getFin());
        
        stuInter.save(perso);
        
        return new ResponseEntity(new Message("Estudio actualizado"), HttpStatus.OK);
    }
    
}
