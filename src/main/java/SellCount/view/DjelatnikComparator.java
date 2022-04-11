/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SellCount.view;

import SellCount.model.Djelatnik;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author Lord Pupcent
 */
public class DjelatnikComparator implements Comparator<Djelatnik> {

    private Collator hr;

    public DjelatnikComparator() {
        hr = Collator.getInstance(new Locale("hr", "HR")); //Your locale here
        hr.setStrength(Collator.PRIMARY);
    }

    @Override
    public int compare(Djelatnik o1, Djelatnik o2) {
        return hr.compare(o1.getIme(), o2.getIme());
    }

}
