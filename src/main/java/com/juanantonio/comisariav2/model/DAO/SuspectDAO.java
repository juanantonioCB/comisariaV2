package com.juanantonio.comisariav2.model.DAO;

import com.juanantonio.comisariav2.model.Suspect;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Juan Antonio
 */
public class SuspectDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public void insert(Suspect s) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(s);
        manager.getTransaction().commit();
        manager.close();
    }

    public void removeSuspect(Long id) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Suspect s = manager.find(Suspect.class, id);
        manager.remove(s);
        manager.getTransaction().commit();

        manager.close();
    }

    public List<Suspect> getSearchSuspects(String s) {
        List<Suspect> suspects = null;
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        suspects = manager.createQuery("FROM Suspect WHERE name like '%" + s + "%' "
                + "OR surname1 LIKE '%" + s + "%' "
                + "OR surname2 LIKE '%" + s + "%'"
                + "OR dni LIKE '" + s + "'").getResultList();

        manager.getTransaction().commit();
        manager.close();
        return suspects;
    }

    public Suspect getOneSuspect(Long id) {
        Suspect s = null;
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        s = manager.find(Suspect.class, id);
        manager.getTransaction().commit();
        manager.close();
        return s;
    }

    public List<Suspect> getSuspects() {
        List<Suspect> suspects = null;
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        suspects = manager.createQuery("FROM Suspect").getResultList();
        manager.getTransaction().commit();
        manager.close();
        return suspects;
    }
}
