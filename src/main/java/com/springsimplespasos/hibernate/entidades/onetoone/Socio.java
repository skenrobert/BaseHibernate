package com.springsimplespasos.hibernate.entidades.onetoone;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "socios")
public class Socio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer codigo;
    @Column(length = 40)
    private String nombre;
    @Column(unique = true, length = 12)
    private String documento;

    @OneToOne(mappedBy = "socio", cascade = CascadeType.ALL)
    private Carnet carnet;


    /*construct, GET and SET */
    public Socio() {
    }

    public Socio(Integer codigo, String nombre, String documento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.documento = documento;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }
}
