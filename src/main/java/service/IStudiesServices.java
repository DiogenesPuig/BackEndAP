/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Studies;

/**
 *
 * @author hdppu
 */
public interface IStudiesServices {
    
    public List<Studies> getStudies();
 
    public void save(Studies stu);

    public void delete(Long id);

    public Studies findStudies(Long id);
    
}
