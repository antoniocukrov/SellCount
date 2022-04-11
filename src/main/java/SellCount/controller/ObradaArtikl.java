package SellCount.controller;

import SellCount.model.Artikl;
import SellCount.util.HibernateUtil;
import SellCount.util.SellCountException;
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
