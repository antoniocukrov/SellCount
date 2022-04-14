package SellCount.controller;

import SellCount.model.Artikl;
import SellCount.model.Klasifikacija;
import SellCount.util.SellCountException;
import java.util.List;

public class ObradaKlasifikacija extends Obrada<Klasifikacija> {

    @Override
    public List<Klasifikacija> read() {
        return session.createQuery("from Klasifikacija a order by a.naziv").list();
    }

    public List<Klasifikacija> read(String uvjet) {
        return session.createQuery("from Klasifikacija p "
                + " where concat(p.naziv) "
                + " like :uvjet order by p.naziv")
                .setParameter("uvjet","%" + uvjet + "%")
                .setMaxResults(50)
                .list();
    }
    
    @Override
    protected void kontrolaCreate() throws SellCountException {

    }

    @Override
    protected void kontrolaUpdate() throws SellCountException {

    }

    @Override
    protected void kontrolaDelete() throws SellCountException {

    }

}
