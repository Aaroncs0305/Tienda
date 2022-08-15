package com.Tienda.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="rol")

public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idRol;
    String nombre;
    
    public Rol() {
    }
    
    public Rol(String nombre) {
        this.nombre = nombre;
    }  
}
