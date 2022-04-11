package SellCount.controller;

import SellCount.model.Klasifikacija;
import SellCount.util.SellCountException;
import java.util.List;

public class ObradaKlasifikacija extends Obrada<Klasifikacija> {

    @Override
    public List<Klasifikacija> read() {
        return session.createQuery("from Klasifikacija a order by a.naziv").list();
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
