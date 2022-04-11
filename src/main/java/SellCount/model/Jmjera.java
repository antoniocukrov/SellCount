package SellCount.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Jmjera extends Entitet {
    
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
