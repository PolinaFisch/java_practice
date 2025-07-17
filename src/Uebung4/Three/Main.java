package Uebung4.Three;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        /*Star ob1 = new Star(34567.567890);
        System.out.println(ob1.toString());
        Star star1 = new Star(4);*/

        Mobile star1 = new Star(2);
        GlitterStar star2 = new GlitterStar(4);
        Wire wire = new Wire(star1, star2, 7);

        for (int i = 0; i < 3; i++) {
            wire.balance();
            System.out.println(wire);
            star2.decorate();
        }

        System.out.println(star2);

        /*Star a = new Star(2);
        Star b = new Star(4);
        Wire ab = new Wire(a, b, 9);

        ab.balance();

        System.out.println(ab);*/
    }
}