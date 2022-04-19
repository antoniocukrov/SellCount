package sellCount.controller;

import sellCount.model.Operater;
import sellCount.util.SellCountException;
import java.util.List;
import javax.persistence.NoResultException;
import org.mindrot.jbcrypt.BCrypt;

public class ObradaOperater extends Obrada<Operater>{

    @Override
    public List<Operater> read() {
        return session.createQuery("from Operater").list();
    }
    
    public Operater autoriziraj(String username, String lozinka){
        Operater operater=null;
        
        try {
            operater = (Operater)session.createQuery("from Operater where username=:username")
                .setParameter("username", username).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        
        if(operater==null){
            return null;
        }
        
        
        return BCrypt.checkpw(lozinka, operater.getLozinka()) ?  operater : null;
    }
    
    public Operater pocetniUnos() {
        Operater pocetniOp=null;
        try{
            pocetniOp = (Operater)session.createQuery("from Operater where uloga=oper");
        }catch (NoResultException e){
            return null;
        }
        return pocetniOp;
        }
    
    @Override
    protected void kontrolaCreate() throws SellCountException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void kontrolaUpdate() throws SellCountException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void kontrolaDelete() throws SellCountException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
