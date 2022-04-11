package SellCount.util;

import SellCount.controller.ObradaJmjera;
import SellCount.model.Artikl;
import SellCount.model.Jmjera;
import SellCount.model.Klasifikacija;
import SellCount.model.Operater;
import SellCount.model.Djelatnik;
import com.github.javafaker.Faker;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.BarcodeEAN;
import java.util.List;
import javax.swing.DefaultListModel;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

public class PocetniInsert {

    private ObradaJmjera obradaJM;

    public static void unosOperatera() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Operater o = new Operater();
        o.setUsername("partner");
        o.setUloga("oper");
        o.setLozinka(BCrypt.hashpw("potvrda", BCrypt.gensalt()));

        session.save(o);
        session.getTransaction().commit();
    }
    
    public static void unosBlagajnika() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Operater o = new Operater();
        o.setUsername("blagajnik");
        o.setUloga("djelatnik");
        o.setLozinka(BCrypt.hashpw("racun", BCrypt.gensalt()));

        session.save(o);
        session.getTransaction().commit();
    }

    public static void unosBenze() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Faker faker = new Faker();
        
        for(int i=0;i<10;i++){
        Djelatnik d= new Djelatnik();
        d.setIme(faker.name().firstName());
        d.setPrezime(faker.name().lastName());
        session.save(d);
        }
        
        Jmjera j = new Jmjera();
        j.setNaziv("L");
        session.save(j);
        
        Klasifikacija k = new Klasifikacija();
        k.setNaziv("Gorivo");
        session.save(k);

        Artikl artikl = new Artikl();
        artikl.setNaziv("Eurosuper 95");
        artikl.setCijena(12.45);
        artikl.setEANcode("385" + faker.number().digits(10));
        artikl.setKolicina(28763.87);
        artikl.setJmjera(j);
        artikl.setKlasifikacija(k);
        session.save(artikl);
        artikl = new Artikl();
        artikl.setNaziv("Eurosuper 100 BS AmbrošPower!");
        artikl.setCijena(13.79);
        artikl.setEANcode("385" + faker.number().digits(10));
        artikl.setKolicina(27402.18);
        artikl.setJmjera(j);
        artikl.setKlasifikacija(k);
        session.save(artikl);
        artikl = new Artikl();
        artikl.setNaziv("Eurodiesel BS");
        artikl.setCijena(13.51);
        artikl.setEANcode("385" + faker.number().digits(10));
        artikl.setKolicina(21274.42);
        artikl.setJmjera(j);
        artikl.setKlasifikacija(k);
        session.save(artikl);
        artikl = new Artikl();
        artikl.setNaziv("Eurodiesel BS AmbrošPower!");
        artikl.setCijena(14.86);
        artikl.setEANcode("385" + faker.number().digits(10));
        artikl.setKolicina(17453.10);
        artikl.setJmjera(j);
        artikl.setKlasifikacija(k);
        session.save(artikl);
        artikl = new Artikl();
        artikl.setNaziv("Autoplin");
        artikl.setCijena(6.82);
        artikl.setEANcode("385" + faker.number().digits(10));
        artikl.setKolicina(3853.32);
        artikl.setJmjera(j);
        artikl.setKlasifikacija(k);
        session.save(artikl);
        
        k=new Klasifikacija();
        k.setNaziv("Pivo");
        session.save(k);
        
        j= new Jmjera();
        j.setNaziv("KOM");
        session.save(j);
        
        for (int i = 0; i<14;i++){
        artikl = new Artikl();
        artikl.setNaziv(faker.beer().name());
        double x=(int)(Math.random()*10)+10;
        artikl.setCijena(x+0.99);
        artikl.setEANcode("385" + faker.number().digits(10));
        artikl.setKolicina(x+x);
        artikl.setJmjera(j);
        artikl.setKlasifikacija(k);
        session.save(artikl);
        }
        
        k=new Klasifikacija();
        k.setNaziv("Žestoka pića");
        session.save(k);
        
        String str,cap;
        for (int i = 0; i<6;i++){
        artikl = new Artikl();
        str = faker.animal().name() + " Whisky";
        cap = str.substring(0, 1).toUpperCase() + str.substring(1);
        artikl.setNaziv(cap);
        double x=(int)(Math.random()*100)+100;
        artikl.setCijena(x+0.99);
        artikl.setEANcode("385" + faker.number().digits(10));
        x=(int)(Math.random()*10)+10;
        artikl.setKolicina(x);
        artikl.setJmjera(j);
        artikl.setKlasifikacija(k);
        session.save(artikl);
        } 
        
      
        session.getTransaction().commit();

    }

    public static void unosSvega() {
        unosOperatera();
        unosBlagajnika();

        unosBenze();
    }
}
