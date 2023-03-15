package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.manytomany.Publicacione;
import com.springsimplespasos.hibernate.entidades.manytomany.Usuario;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Arrays;

public class MainManyToMany {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();

        Usuario admin = new Usuario(1, "admin");
        Usuario user = new Usuario(2, "user");

        Publicacione publicacione1 = new Publicacione(1, "primera");
        Publicacione publicacione2 = new Publicacione(2, "segunda");
        Publicacione publicacione3 = new Publicacione(3, "tercera");
        Publicacione publicacione4 = new Publicacione(4, "cuarta");


        admin.setPublicaciones(Arrays.asList(publicacione1, publicacione2));
        user.setPublicaciones(Arrays.asList(publicacione3, publicacione4, publicacione2));

        session.beginTransaction();

        /*session.saveOrUpdate(admin);
        session.saveOrUpdate(user);
        session.saveOrUpdate(publicacione1);
        session.saveOrUpdate(publicacione2);
        session.saveOrUpdate(publicacione3);
        session.saveOrUpdate(publicacione4);*/

        Usuario usuario = session.get(Usuario.class, 2);
        usuario.getPublicaciones().forEach(publicacione -> System.out.println(publicacione.getTexto()));

        session.getTransaction().commit();
        session.close();
    }


}
