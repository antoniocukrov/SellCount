package sellCount.controller;

import sellCount.model.Artikl;
import sellCount.model.Djelatnik;
import sellCount.model.Jmjera;
import sellCount.util.SellCountException;
import java.util.List;

public class ObradaJmjera extends Obrada<Jmjera>{
    
    @Override
    public List<Jmjera> read(){
        return session.createQuery("from Jmjera a order by a.naziv").list();
    }
    
  public List<Jmjera> read(String uvjet) {
        return session.createQuery("from Jmjera p "
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
