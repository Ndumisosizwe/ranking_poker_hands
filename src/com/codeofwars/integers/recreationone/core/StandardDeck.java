package com.codeofwars.integers.recreationone.core;

import com.codeofwars.integers.recreationone.core.base.DeckOfCards;
import com.codeofwars.integers.recreationone.core.base.Hand;
import com.codeofwars.integers.recreationone.value.CardRank;
import com.codeofwars.integers.recreationone.value.Suit;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A standard deck of 52 Cards.
 *
 * @author Ndumiso
 * @since 07-Nov-18
 */
public final class StandardDeck implements DeckOfCards {

    private static final int SIZE_OF_STANDARD_DECK = 52;

    private List<PlayingCard> cards;

    {
        //Initialize deck during JVM class-loading.
        this.cards = this.init();
    }

    @Override
    public void shuffle() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Shuffling...");
            Collections.shuffle(this.cards);
        }
    }

    @Override
    public Hand dealCards(int numberOfCardsToDeal) {
        // Take top X cards from the shuffled deck, where X is numberOfCardsToDeal.
        return new PokerHand(this.cards.stream().limit(numberOfCardsToDeal).collect(Collectors.toSet()));
    }

    @Override
    public int size() {
        return this.cards.size();
    }

    @Override
    public Set<PlayingCard> getCards() {
        List<PlayingCard> copy = new ArrayList<>(cards);
        Collections.copy(copy, this.cards);
        return new HashSet<>(copy);
    }


    private List<PlayingCard> init() {
        List<PlayingCard> cards = new ArrayList<>();
        Arrays.stream(Suit.values()).forEach(s -> Arrays.stream(CardRank.values()).forEach(r -> cards.add(new PlayingCard(r, s))));
        return cards;
    }

    @Override
    public String toString() {
        return this.cards + "";
    }
}
