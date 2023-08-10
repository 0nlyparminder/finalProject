package com.mycompany.blackjack1;

import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class Card extends Parent {

    private static final int WIDTH = 90;
    private static final int HEIGHT = 130;
   
    
    enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES;
    }
     public final Suit suit;
    enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(10), QUEEN(10), KING(10), ACE(11);

        final int cardValue;
        Rank(int value) {
            this.cardValue = value;
        }
    }
    public final Rank rank;
    public final int value;

   

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.value = rank.cardValue;

        Rectangle bg = new Rectangle(WIDTH, HEIGHT);
        bg.setArcWidth(10);
        bg.setArcHeight(10);
        bg.setFill(Color.WHITE);

        Text text1 = new Text(toString());
        getChildren().add(new StackPane(bg,text1));
    }

    @Override
    public String toString() {
        return value + " of " + suit.toString();
    }
}

