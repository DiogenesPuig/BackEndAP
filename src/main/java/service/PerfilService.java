/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import javax.transaction.Transactional;
import model.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PerfilRepository;

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
    public List<Perfil> getStudies() {
        return peRepo.findAll();
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
    public Perfil findStudies(Long id) {
        Perfil per = peRepo.findById(id).orElse(null);
        return per;
    }
    
    
}
