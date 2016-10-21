package com.natasha.sourceit.task5;

import java.util.Random;

/**
 * Created by Stas on 20.10.2016.
 */
public class Player {
    private static Random rnd = new Random();

    private int x = -1;
    private int y = -1;

    /**
     * ѕеремещаем игрока на случайную €чейку в пределах игрового пол€
     * @param nRows
     * @param nCols
     */
    public void moveNext(int nRows, int nCols) {
        x = rnd.nextInt(nRows);
        y = rnd.nextInt(nCols);
    }

    /**
     * √оворим игроку сиграть €чейку из пол€ по его текущим координатам
     * @param field
     * @return
     */
    public boolean play(Cell[][] field) throws Exception {

        return field[x][y].checkMine();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
