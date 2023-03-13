package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.SimpleEntity;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class HibernateMain {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();
        session.beginTransaction();

        // to insert
        /* SimpleEntity entity = new SimpleEntity();
        entity.setNombre("Descripcion");
        session.save(entity);*/

        // to Update
/*        SimpleEntity entityUpdate = new SimpleEntity();
        entityUpdate.setCodigo(1);
        entityUpdate.setNombre("Robert");
        session.update(entityUpdate);*/

        // to Delete
/*        SimpleEntity entityDelete = new SimpleEntity();
        entityDelete.setCodigo(2);
        session.delete(entityDelete);*/


   /*     SimpleEntity entityRead = session.get(SimpleEntity.class, 1);
        System.out.println("welcome to spring "+entityRead.getNombre());
*/

        SimpleEntity entity = new SimpleEntity();
        entity.setNombre("Descripcion");

        SimpleEntity entityUpdate = new SimpleEntity();
        entityUpdate.setCodigo(1);
        entityUpdate.setNombre("Kenny Robert");

        session.saveOrUpdate(entity);
        session.saveOrUpdate(entityUpdate);

        session.getTransaction().commit();
        session.close();
    }

}
