/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.at_pb_auxiliar_nicholas_joao.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Nicholas
 */
@Entity
@Table(name="series")
public class Serie implements Serializable {
    private  @GeneratedValue(strategy = GenerationType.AUTO) @Id Long id;
    private String name;
    private String description;
    private byte[] image;

    public Serie() {}
    
    public Serie(String name, String description, byte[] image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }


    public byte[] getImage() {
        return this.image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description){
        this.description = description;
    }

    public void setImage(byte[] image){
        this.image = image;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.description, this.image);
    }

    public String generateBase64Image(byte[] imagem) {
         return Base64.getEncoder().encodeToString(imagem);
    }

    @Override
    public String toString(){
        return "";
    }
    @Override
    public boolean equals(Object o){
        if (this==o) 
            return true;
        if (! (o instanceof Serie))
            return false;
        Serie serie = (Serie) o;
        return Objects.equals(this.id, serie.id) && Objects.equals(this.name, serie.name)
                && Objects.equals(this.description, serie.description)  && Arrays.equals(this.image, serie.image);
    }
    
}
