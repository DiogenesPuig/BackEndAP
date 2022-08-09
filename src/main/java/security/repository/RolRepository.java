/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package security.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import security.enums.RolName;
import security.model.Rol;
import security.model.User;

/**
 *
 * @author hdppu
 */
@Repository
public interface RolRepository extends JpaRepository<Rol,Long>{
    Optional<Rol> findByRolName(RolName rolName);
}
