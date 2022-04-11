/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SellCount.view;

import SellCount.model.Artikl;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author Lord Pupcent
 */
public class ArtiklComparator implements Comparator<Artikl> {

    private Collator hr;

    public ArtiklComparator() {
        hr = Collator.getInstance(new Locale("hr", "HR")); //Your locale here
        hr.setStrength(Collator.PRIMARY);
    }

    @Override
    public int compare(Artikl o1, Artikl o2) {
        return hr.compare(o1.getNaziv(), o2.getNaziv());
    }

     
}
