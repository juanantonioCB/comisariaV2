
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
    @Column(name="id")
    private long id;
    @Id
    @Column(name="id2")
    private Suspect suspect1;

   
}
