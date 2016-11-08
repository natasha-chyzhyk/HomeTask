package com.natasha.sourceit.task10;

import java.util.Random;

/**
 * Created by Stas on 08.11.2016.
 */
public class PlayerImpl implements Player {

    private String name;
    private int size;
    private Card[] hand;

    public PlayerImpl() {
        this("Default");
    }

    public PlayerImpl(String name) {
        this.name = name;
        this.hand = new Card[36];
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getNAme() {
        return this.name;
    }

    @Override
    public void addCard(Card card) {
        hand[size++] = card;
    }

    @Override
    public Card getCard(int indexInTheHand) {
        if(indexInTheHand < size) {
            Card cardToReturn = null;
            cardToReturn = hand[indexInTheHand];
            hand[indexInTheHand] = null;
            hand[indexInTheHand] = hand[size - 1];
            hand[size - 1] = null;
            size--;
            return cardToReturn;
        }
        return null;
    }

    @Override
    public Card getRandomCard() {
        return getCard(new Random().nextInt(size));
    }

    @Override
    public int getHandSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "I'm " + this.name + ". I have " + this.size + " cards.";
    }
}
