
package com.juanantonio.comisariav2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author Juan Antonio
 */
public class LicensePlate implements Serializable{
    private final static long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    private long id;
    @Column(name="id_suspect")
    private long id_suspect;
    @Column(name="license_plate")
    private String licensePlate;

    public LicensePlate(long id, long id_suspect, String licensePlate) {
        this.id = id;
        this.id_suspect = id_suspect;
        this.licensePlate = licensePlate;
    }

    public LicensePlate() {
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

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
