package com.example.musterPruefung.task03;

public class BlueFigure implements Brettfigur {

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
