package musterPruefung.task03;

public class RedFigure implements Brettfigur {

    private boolean isMoved;

    @Override
    public boolean isMoved() {
        return isMoved;
    }

    @Override
    public void setMoved(boolean moved) {
        isMoved = moved;
    }
}
