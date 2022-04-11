/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SellCount.model;


import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Lord Pupcent
 */
@Entity
public class Klasifikacija extends Entitet {
    private String naziv;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    @Override
    public String toString(){
        return naziv;
    }
}
