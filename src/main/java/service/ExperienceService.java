/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import javax.transaction.Transactional;
import model.Experience;
import model.Studies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ExperienceRepository;

/**
 *
 * @author hdppu
 */
@Service
@Transactional
public class ExperienceService implements IExperienceServices {
    
    @Autowired
    ExperienceRepository exRepo;

    @Override
    public List<Experience> getExperiences() {
        return exRepo.findAll();
    }

    @Override
    public void save(Experience stu) {
        exRepo.save(stu);
    }

    @Override
    public void delete(Long id) {
        exRepo.deleteById(id);
    }

    @Override
    public Experience findExperiences(Long id) {
        Experience nExp = exRepo.findById(id).orElse(null);
        return nExp;
    }


}
