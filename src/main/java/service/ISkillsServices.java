/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Skills;

/**
 *
 * @author hdppu
 */
public interface ISkillsServices {
    
    public List<Skills> getSkills();
 
    public void save(Skills stu);

    public void delete(Long id);

    public Skills findSkills(Long id);
    
}
