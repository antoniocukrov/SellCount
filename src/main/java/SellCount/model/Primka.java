package SellCount.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Primka extends Entitet {
    
    private String brojOtpremnice;
    private String dobavljac;
    private LocalDateTime vrijemeZaprimanja;
    private Double ukupanIznos;

    @ManyToOne
    private Djelatnik djelatnik;
    
    @ManyToMany 
    private List<Artikl> artikli;

    public LocalDateTime getVrijemeZaprimanja() {
        return vrijemeZaprimanja;
    }

    public void setVrijemeZaprimanja(LocalDateTime vrijemeZaprimanja) {
        this.vrijemeZaprimanja = vrijemeZaprimanja;
    }

    
    public String getBrojOtpremnice() {
        return brojOtpremnice;
    }

    public void setBrojOtpremnice(String brojOtpremnice) {
        this.brojOtpremnice = brojOtpremnice;
    }

    public String getDobavljac() {
        return dobavljac;
    }

    public void setDobavljac(String dobavljac) {
        this.dobavljac = dobavljac;
    }

    public Djelatnik getDjelatnik() {
        return djelatnik;
    }

    public void setDjelatnik(Djelatnik djelatnik) {
        this.djelatnik = djelatnik;
    }

    public List<Artikl> getArtikli() {
        return artikli;
    }

    public void setArtikli(List<Artikl> artikli) {
        this.artikli = artikli;
    }

    public Double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(Double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    
    @Override
    public String toString() {
        return brojOtpremnice;
    }
    
}
