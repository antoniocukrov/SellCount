package SellCount.util;

import SellCount.model.Operater;

public class SellCountUtil {
    public static Operater operater;
    public static final String NAZIV_APP="Sell&Count";
   
    public static String getNaslov(String naslov){
          return SellCountUtil.NAZIV_APP + " " + naslov;
        }
}
       
    
    

