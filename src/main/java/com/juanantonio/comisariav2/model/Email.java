
package com.juanantonio.comisariav2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author Juan Antonio
 */
public class Email implements Serializable{
    private final static long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    private long id;
    @Column(name="id_suspect")
    private long id_suspect;
    @Column(name="email")
    private String email;

    public Email(long id, long id_suspect, String email) {
        this.id = id;
        this.id_suspect = id_suspect;
        this.email = email;
    }

    public Email() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
