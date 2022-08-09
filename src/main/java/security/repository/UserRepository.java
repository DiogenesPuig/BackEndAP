/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package security.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import security.model.User;

/**
 *
 * @author hdppu
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByMail(String email);
    
}
