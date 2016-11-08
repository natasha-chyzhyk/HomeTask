package com.natasha.sourceit.task10;

/**
 * Created by Stas on 08.11.2016.
 */
public interface Game {
    void setDeck(Card[] cards);
    Card[] getDeck();
    void setPlayer(Player player1, int palyerIndex);
    Player getNextPlayer();
    Card getNextCard();
    boolean currentPlayerPlaysCard(Card card);
    boolean currentPlayerPlaysCard(int cardNumberInThePalyersHand);
    boolean currentPlayerPlaysRandomCard();
    int getPlayersScore(int palyerNumber);
    int getPlayersScore(Player player);
    void dealCards();
    boolean hasNextCard();
}

