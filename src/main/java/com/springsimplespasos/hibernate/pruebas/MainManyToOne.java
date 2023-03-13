package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.manytoone.Persona;
import com.springsimplespasos.hibernate.entidades.manytoone.Telefono;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Arrays;

public class MainManyToOne {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();

        Persona juan = new Persona(null, "Juan");
        Persona mariana = new Persona(null, "mariana");

        Telefono celularJuan = new Telefono(null, "11111111");
        Telefono lineaJuan = new Telefono(null, "2222222222");

        celularJuan.setPersona(juan);//Need funtion inverse for better funcionality
        lineaJuan.setPersona(juan);

        juan.setTelefonos(Arrays.asList(celularJuan, lineaJuan));

        session.beginTransaction();
/*        session.saveOrUpdate(juan);
        session.saveOrUpdate(mariana);*/

        Persona persona = session.get(Persona.class, 4);// person class id DB
        persona.getTelefonos().forEach(t-> System.out.println(t.getNumero())); //cycle for in a line

        session.getTransaction().commit();
        session.close();

    }
}
