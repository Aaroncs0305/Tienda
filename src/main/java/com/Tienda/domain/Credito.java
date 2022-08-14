package com.Tienda.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="credito")

public class Credito implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Credito") // perimite asignar el nombre del long al de la tabla, en lugar de hibernate
    
    private Long idCredito;
    private double limite;
    
    public Credito(){   
    }

    public Credito(double limite) {
        this.limite = limite;
    } 
}
