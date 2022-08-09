/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package security.service;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import security.model.User;
import security.repository.UserRepository;

/**
 *
 * @author hdppu
 */
@Service
@Transactional
public class UserService {
    
    @Autowired
    UserRepository userRepo;
    
    public Optional<User> getByUserName(String userName){
        return userRepo.findByUserName(userName);
    }
    
    public boolean existsByUserName(String userName){
        return userRepo.existsByUserName(userName);
    }
    
     public boolean existsByEmail(String email){
        return userRepo.existsByMail(email);
    }
    
     public void save(User user){
         userRepo.save(user);
     }
             
}
