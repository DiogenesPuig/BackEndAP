/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.repository;

import java.util.Optional;
import com.example.backend.model.Studies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hdppu
 */
@Repository

public interface StudiesRepository extends JpaRepository<Studies,Long>{
    
}
