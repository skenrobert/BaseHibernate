package com.springsimplespasos.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "entidades")
public class SimpleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(name = "descripcion", nullable = true, unique = true, length = 70)
    private String nombre;

    public SimpleEntity(){

    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
