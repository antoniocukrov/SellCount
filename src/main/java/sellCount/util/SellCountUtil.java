package sellCount.util;

import sellCount.model.Operater;

public class SellCountUtil {
    public static Operater operater;
    public static final String NAZIV_APP="Sell&Count";
   
    public static String getNaslov(String naslov){
            if(SellCountUtil.operater==null){
                return SellCountUtil.NAZIV_APP + " " + naslov;
            }
            return SellCountUtil.NAZIV_APP + " - " + naslov + " - " + SellCountUtil.operater.getUloga();
    }
}
       
    
    

