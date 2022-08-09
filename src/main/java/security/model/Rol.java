/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package security.model;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import security.enums.RolName;

/**
 *
 * @author hdppu
 */
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolName rolNombre;

    public Rol() {
    }

    public Rol(@NotNull RolName rolNombre) {
        this.rolNombre = rolNombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolName getRolName() {
        return rolNombre;
    }

    public void setRolNombre(RolName rolNombre) {
        this.rolNombre = rolNombre;
    }
}
