package SellCount.util;

public class SellCountException extends Exception {
    
    private String poruka;

    public SellCountException(String poruka) {
        super();
        this.poruka = poruka;
    }

    public String getPoruka() {
        return poruka;
    }
    
}
