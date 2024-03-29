package com.juanantonio.comisariav2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Juan Antonio
 */
@Entity
@Table(name = "RESIDENCIES")
public class Residencie implements Serializable {

 
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "residencie")
    private String residencie;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "suspect_id")
    private Suspect suspect;

    public Residencie() {
    }

    public Residencie(long id, String residencie, Suspect suspect) {
        this.id = id;
        this.residencie = residencie;
        this.suspect = suspect;
    }
    
    public Residencie(String residencie, Suspect suspect) {
        this.residencie = residencie;
        this.suspect = suspect;
    }

    public Residencie(int i, String elementAt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getResidencie() {
        return residencie;
    }

    @Override
    public String toString() {
        return residencie;
    }

    public void setResidencie(String residencie) {
        this.residencie = residencie;
    }

    public Suspect getSuspect() {
        return suspect;
    }

    public void setSuspect(Suspect suspect) {
        this.suspect = suspect;
    }

}
