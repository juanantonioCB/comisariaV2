package com.juanantonio.comisariav2.test;

import com.juanantonio.comisariav2.model.Suspect;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Juan Antonio
 */
public class Test {

    private static EntityManager manager;
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("Persistencia");
        manager = emf.createEntityManager();
        
        Suspect s =new Suspect("adf", "aaa", "dfa", "sdfa", "df", "a");

        manager.getTransaction().begin();
        manager.persist(s);
        manager.getTransaction().commit();
        ArrayList<Suspect> suspects = (ArrayList<Suspect>) manager.createQuery("FROM Suspect").getResultList();
        System.out.println(suspects);

    }
}
