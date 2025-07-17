package Uebung4.Three;

public class Star implements Mobile {
    protected double w;

    public Star(double w) throws IllegalArgumentException { //throws IllegalArgumentException unchecked, можно опустиь
        if (w <= 0) {
            throw new IllegalArgumentException("weight is not positive");
        }
        this.w = w;
    }

    @Override
    public double weight() {
        return w;
    }

    @Override
    public String toString() {
        return "Star[" + String.format("%.2f", w) + "]";//2 цифры после запятой
    }

    @Override
    public void balance() {
    }
}
