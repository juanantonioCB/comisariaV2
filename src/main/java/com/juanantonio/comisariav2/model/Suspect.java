package com.juanantonio.comisariav2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

/**
 *
 * @author Juan Antonio
 */
@Entity
@Table(name = "SUSPECT")
public class Suspect implements Serializable {

    private final static long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname1")
    private String surname1;
    @Column(name = "surname2")
    private String surname2;
    @Column(name = "dni")
    private String dni;
    @Column(name = "records")
    private String records;
    @Column(name = "facts")
    private String facts;
    @OneToMany(mappedBy = "suspect", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Residencie> residencies = new ArrayList<>();
    @OneToMany(mappedBy = "suspect", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();
    @OneToMany(mappedBy = "suspect", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LicensePlate> licensePlates = new ArrayList<>();
    @OneToMany(mappedBy = "suspect", cascade = CascadeType.ALL, orphanRemoval = true)
    
    private List<Email> emails = new ArrayList<>();

    @JoinTable(name = "COMPANIONS", joinColumns = {
        @JoinColumn(name = "idSuspect1", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "idSuspect2", referencedColumnName = "id", nullable = false)})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Suspect> companions = new ArrayList<>();

    public Suspect() {

    }

    public Suspect(Long id, String name, String surname1, String surname2, String dni, String records, String facts) {
        this.id = id;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.dni = dni;
        this.records = records;
        this.facts = facts;
    }

    public Suspect(String name, String surname1, String surname2, String dni, String records, String facts) {
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.dni = dni;
        this.records = records;
        this.facts = facts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.setId((Long) id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRecord() {
        return getRecords();
    }

    public void setRecord(String record) {
        this.setRecords(record);
    }

    public String getFacts() {
        return facts;
    }

    public void setFacts(String facts) {
        this.facts = facts;
    }

    @Override
    public String toString() {
        return name + " " + surname1 + " " + surname2;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }

    public List<Residencie> getResidencies() {
        return residencies;
    }

    public void setResidencies(List<Residencie> residencies) {
        this.residencies = residencies;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<LicensePlate> getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(List<LicensePlate> licensePlates) {
        this.licensePlates = licensePlates;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Suspect> getCompanions() {
        return companions;
    }

    public void setCompanions(List<Suspect> companions) {
        this.companions = companions;
    }
}
