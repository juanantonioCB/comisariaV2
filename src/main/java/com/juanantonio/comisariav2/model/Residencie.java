
package com.juanantonio.comisariav2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author Juan Antonio
 */
public class Residencie implements Serializable{
    private final static long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    private long id;
    @Column(name="id_suspect")
    private long id_suspect;
    @Column(name="residencie")
    private String residencie;

    public Residencie(long id, long id_suspect, String licensePlate) {
        this.id = id;
        this.id_suspect = id_suspect;
        this.residencie = licensePlate;
    }

    public Residencie() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_suspect() {
        return id_suspect;
    }

    public void setId_suspect(long id_suspect) {
        this.id_suspect = id_suspect;
    }

    public String getResidencie() {
        return residencie;
    }

    public void setResidencie(String residencie) {
        this.residencie = residencie;
    }


}
