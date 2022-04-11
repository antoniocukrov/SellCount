/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SellCount.controller;

import SellCount.util.SellCountException;
import SellCount.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;


public abstract class Obrada<T> {
    
    protected Session session;
    protected T entitet;
    
    public abstract List<T> read();
    protected abstract void kontrolaCreate() throws SellCountException;
    protected abstract void kontrolaUpdate() throws SellCountException;
    protected abstract void kontrolaDelete() throws SellCountException;
    
    public Obrada(){
        session=HibernateUtil.getSession();
    }
    
    public T create() throws SellCountException{
        kontrolaCreate();
        save();
        return entitet;
    }
    
    public T update() throws SellCountException{
        kontrolaUpdate();
        save();
        return entitet;
    }
    
    public void delete() throws SellCountException{
        kontrolaDelete();
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
    }
    
    private void save(){
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
}
