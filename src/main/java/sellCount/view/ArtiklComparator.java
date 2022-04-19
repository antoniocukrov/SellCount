package sellCount.view;

import sellCount.model.Artikl;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

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
