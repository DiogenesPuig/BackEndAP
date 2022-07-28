/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Experience;


/**
 *
 * @author hdppu
 */
public interface IExperienceServices {
    
    public List<Experience> getExperiences();
 
    public void save(Experience stu);

    public void delete(Long id);

    public Experience findExperiences(Long id);
    
}

