package com.datamart.humancases.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Table(name = "human")
@Entity(name = "human")



public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "age")
    private int age;

    @NotBlank
    @Column(name = "adress")
    private String adress;

    @Column(name = "complement")
    private String complement;

    @Column(name = "gravity")
    private String gravity;

    @Column(name = "status")
    private String status;

    @Column(name = "febre")
    private boolean febre;

    @Column(name = "manchas")
    private boolean manchas;

    @Column(name = "dorCabeca")
    private boolean dorCabeca;

    @Column(name = "nausea")
    private boolean nausea;
    
    @Column(name = "dorOlhos")
    private boolean dorOlhos;

    @Column(name = "dorCorpo")
    private boolean dorCorpo;

    @Column(name = "cansaco")
    private boolean cansaco;
    
    public Human(String name, int age, String adress, String complement, String gravity,
            String status, boolean febre, boolean manchas, boolean dorCabeca, boolean  nausea, boolean dorOlhos, boolean dorCorpo, boolean cansaco) {
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.complement = complement;
        this.gravity = gravity;
        this.status = status;
        this.febre = febre;
        this.manchas = manchas;
        this.dorCabeca = dorCabeca;
        this.nausea = nausea;
        this.dorOlhos = dorOlhos;
        this.dorCorpo = dorCorpo;
        this.cansaco = cansaco;
    }

    public Human(){
        
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAdress() {
        return adress;
    }

    public String getComplement() {
        return complement;
    }

    public String getGravity() {
        return gravity;
    }

    public String getStatus() {
        return status;
    }

    public boolean isFebre() {
        return febre;
    }

    public boolean isManchas() {
        return manchas;
    }

    public boolean isDorCabeca() {
        return dorCabeca;
    }

    public boolean isNausea() {
        return nausea;
    }

    public boolean isDorOlhos() {
        return dorOlhos;
    }

    public boolean isDorCorpo() {
        return dorCorpo;
    }

    public boolean isCansaco() {
        return cansaco;
    }

    
}
