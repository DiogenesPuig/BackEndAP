/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Date;
import java.util.List;
import model.Studies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.IStudiesServices;

/**
 *
 * @author hdppu
 */
@RestController
public class StudiesController {
    
    @Autowired
    private IStudiesServices stuInter;
    
    @GetMapping("/studies/traer")
    public List<Studies> getStudy(){
        return stuInter.getStudies();
    }
    
    @PostMapping("/studies/crear")
    public String createStudies(@RequestBody Studies stu){
        stuInter.save(stu);
        return "Se creo exitosamente";
    }
    
    @DeleteMapping("/studies/eliminar/{id}")
    public String deleteStudy(@PathVariable Long id){
        stuInter.delete(id);
        return "Se elimino exitosamente";
    }
    
    @PutMapping("/studies/editar/{id}")
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
