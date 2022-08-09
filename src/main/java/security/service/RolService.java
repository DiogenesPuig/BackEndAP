/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package security.service;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import security.enums.RolName;
import security.model.Rol;
import security.repository.RolRepository;

/**
 *
 * @author hdppu
 */
@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository rolRepo;
    
    public Optional<Rol> getByRolName(RolName rolname){
        return rolRepo.findByRolName(rolname);
    }
}
