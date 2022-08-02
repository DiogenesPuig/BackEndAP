/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.backend.service;
import java.util.List;
import com.example.backend.model.Perfil;

/**
 *
 * @author hdppu
 */
public interface IPerfilService {
    
    public List<Perfil> getStudies();
 
    public void save(Perfil stu);

    public void delete(Long id);

    public Perfil findStudies(Long id);
    
}
