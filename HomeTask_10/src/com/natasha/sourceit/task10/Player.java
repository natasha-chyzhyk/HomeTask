package com.natasha.sourceit.task10;

/**
 * Created by denis.selutin on 04.11.2016.
 */
public interface Player {
    String getNAme();
    void addCard(Card card);
    Card getCard(int indexInTheHand);
    Card getRandomCard();
    int getHandSize();

    void resetScore();
    void addScore(int deltaScore);
    int getScore();
}
