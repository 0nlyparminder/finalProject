package com.mycompany.blackjack1;

import com.mycompany.blackjack1.Card.Rank;
import com.mycompany.blackjack1.Card.Suit;


public class Deck {

    private Card[] cards = new Card[52];

    public Deck() {
        refill();
    }
 public final void refill() {
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards[i++] = new Card(suit, rank);
            }
        }
       
    }

    public Card drawCard() {
        Card randomCard = null;
        while (randomCard == null) {
        int i = (int)(Math.random()*cards.length);
        randomCard = cards[i];
        cards[i] = null;
        }
        return randomCard;
    }
   
}

