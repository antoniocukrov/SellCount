package SellCount.controller;

import SellCount.model.Primka;
import SellCount.util.HibernateUtil;
import SellCount.util.SellCountException;
import java.util.List;

public class ObradaPrimka extends Obrada<Primka>{
    
    public ObradaPrimka(){
        
    }
    
    @Override
    public List<Primka> read(){
        return session.createQuery("from Primka a order by a.brojOtpremnice").list();
    }
    
  public List<Primka> read(String uvjet) {
        return session.createQuery("from Primka p "
                + " where concat(p.brojOtpremnice) "
                + " like :uvjet order by p.brojOtpremnice")
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
