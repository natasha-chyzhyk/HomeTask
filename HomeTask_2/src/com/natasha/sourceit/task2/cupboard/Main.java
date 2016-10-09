package com.natasha.sourceit.task2.cupboard;

public class Main {

    public static void main(String[] args) {
        Cupboard cupboard = new Cupboard();
        cupboard.setDoors(new Door(1.5f, 1.2f, Material.WOOD), new Door(2.2f, 1.2f, Material.DSP), new Door(2.5f, 1.5f, Material.GLASS));

        cupboard.setDoors(new Door[]{ new Door(2.5f, 1.2f, Material.WOOD), new Door(2.5f, 1, Material.WOOD), new Door(2.5f, 1.2f, Material.WOOD)});

        for (int i=0; i<cupboard.getDoorsNumber(); i++) {
            System.out.println("fdfdfd "+i+" двери шкафа: " +cupboard.getDoor(i).getHeight()+ " ширина: " +cupboard.getDoor(i).getWidth());
        }



    }
}
