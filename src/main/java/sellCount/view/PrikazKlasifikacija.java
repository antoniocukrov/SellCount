package sellCount.view;

import sellCount.model.Djelatnik;
import sellCount.model.Klasifikacija;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class PrikazKlasifikacija extends JLabel implements ListCellRenderer<Klasifikacija>  {
    
    public PrikazKlasifikacija(){
        setOpaque(true);
    }
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Klasifikacija> list,
            Klasifikacija value, int index, boolean isSelected,boolean cellHasFocus){
     if (isSelected) {
            setBackground(Color.BLUE);
            setForeground(Color.WHITE);
        } else {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
          }
     
     setText((value.getNaziv()==null ? "Nepoznato" : value.getNaziv().equals("") ? "XXXXXXX" :  value.getNaziv())
                );   
     return this;
    
    }
}
        

