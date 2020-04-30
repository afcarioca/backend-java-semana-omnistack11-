package com.ongapp.application.Model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "incidents")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private double value;

    @NotNull
    @ManyToOne(targetEntity = Ong.class)
    @JoinColumn(name="ong_id")
    private Ong ongId;


    // @NotNull
    // @ManyToOne(targetEntity = Ong.class)
    // @JoinColumn(name="ong_id")
    // private Ong ongId;

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return this.id;
    }

    public void setTitle(Object object){
        this.title = (@NotNull String) object;
    }

    public String getTitle(){
        return this.title;
    }

    public void setDescription(Object object){
        this.description = (@NotNull String) object;
    }

    public String getDescription(){
        return this.description;
    }

    public void setValue(Object object){
        this.value = (@NotNull Double) object;
    }

    public double getValue(){
        return this.value;
    }

    public void setOngId(Ong ongId){
        this.ongId = ongId;
    }

    // public UUID getOngId(){
    //     return this.ongId.getId();
    // }

    // public String getOngId(){
    //     return this.ongId.getId();
    // }

       public Ong getOngId(){
           return this.ongId;
       }


    // public void setOngId(Ong ongId){
    //     this.ongId = ongId.getId();
    // }

    // public Ong getOngId(){
    //     return this.ongId;
    // }
}