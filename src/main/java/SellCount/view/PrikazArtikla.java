/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SellCount.view;

import SellCount.model.Artikl;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class PrikazArtikla extends JLabel implements ListCellRenderer<Artikl>  {
    
    public PrikazArtikla(){
        setOpaque(true);
    }
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Artikl> list,
            Artikl value, int index, boolean isSelected,boolean cellHasFocus){
     if (isSelected) {
            setBackground(Color.BLUE);
            setForeground(Color.WHITE);
        } else {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
          }
     
     setText(value.getNaziv()==null ? "Nepoznato" : value.getNaziv());   
     return this;
    
    }
}
        

