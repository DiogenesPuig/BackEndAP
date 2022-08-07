/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.service;

import java.util.List;
import javax.transaction.Transactional;
import com.example.backend.model.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend.repository.PerfilRepository;

/**
 *
 * @author hdppu
 */
@Service
@Transactional
public class PerfilService implements IPerfilService {
    
    @Autowired
    PerfilRepository peRepo;

    @Override
    public List<Perfil> getProfile() {
        List<Perfil> allProf = peRepo.findAll();
        return allProf ;
    }

    @Override
    public void save(Perfil stu) {
        peRepo.save(stu);
    }

    @Override
    public void delete(Long id) {
        peRepo.deleteById(id);
    }

    @Override
    public Perfil findProfile(Long id) {
        Perfil per = peRepo.findById(id).orElse(null);
        return per;
    }
    
    
}
