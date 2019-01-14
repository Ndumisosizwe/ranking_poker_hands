package com.codeofwars.integers.recreationone.core.base;

import com.codeofwars.integers.recreationone.core.PlayingCard;

import java.util.Set;

/**
 * @author Ndumiso
 * @since 07-Nov-18
 */
public interface DeckOfCards {

    /**
     * Shuffles the deck of getCards.
     */
    void shuffle();

    /**
     * Deals getCards to player(s).
     *
     * @return a single hand.
     */
    Hand dealCards(int numberOfCardsPerPlayer);

    /**
     * The number of getCards in this deck.
     *
     * @return int
     */
    int size();

    /**
     * Gives you cards in the deck.
     *
     * @return the cards in this deck.
     */
    Set<PlayingCard> getCards();
}
