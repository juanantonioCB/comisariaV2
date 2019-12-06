
package com.juanantonio.comisariav2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author Juan Antonio
 */
public class Companion implements Serializable{
    private final static long serialVersionUID = 1L;
    @Id
    @Column(name="id1")
    private long id1;
    @Id
    @Column(name="id2")
    private long id2;

    public Companion(long id1, long id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    public Companion() {
    }

    public long getId1() {
        return id1;
    }

    public void setId1(long id1) {
        this.id1 = id1;
    }

    public long getId2() {
        return id2;
    }

    public void setId2(long id2) {
        this.id2 = id2;
    }
}
