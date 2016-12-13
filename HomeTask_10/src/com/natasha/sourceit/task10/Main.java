package com.natasha.sourceit.task10;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //--- ???? ?????? ???? ---
        Card[] allCards = new Card[36];
        int index = 0;
        for(Card.Mast mast : Card.Mast.values()) { //?????????? ?????
            for (int i = 6; i <= 10; i++) {
                allCards[index++] = CardImpl.createCommonCard(mast, i);
            }
            //jack
            allCards[index++] = CardImpl.createUncommonCard(mast, Card.UncommonName.VALET);
            //queen
            allCards[index++] = CardImpl.createUncommonCard(mast, Card.UncommonName.DAMA);
            //king
            allCards[index++] = CardImpl.createUncommonCard(mast, Card.UncommonName.KING);
            //ace
            allCards[index++] = CardImpl.createUncommonCard(mast, Card.UncommonName.TUZ);
        }


        Game game = new GameService();
        Player player1 = new PlayerImpl("p1");
        Player player2 = new PlayerImpl("p2");
        Player player3 = new PlayerImpl("P3");

        game.setDeck(allCards);
        game.mixCards();
        game.setPlayer(player1, 0);
        game.setPlayer(player2, 1);
        game.setPlayer(player3, 2);

        game.dealCards();

        while(game.playersHaveCards()) {
            Player currentPlayer = game.getNextPlayer();
            Card card = currentPlayer.getRandomCard();
            if (card != null) {
                System.out.println("Player " + currentPlayer + " is playing card " + card);
                game.currentPlayerPlaysCard(card);
                System.out.println("--- > "+currentPlayer+"score = "+currentPlayer.getScore());

                Card anotherCard = game.getNextCard();
                if (anotherCard != null) {
                    currentPlayer.addCard(anotherCard);
                }
            }
        }

        //---- печатаем результаты игры ----
        System.out.println("----  Game finished  ----");
        game.showResultScores();
    }

}
