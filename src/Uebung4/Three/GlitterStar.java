package Uebung4.Three;

public class GlitterStar extends Star {


    public GlitterStar(double w){
        super(w);
        decorate();
    }

    public void decorate(){
        w += 1;
    }

    @Override
    public String toString(){
        return String.format("[GlitterStar[%.2f]]", w);
    }
}
