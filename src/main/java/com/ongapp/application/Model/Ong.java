package com.ongapp.application.Model;

import java.util.List;
import java.util.UUID;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Ong {
    // @Id
    // private UUID id;
    @Id
    private String id;
    
    @NotNull
    private String name;
    
    @NotNull
    private String email;
    
    @NotNull
    private String whatasapp;
    
    @NotNull
    private String city;

    @NotNull
    @Column(length = 2)
    private String uf;

    
    // @OneToMany(targetEntity = Incident.class)
    // private List<Incident> incidents;

    // public void setId(UUID id) {
    //     this.id = id;
    // }

    // public UUID getId() {
    //     return this.id;
    // }

    public void setId(String id){
        this.id =id;
    }

    public String getId(){
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setWhatsapp(final String whatsapp) {
        this.whatasapp = whatsapp;
    }

    public String getWhatsapp() {
        return this.whatasapp;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setUf(final String uf) {
        this.uf = uf;
    }

    public String getUf(){
        return this.uf;
    }

    // public void setIncidents(List<Incident> incidents){
    //     this.incidents = incidents;
    // }

    // public List<Incident> getIncidents(){
    //     return this.incidents;
    // }

    @Override
    public String toString() {
        
        return "[ Id: "+this.id+ 
        " name: "+this.name+
        " email: "+this.email+ 
        " whatasapp: "+this.whatasapp+
        " city: "+this.city+
        " uf: "+this.uf+" ]";
               
    }
}