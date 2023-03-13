package com.springsimplespasos.hibernate.entidades.manytoone;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "telefonos")
public class Telefono implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer codigo;
    @Column(nullable = true, length = 20)
    private String numero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "persona_id", foreignKey = @ForeignKey(name = "FK_PERSONA_ID"))
    private Persona persona;
    public Telefono() {
    }

    public Telefono(Integer codigo, String numero) {
        this.codigo = codigo;
        this.numero = numero;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
