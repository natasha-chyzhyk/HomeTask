package com.natasha.sourceit.task10;

/**
 * Created by denis.selutin on 04.11.2016.
 */
public interface Game {
    void setDeck(Card[] cards);
    void mixCards();
    Card[] getDeck();
    void setPlayer(Player player1, int palyerIndex);
    Player getNextPlayer();
    Card getNextCard();
    boolean currentPlayerPlaysCard(Card card);
    boolean currentPlayerPlaysCard(int cardNumberInThePalyersHand);
    boolean currentPlayerPlaysRandomCard();
    void dealCards();
    boolean hasNextCard();
    boolean playersHaveCards();
    void showResultScores();
}
