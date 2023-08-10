
package com.mycompany.blackjack1;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import com.mycompany.blackjack1.Card.Rank;


public class Hand {

    private ObservableList<Node> arrayOfCards;
    
    private SimpleIntegerProperty totalval = new SimpleIntegerProperty(0);

    private int acenum = 0;
     public Hand(ObservableList<Node> cards) {
        this.arrayOfCards = cards;
    }
 public void getCard(Card card) {
        arrayOfCards.add(card);

        if (card.rank == Rank.ACE) {
            acenum++;
        }

        if((totalval.get() + card.value) > 21 && acenum > 0){
            totalval.set(totalval.get() + card.value - 10);    //then count ace as '1' not '11'
            acenum--;
        }
        else {
            totalval.set(totalval.get() + card.value);
        }
 }
     public SimpleIntegerProperty totalValProperty() {
        return totalval;
    }
    public void reset() {
        arrayOfCards.clear();
        totalval.set(0);
        acenum = 0;
    }


  
}

