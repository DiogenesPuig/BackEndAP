/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import javax.transaction.Transactional;
import model.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SkillsRepository;

/**
 *
 * @author hdppu
 */
@Service
@Transactional
public class SkillsService implements ISkillsServices{
    
    @Autowired
    SkillsRepository skRepo;

    @Override
    public List<Skills> getSkills() {
        return skRepo.findAll();
    }

    @Override
    public void save(Skills stu) {
        skRepo.save(stu);
    }

    @Override
    public void delete(Long id) {
        skRepo.deleteById(id);
    }

    @Override
    public Skills findSkills(Long id) {
        Skills ns = skRepo.findById(id).orElse(null);
        return ns;
    }
}
