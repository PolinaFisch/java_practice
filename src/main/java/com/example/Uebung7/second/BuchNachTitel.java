package com.example.Uebung7.second;
import com.example.Uebung7.first.Buch;
import java.util.Comparator;

public class BuchNachTitel implements Comparator<Buch> {

    @Override
    public int compare(Buch o1, Buch o2) {
        /*if (o1.getTitel().equals(o2.getTitel())) {
            return 0;
        } else if (o1.getTitel().compareTo(o2.getTitel()) < 0) {
            return -1;
        } else {
            return 1;
        }*/

        return o1.getTitel().compareTo(o2.getTitel());
    }

}
