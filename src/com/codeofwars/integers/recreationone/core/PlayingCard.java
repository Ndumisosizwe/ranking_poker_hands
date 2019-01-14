package com.codeofwars.integers.recreationone.core;


import com.codeofwars.integers.recreationone.value.CardRank;
import com.codeofwars.integers.recreationone.value.Suit;

import java.util.Objects;

/**
 * @author Ndumiso
 * @since 07-Nov-18
 */
public class PlayingCard implements Comparable<PlayingCard> {

    private CardRank cardRank;

    private Suit suit;

    public PlayingCard(CardRank cardRank, Suit suit) {
        this.cardRank = cardRank;
        this.suit = suit;
    }

    public CardRank getCardRank() {
        return cardRank;
    }

    public void setCardRank(CardRank cardRank) {
        this.cardRank = cardRank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayingCard that = (PlayingCard) o;
        return cardRank == that.cardRank &&
                suit == that.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardRank, suit);
    }

    @Override
    public String toString() {
        return "{" + cardRank + " : " + suit + '}';
    }

    @Override
    public int compareTo(PlayingCard o) {
        if (this.equals(o))
            return 0;
        else
            return Integer.compare(this.cardRank.getNumericValue(), o.getCardRank().getNumericValue());
    }
}
