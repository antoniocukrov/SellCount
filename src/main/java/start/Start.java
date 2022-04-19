package start;

import sellCount.controller.ObradaOperater;
import sellCount.controller.ObradaPrimka;
import sellCount.model.Artikl;
import sellCount.model.Operater;
import org.hibernate.Session;
import sellCount.util.HibernateUtil;
import sellCount.util.PocetniInsert;
import sellCount.view.SplashScreen;
import com.github.javafaker.Faker;
import java.util.List;

public class Start {
    private Session session;
    
    public Start(){
           }
    
    public static void main(String[] args) {
      new SplashScreen().setVisible(true);
    }
}
