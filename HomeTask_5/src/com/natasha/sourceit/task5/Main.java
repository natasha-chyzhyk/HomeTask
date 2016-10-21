package com.natasha.sourceit.task5;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static final int N_ROWS = 5;
    public static final int N_COLS = 6;

    public static void main(String[] args) {
        /*System.out.println("----------" + "Task_1" + "-----------");
        Task_1 task1 = new Task_1();
        int[] array1 = new int[10];
        task1.print(array1);
        System.out.println();

        System.out.println("----------" + "Task_2" + "-----------");
        Task_2 task2 = new Task_2();
        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        task2.change(array2);

        System.out.println("----------" + "Task_3" + "-----------");
        Task_3 task3 = new Task_3();
        task3.array2d_1();
        task3.array2d_2();

        System.out.println("----------" + "Task_4" + "-----------");
        Task_4 task4 = new Task_4();
        int[] array4 = new int[11];
        task4.sequence(array4);
        System.out.println();

        System.out.println("----------" + "Task_5" + "-----------");
        Task_5 task5 = new Task_5();
        int[] array5 = new int[999999];
        task5.ticket(array5);
        task5.ticket1(array5);

        System.out.println("----------" + "Task_6" + "-----------");
        /*
            0    1    2    3
         ---------------------
  i   0  | 1  | 2  | 3  | 4  |
         ---------------------
      1  | 5  | 6  | 7  | 8  |
         ---------------------
      3  | 9  | 10 | 11 | 12 |
         ---------------------
      3  | 13 | 14 | 15 | 16 |
         ---------------------
         */

        /*Cell[][] field = {
                {c(true), c(false), c(true), c(false)},
                {c(false), c(false), c(true), c(false)},
                {c(false), c(false), c(false), c(false)},
                {c(false), c(false), c(true), c(false)}
        };

        Cell[][] field2 = {
                {c(1), c(0), c(0), c(0)},
                {c(0), c(0), c(1), c(0)},
                {c(1), c(0), c(0), c(0)},
                {c(0), c(1), c(0), c(0)}
        };*/

        Cell[][] field3 = new Cell[N_ROWS][N_COLS];
        for (int i = 0; i < field3.length; i++) {
            for (int j = 0; j < field3[i].length; j++) {
                field3[i][j] = Cell.createProbablyMined(0.15f);
            }
        }
        System.out.println(Arrays.deepToString(field3));

        Player player = new Player();


        int nCells = N_ROWS * N_COLS;
        int nPlayedCells = 0;
        do {
            player.moveNext(N_ROWS, N_COLS);
            try {
                boolean boom = player.play(field3);
                nPlayedCells ++;
                if (boom) {
                    System.out.println(String.format("Cell[%d][%d] - You are blasted!!! GAme over!", player.getX(), player.getY()));
                    return;
                } else {
                    System.out.println(String.format("Cell[%d][%d] has been checked", player.getX(), player.getY()));
                }
            } catch(Exception e) {
                System.out.println(String.format("Cell[%d][%d] - %s", player.getX(), player.getY(), e.getMessage()));
            }
        } while (nPlayedCells < nCells); // Граничное условие на случай отсутствия мин.
        System.out.println("No mines in the field. You win!");





    }

        /*public static Cell c(boolean value) {
            Cell cell = new Cell();
            cell.setHasMine(value);
            return cell;
        }

        public static Cell c(int value) {
            Cell cell = new Cell();
            cell.setHasMine(value == 1);
            return cell;
        }

        public boolean moveTo(Player player, Cell cell) {
            // Проверить, есть ли у нас мину
            // Если положительный - печать игра окончена сообщение
            // В противном случае - положение и печать ООК сообщение об изменении игрока
            // Результат состояния игрока (живой или нет)

            //verify whether we have a mine
            //if positive - print game over message
            // otherwise - change player's position and print oOK message
            //the result is a player's state(alive or not)
            System.out.println("One Two Three");
            return true;
        }*/
    }

