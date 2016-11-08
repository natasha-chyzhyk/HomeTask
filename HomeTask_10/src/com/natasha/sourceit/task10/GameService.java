package com.natasha.sourceit.task10;

/**
 * Created by Stas on 08.11.2016.
 */
public class GameService implements Game {
    private Card[] deck;
    private Player[] players = new Player[10];
    private int[] playerScore = new int[10];
    private int currentPlayerNumber = -1;
    private int size;
    private Card lastCard;


    public boolean hasNextCard() {
        return size >= 0;
    }

    @Override
    public boolean currentPlayerPlaysCard(Card card) {
        if(lastCard == null) {
            lastCard = card;
        } else {
            if(lastCard.getValue() < card.getValue()) {
                playerScore[currentPlayerNumber]++;
            } else {
                playerScore[currentPlayerNumber]--;
            }
            lastCard = null;
        }
        return false;
    }

    @Override
    public boolean currentPlayerPlaysCard(int cardNumberInThePalyersHand) {
        return false;
    }

    @Override
    public boolean currentPlayerPlaysRandomCard() {
        return false;
    }

    @Override
    public void dealCards() {
        for(int i = 0; i < 6; i++) {
            for (Player p : players) {
                if (p != null) {
                    p.addCard(getNextCard());
                }
            }
        }
    }

    @Override
    public Card getNextCard() {
        if(size != 0) {
            Card card = deck[size - 1];
            deck[size - 1] = null;
            size--;
            return card;
        } else {
            return null;
        }
    }

    @Override
    public void setDeck(Card[] cards) {
        this.deck = cards;
        this.size = cards.length;
    }

    @Override
    public Card[] getDeck() {
        return this.deck;
    }

    @Override
    public void setPlayer(Player player1, int palyerIndex) {
        players[palyerIndex] = player1;
    }

    @Override
    public Player getNextPlayer() {
        if(players[currentPlayerNumber + 1] == null) {
            currentPlayerNumber = -1;
        }
        return players[++currentPlayerNumber];
    }

    @Override
    public int getPlayersScore(int palyerNumber) {
        return playerScore[palyerNumber];
    }

    @Override
    public int getPlayersScore(Player player) {
        for(int i = 0; i < players.length; i++) {
            Player current = players[i];
            if(player.equals(current)) {
                return playerScore[i];
            }
        }
        return 0;
    }

}

