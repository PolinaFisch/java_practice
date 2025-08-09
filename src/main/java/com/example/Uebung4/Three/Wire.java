package com.example.Uebung4.Three;

public class Wire implements Mobile {

    private static final double STEP = 0.001;

    private final double length;
    private double l1;
    private double l2;

    private final Mobile obj1;//для использования внутр класса этого
    private final Mobile obj2;


    public Wire(Mobile obj1, Mobile obj2, double length) {
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.length = length;
    }

    @Override
    public double weight() { //weight of the rope can be neglected
        return 0;
    }

    @Override
    public void balance() {
        l1 = 0.0;
        l2 = length;
        double diff = STEP * Math.max(obj1.weight(), obj2.weight()); //вычисляем погрешность
        System.out.println("diff = " + diff);
        while (Math.abs(obj1.weight() * l1 - obj2.weight()*l2) > diff){ //нетвердое равенство с погрешностью
            l1 += STEP;
            l2 = length - l1;
            if(l2 <= 0){
                throw new IllegalArgumentException("Impossible to balance");
            }
        }
    }

    @Override
    public String toString() {
        return "Mobile[%.2f:%s, %.2f:%s]".formatted(l1, obj1, l2, obj2);
    }
}
