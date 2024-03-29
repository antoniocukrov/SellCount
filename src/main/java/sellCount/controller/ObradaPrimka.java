package sellCount.controller;

import sellCount.model.Primka;
import sellCount.util.HibernateUtil;
import sellCount.util.SellCountException;
import java.util.List;

public class ObradaPrimka extends Obrada<Primka>{
    Primka primka;
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
  
  public Primka getPrimka(Long sifra){
        return (Primka) session.createQuery("from Primka where sifra=:sifra")
                .setParameter("sifra",sifra)
                .getSingleResult();
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
