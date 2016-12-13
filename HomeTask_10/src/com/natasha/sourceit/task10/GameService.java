package com.natasha.sourceit.task10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by denis.selutin on 04.11.2016.
 */
public class GameService implements Game {
    private Card[] deck;
    private Player[] players = new Player[10];
    private int currentPlayerNumber = -1;
    private int size;
    private Card lastCard;
    private Player playerPutLastCard;


    public boolean hasNextCard() {
        return size >= 0;
    }

    @Override
    public boolean playersHaveCards() {
        //----  ƒобавили новый метод который провер€ет есть ли у игроков карты  ----
        for (Player pl : players) {
            if (pl != null && (pl.getHandSize() > 0)) {
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean currentPlayerPlaysCard(Card card) {
        //---- »зменена логика проведени€ игры ----
        if(lastCard == null) {
            lastCard = card;
            playerPutLastCard = players[currentPlayerNumber];
        } else {
            players[currentPlayerNumber].addScore(card.getValue() - lastCard.getValue());
            playerPutLastCard.addScore(lastCard.getValue() - card.getValue());
            lastCard = null;
        }
        return false;
    }

    @Override
    public void showResultScores() {
        for (Player p : players) {
            if (p != null) {
                System.out.println(p+" My score = "+p.getScore());
            }
        }
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

    /**
     * ћетод перемешивани€ карт.
     * ћожет вызыватьс€ только дл€ полной колоды
     */
    @Override
    public void mixCards() {
        if (size < deck.length) {
            throw new IllegalStateException("The deck must be full");
        }

        System.out.println("Before mixing: "+ Arrays.toString(deck));

        List<Card> mixedCards = new ArrayList<>(size);
        Random rnd = new Random();
        while (size > 0) {
            int rIndex = rnd.nextInt(size);
            mixedCards.add(deck[rIndex]);
            deck[rIndex] = deck[size-1];
            size --;
        }

        mixedCards.toArray(deck);
        size = deck.length;

        System.out.println("After mixing: "+Arrays.toString(deck));
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
        //---- Ётот метод переписан и исправлен. ƒобавлен кот=нтроль выхода за пределы массива ----
        currentPlayerNumber++;
        if ((currentPlayerNumber >= players.length) || (players[currentPlayerNumber] == null)) {
            currentPlayerNumber = 0;
        }
        return players[currentPlayerNumber];
    }



}
