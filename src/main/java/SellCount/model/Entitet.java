package SellCount.model;

import javax.annotation.processing.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Entitet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sifra;

    public Long getSifra() {
        return sifra;
    }

    public void setSifra(Long sifra) {
        this.sifra = sifra;
    }
    
    
    
}
