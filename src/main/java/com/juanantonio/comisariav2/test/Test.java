package com.juanantonio.comisariav2.test;

import com.juanantonio.comisariav2.model.Residencie;
import com.juanantonio.comisariav2.model.Suspect;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Juan Antonio
 */
public class Test {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String[] args) {
        creaDatos();
        imprimirDatos();
    }

    static void creaDatos() {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        //Carga

        Suspect s = new Suspect(1L, "a", "b", "c", "d", "e", "f");
        Residencie r = new Residencie(2L, "a", s);
        manager.persist(r);
        manager.persist(s);

        manager.getTransaction().commit();
        manager.close();
    }

    static void imprimirDatos() {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();

        Suspect s = manager.find(Suspect.class, 1L);
        System.out.println("sacado " + s);

        //Y de forma Lazy
        List<Residencie> residencias = s.getResidencies();
        residencias.size();
        System.out.println("\n\n"+residencias);

        manager.getTransaction().commit();
        manager.close();
    }

}
