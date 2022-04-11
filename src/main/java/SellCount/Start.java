package SellCount;

import SellCount.controller.ObradaPrimka;
import SellCount.model.Artikl;
import org.hibernate.Session;
import SellCount.util.HibernateUtil;
import SellCount.util.PocetniInsert;
import SellCount.view.SplashScreen;
import com.github.javafaker.Faker;
import java.util.List;

public class Start {
    private Session session;
    
    public Start(){
       
    }
    
    public static void main(String[] args) {
            new SplashScreen().setVisible(true);
            //PocetniInsert.unosSvega();
            
            
            
            
            
            
 
    }
}
