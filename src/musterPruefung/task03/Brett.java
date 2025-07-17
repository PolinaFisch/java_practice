package musterPruefung.task03;

public class Brett {
    private Brettfigur[][] matrix = new Brettfigur[8][8];

    public Brett() {
        matrix[0][0] = new BlueFigure();
        matrix[0][2] = new BlueFigure();
        matrix[0][4] = new BlueFigure();
        matrix[0][6] = new BlueFigure();

        matrix[7][1] = new RedFigure();
        matrix[7][3] = new RedFigure();
        matrix[7][5] = new RedFigure();
        matrix[7][7] = new RedFigure();
    }

    public void print() {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == null) {
                    System.out.print(" [ ] ");
                } else if (matrix[row][column] instanceof RedFigure) {//.getClass.getSimpleName.equals("RedFigure")
                    System.out.print(" [R] ");
                } else {
                    System.out.print(" [B] ");
                }
            }
            System.out.println();
            System.out.println();
        }
    }

    public void ziehen() {

        while (true) {
            boolean anyMovement = Bewegung(BlueFigure.class, 1);
            if (!anyMovement) {
                break;
            }
            anyMovement = Bewegung(RedFigure.class, -2);
            if (!anyMovement) {
                break;
            }
        }
    }

    public boolean Bewegung(Class<?> clazz, int step) {
        boolean anyMovesMade = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matrix[i][j] != null && matrix[i][j].getClass().equals(clazz)) {
                    if ((i + step >= 0 && i + step <= 7) && !matrix[i][j].isMoved()) {
                        matrix[i + step][j] = matrix[i][j];
                        matrix[i][j] = null;
                        matrix[i + step][j].setMoved(true);
                        anyMovesMade = true;
                    }
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matrix[i][j] != null) {
                    matrix[i][j].setMoved(false);
                }
            }
        }
        return anyMovesMade;
    }


    public static void main(String[] args) {
        Brett brett = new Brett();
        brett.ziehen();
    }

}
