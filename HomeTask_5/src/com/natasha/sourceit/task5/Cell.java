package com.natasha.sourceit.task5;

import java.util.Random;

/**
 * Created by Stas on 20.10.2016.
 */
public class Cell {
    private static Random rnd = new Random();

    private boolean hasMine;
    private boolean checked;

    public static Cell createRandomlyMined() {
        Cell c = new Cell();
       // c.setHasMine(rnd.nextBoolean());
        c.hasMine = rnd.nextBoolean();
        return c;
    }

    public static Cell createProbablyMined(float probability) {
        Cell c = new Cell();
        c.hasMine = (rnd.nextFloat() < probability);
        return c;
    }

    public String toString() {

        return hasMine ? "M" : " ";
    }

    /*
        <тип> <имя переменной>
        <видимость> <возвр. знач> <имя>([параметры]) {

        }
        protected void myMethod() {}
        public String myMethod2() {
            return "";
        }
        public String myMethod3(int x, int y) {
            return "" + x + " " + y;
        }

     */

    public boolean checkMine() throws Exception {
        if (checked) {
            throw new Exception("Already checked");
        }
        checked = true;
        return hasMine;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setHasMine(boolean hasMine) {
        this.hasMine = hasMine;
    }
}
