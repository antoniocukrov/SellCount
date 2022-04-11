/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SellCount.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Lord Pupcent
 */
@Entity
public class Artikl extends Entitet {

    private String naziv;
    private String EANcode;
    private Double cijena;
    private Double kolicina;

    @ManyToOne
    private Jmjera jmjera;
    @ManyToOne
    private Klasifikacija klasifikacija;

    @ManyToMany (mappedBy = "artikli")
    private List<Primka> primke;

    public List<Primka> getPrimke() {
        return primke;
    }

    public void setPrimke(List<Primka> primke) {
        this.primke = primke;
    }

    public Double getKolicina() {
        return kolicina;
    }

    public void setKolicina(Double kolicina) {
        this.kolicina = kolicina;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getEANcode() {
        return EANcode;
    }

    public void setEANcode(String EANcode) {
        this.EANcode = EANcode;
    }

    public Double getCijena() {
        return cijena;
    }

    public void setCijena(Double cijena) {
        this.cijena = cijena;
    }

    public Jmjera getJmjera() {
        return jmjera;
    }

    public void setJmjera(Jmjera jmjera) {
        this.jmjera = jmjera;
    }

    public Klasifikacija getKlasifikacija() {
        return klasifikacija;
    }

    public void setKlasifikacija(Klasifikacija klasifikacija) {
        this.klasifikacija = klasifikacija;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    }
 


