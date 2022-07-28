/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Date;
import java.util.List;
import model.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.IPerfilService;
/**
 *
 * @author hdppu
 */
@RestController
public class PerfilController {
    
    @Autowired
    private IPerfilService perInter;
    
    @GetMapping("/perfil/traer")
    public List<Perfil> getStudy(){
        return perInter.getStudies();
    }
    
    @PostMapping("/perfil/crear")
    public String createStudies(@RequestBody Perfil stu){
        perInter.save(stu);
        return "Se creo exitosamente";
    }
    
    @DeleteMapping("/perfil/eliminar/{id}")
    public String deleteStudy(@PathVariable Long id){
        perInter.delete(id);
        return "Se elimino exitosamente";
    }
    
    @PutMapping("/perfil/editar/{id}")
    public Perfil editPersona(@PathVariable Long id,
                                @RequestParam ("nombre") String nombreNuevo,
                                @RequestParam ("descripcion") String descrNuevo,
                                @RequestParam ("nacimiento") Date nuevoNacimiento,
                                @RequestParam ("mail") String nMail,
                                @RequestParam ("telefono") String nTel){
        
        Perfil perso = perInter.findStudies(id);
        
        perso.setNombre(nombreNuevo);
        perso.setDescripcion(descrNuevo);
        perso.setNacimiento(nuevoNacimiento);
        perso.setMail(nMail);
        perso.setTelefono(nTel);
        
        perInter.save(perso);
        
        return perso;
    }
}
