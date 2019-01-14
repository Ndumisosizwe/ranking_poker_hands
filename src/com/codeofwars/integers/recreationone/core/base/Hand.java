package com.codeofwars.integers.recreationone.core.base;


import com.codeofwars.integers.recreationone.value.HandStrength;

/**
 * A hand of playing getCards.
 *
 * @author Ndumiso
 * @since 07-Nov-18
 */
public interface Hand {

    /**
     * Figures out what type of hand the player has got.
     *
     * @return The strength of the hand.
     */
    HandStrength getHandStrength();

    boolean isStraightFlush();

    boolean isFourOfAKind();

    boolean isFullHouse();

    boolean isFlush();

    boolean isStraight();

    boolean isThreeOfAKind();

    boolean isTwoPair();

    boolean isOnePair();

    boolean isHighCards();
}
