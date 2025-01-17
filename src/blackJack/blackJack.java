package blackJack;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class blackJack {
    private class Card {
        public enum Rank{
            ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
            EIGHT, NINE, TEN, JACK, QUEEN, KING, JOKER;
        }

        //small and big only for jokers
        public enum Suit
        {
            CLUB,
            DIAMOND,
            SPADE,
            HEART,
            SMALL,
            BIG;
        }

        private final Rank aRank;
        private final Suit aSuit;

        Card(Rank pRank, Suit pSuit){
            if(pRank == Rank.JOKER){
                //Handling invalid input
                if(pSuit != Suit.SMALL && pSuit != Suit.BIG){
                    throw new IllegalArgumentException("A joker does not have a regular suit.");
                }
            }
            else if(pSuit == Suit.SMALL || pSuit == Suit.BIG){
                throw new IllegalArgumentException("A non-joker can only have suit club, diamond, spade or heart.");
            }
            this.aRank = pRank;
            this.aSuit = pSuit;
        }

        public String toString(){
            return this.aRank.name().toLowerCase() + " of " + this.aSuit.name().toLowerCase();
        }

        public String getImagePath() {
            return "./cards/" + this.toString() + ".png";
        }

        public boolean isAce(){
            return this.aRank == Rank.ACE;
        }

        public int getValue(){
            int value = this.aRank.ordinal() + 1;
            if(value == 1)
                return 11;
            else
                return Math.min(value, 10);
        }
    }
}
