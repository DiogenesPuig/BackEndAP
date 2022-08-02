/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.service;

import java.util.List;
import com.example.backend.model.Studies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend.repository.StudiesRepository;

/**
 *
 * @author hdppu
 */
@Service
public class StudiesService implements IStudiesServices {
    
    @Autowired
    private StudiesRepository studyRepo;
    
    @Override
    public List<Studies> getStudies(){
         return studyRepo.findAll();
     }
    
    @Override
    public void save(Studies stu){
        studyRepo.save(stu);
    }
    
    @Override
    public void delete(Long id) {
        studyRepo.deleteById(id);
    }
    

    @Override
    public Studies findStudies(Long id) {
        Studies stu = studyRepo.findById(id).orElse(null);
        return stu;
    }


}
