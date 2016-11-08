package com.natasha.sourceit.task10;

/**
 * Created by Stas on 08.11.2016.
 */
public interface Player {
    String getNAme();
    void addCard(Card card);
    Card getCard(int indexInTheHand);
    Card getRandomCard();
    int getHandSize();
}
