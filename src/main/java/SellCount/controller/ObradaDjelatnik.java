package SellCount.controller;

import SellCount.model.Artikl;
import SellCount.model.Djelatnik;
import SellCount.util.SellCountException;
import java.util.List;

public class ObradaDjelatnik extends Obrada<Djelatnik>{
    
    @Override
    public List<Djelatnik> read(){
        return session.createQuery("from Djelatnik a order by a.ime").list();
    }
    
    public List<Djelatnik> read(String uvjet) {
        return session.createQuery("from Djelatnik p "
                + " where concat(p.ime) "
                + " like :uvjet order by p.ime")
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
