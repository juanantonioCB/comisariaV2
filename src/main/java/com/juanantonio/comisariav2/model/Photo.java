package com.juanantonio.comisariav2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author Juan Antonio
 */
public class Photo implements Serializable {

    private final static long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "id_sospechoso")
    private long idSospechoso;
    @Column(name = "photo")
    private byte[] photo;

    public Photo(long id, long idSospechoso, byte[] photo) {
        this.id = id;
        this.idSospechoso = idSospechoso;
        this.photo = photo;
    }

    public Photo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdSospechoso() {
        return idSospechoso;
    }

    public void setIdSospechoso(long idSospechoso) {
        this.idSospechoso = idSospechoso;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
