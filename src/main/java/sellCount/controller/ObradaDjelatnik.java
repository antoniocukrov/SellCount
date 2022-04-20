package sellCount.controller;

import sellCount.model.Artikl;
import sellCount.model.Djelatnik;
import sellCount.util.SellCountException;
import java.util.List;

public class ObradaDjelatnik extends Obrada<Djelatnik>{
    
    ObradaPrimka primka;
    
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
