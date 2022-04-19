package sellCount.view;

import sellCount.model.Djelatnik;
import sellCount.model.Djelatnik;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class PrikazDjelatnika extends JLabel implements ListCellRenderer<Djelatnik>  {
    
    public PrikazDjelatnika(){
        setOpaque(true);
    }
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Djelatnik> list,
            Djelatnik value, int index, boolean isSelected,boolean cellHasFocus){
     if (isSelected) {
            setBackground(Color.BLUE);
            setForeground(Color.WHITE);
        } else {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
          }
     
     setText((value.getIme()==null ? "Nepoznato" : value.getIme().equals("") ? "XXXXXXX" :  value.getIme())
                + " " + (value.getPrezime()==null ? "Nepoznato" : value.getPrezime()));   
     return this;
    
    }
}
        

