package sellCount.controller;

import java.math.BigDecimal;
import sellCount.model.Artikl;
import sellCount.util.HibernateUtil;
import sellCount.util.SellCountException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ObradaArtikl extends Obrada<Artikl>{
    Artikl artikl;
    
    @Override
    public List<Artikl> read(){
        return session.createQuery("from Artikl a order by a.naziv").list();
    }
    
    public List<Artikl> read(String uvjet) {
        return session.createQuery("from Artikl p "
                + " where concat(p.naziv) "
                + " like :uvjet order by p.naziv")
                .setParameter("uvjet","%" + uvjet + "%")
                .setMaxResults(50)
                .list();
    }
    
    
    public void updateKolicina(double hello,long ID) {
        Session session = HibernateUtil.getSession();

        Transaction tx = session.beginTransaction();
        artikl = session.load(Artikl.class, ID);
        artikl.setKolicina(hello + artikl.getKolicina());
        tx.commit();
        
        
    }
    
    private void kontrolaCijena()throws SellCountException {
        if( entitet.getCijena()==null || 
                entitet.getCijena().compareTo(Double.valueOf(0.00))<0 ||
                entitet.getCijena().compareTo(Double.valueOf(200000.00))>0){
            throw new SellCountException("Cijena mora biti postavljena, veća od 0 i manja od 200000");
        }
    }

    
    
    
    @Override
    protected void kontrolaCreate() throws SellCountException {
        kontrolaCijena();
    }

    @Override
    protected void kontrolaUpdate() throws SellCountException {
        kontrolaCijena();
    }

    @Override
    protected void kontrolaDelete() throws SellCountException {
       
    }

    
}
