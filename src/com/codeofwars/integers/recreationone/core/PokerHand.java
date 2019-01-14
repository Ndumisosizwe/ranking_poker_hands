package com.codeofwars.integers.recreationone.core;


import com.codeofwars.integers.recreationone.core.base.AbstractCardHand;
import com.codeofwars.integers.recreationone.exception.FiveCardDrawException;
import com.codeofwars.integers.recreationone.value.HandStrength;

import java.util.Set;

/**
 * xs
 *
 * @author Ndumiso
 * @since 07-Nov-18
 */
public class PokerHand extends AbstractCardHand {

    public PokerHand(Set<PlayingCard> cards) {
        super(cards);
    }

    public PokerHand(String cards) {
        super(cards);
    }

    @Override
    public HandStrength getHandStrength() {
        if (isStraightFlush())
            return HandStrength.STRAIGHT_FLUSH;
        else if (isFourOfAKind())
            return HandStrength.FOUR_OF_A_KIND;
        else if (isFullHouse())
            return HandStrength.FULL_HOUSE;
        else if (isFlush())
            return HandStrength.FLUSH;
        else if (isStraight())
            return HandStrength.STRAIGHT;
        else if (isThreeOfAKind())
            return HandStrength.THREE_OF_A_KIND;
        else if (isTwoPair())
            return HandStrength.TWO_PAIR;
        else if (isOnePair())
            return HandStrength.ONE_PAIR;
        else if (isHighCards())
            return HandStrength.HIGH_CARDS;
        else
            throw new FiveCardDrawException("Could not determine valid poker hand.");
    }

    @Override
    public boolean isStraightFlush() {
        return this.isSequential() && hasTheSameSuitOnAllCards();
    }

    @Override
    public boolean isFourOfAKind() {
        return this.hasFourOfTheSameRank() && this.hasNumberOfDistinctRanks(1);
    }

    @Override
    public boolean isFullHouse() {
        return this.hasOneTripletOfTheSameRank() && hasNumberOfPairsOfTheSameRank(1);
    }

    @Override
    public boolean isFlush() {
        return this.hasTheSameSuitOnAllCards() && !this.isSequential();
    }

    @Override
    public boolean isStraight() {
        return this.isSequential() && !hasTheSameSuitOnAllCards();
    }

    @Override
    public boolean isThreeOfAKind() {
        return (hasOneTripletOfTheSameRank() && this.hasNumberOfDistinctRanks(2));
    }


    @Override
    public boolean isTwoPair() {
        return (hasNumberOfPairsOfTheSameRank(2) && this.hasNumberOfDistinctRanks(1));
    }

    @Override
    public boolean isOnePair() {
        //ONE pair of the same rank and 3 unique other ranks.
        return (hasNumberOfPairsOfTheSameRank(1) && this.hasNumberOfDistinctRanks(3));
    }

    @Override
    public boolean isHighCards() {
        return (!this.isSequential() && !hasTheSameSuitOnAllCards() && !this.hasTheSameRankOnAllCards());
    }


}
