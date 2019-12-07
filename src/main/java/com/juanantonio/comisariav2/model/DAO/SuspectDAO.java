
package com.juanantonio.comisariav2.model.DAO;

import com.juanantonio.comisariav2.model.Suspect;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Juan Antonio
 */
public class SuspectDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
    
    public void insert(Suspect s){
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(s);
        manager.getTransaction().commit();
        manager.close();
    }
}
