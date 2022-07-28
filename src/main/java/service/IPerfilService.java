/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;
import java.util.List;
import model.Perfil;

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
