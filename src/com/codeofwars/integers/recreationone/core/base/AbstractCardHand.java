package com.codeofwars.integers.recreationone.core.base;

import com.codeofwars.integers.recreationone.core.PlayingCard;
import com.codeofwars.integers.recreationone.exception.FiveCardDrawException;
import com.codeofwars.integers.recreationone.value.CardRank;
import com.codeofwars.integers.recreationone.value.Suit;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * @author Ndumiso
 * @since 07-Nov-18
 */
public abstract class AbstractCardHand implements Hand {

    private int size;

    private Set<PlayingCard> cards;

    public AbstractCardHand(Set<PlayingCard> cards) {
        this.size = cards.size();
        this.cards = cards;
    }

    public AbstractCardHand(String cards) {
        Set<PlayingCard> playingCards = splitStringHandIntoCardTypes(cards);
        this.size = playingCards.size();
        this.cards = playingCards;
    }

    protected int getSize() {
        return this.size;
    }

    protected Set<PlayingCard> getCards() {
        return this.cards;
    }

    @Override
    public String toString() {
        return cards + "";
    }


    private Set<PlayingCard> splitStringHandIntoCardTypes(String pokerHand) {
        HashSet<PlayingCard> playingCards = new HashSet<>();
        CardRank[] cardRanks = CardRank.values();
        Suit[] suits = Suit.values();
        String[] cards = pokerHand.split(" ");
        Arrays.stream(cards).forEach(c -> {
            CardRank tempCardRank = null;
            Suit tempSuit = null;
            String[] rankBySuit = c.split("");
            if (rankBySuit[0].matches("\\d+")) {
                List<CardRank> findNumericRank = Arrays.stream(cardRanks)
                        .filter(cr -> cr.getNumericValue() == Integer.parseInt(rankBySuit[0])).collect(Collectors.toList());
                if (!findNumericRank.isEmpty()) {
                    tempCardRank = findNumericRank.get(0);
                }
            } else {
                List<CardRank> findNormalRank = Arrays.stream(cardRanks)
                        .filter(cr -> cr.toString().equalsIgnoreCase(rankBySuit[0]))
                        .collect(Collectors.toList());
                if (!findNormalRank.isEmpty()) {
                    tempCardRank = findNormalRank.get(0);
                }
            }
            List<Suit> findSuit = Arrays.stream(suits).filter(cr -> cr.toString().equalsIgnoreCase(rankBySuit[1])).collect(Collectors.toList());
            if (!findSuit.isEmpty())
                tempSuit = findSuit.get(0);
            playingCards.add(new PlayingCard(tempCardRank, tempSuit));
        });
        System.out.println(playingCards);
        return playingCards;
    }

    protected boolean isSequential() {
        if (this.getSize() >= 2) {
            List<PlayingCard> hand = this.getCards()
                    .stream()
                    .sorted()
                    .collect(toList());
            for (int i = 0; i < hand.size() - 1; i++) {
                int currentRank = hand.get(i).getCardRank().getNumericValue();
                int nextRank = hand.get(i + 1).getCardRank().getNumericValue();
                if ((currentRank + 1) != nextRank)
                    return false;
            }
        } else {
            throw new FiveCardDrawException("Invalid hand size.");
        }

        return true;
    }

    protected boolean hasTheSameSuitOnAllCards() {
        PlayingCard firstCard = this.getCards().stream().findFirst().get();
        for (PlayingCard c : this.getCards()) {
            if (c.getSuit() != firstCard.getSuit())
                return false;
        }
        return true;
    }

    protected boolean hasTheSameRankOnAllCards() {
        PlayingCard firstCard = this.getCards().stream().findFirst().get();
        for (PlayingCard c : this.getCards()) {
            if (c.getCardRank() != firstCard.getCardRank())
                return false;
        }
        return true;
    }

    protected boolean hasNumberOfPairsOfTheSameRank(int numberOfPairs) {
        Map<CardRank, List<PlayingCard>> groupedByRank = getHandGroupedByRank();
        return groupedByRank.values().stream().filter(sameRankGroup -> sameRankGroup.size() == 2).count() == numberOfPairs;
    }

    protected boolean hasOneTripletOfTheSameRank() {
        Map<CardRank, List<PlayingCard>> groupedByRank = getHandGroupedByRank();
        return groupedByRank.values().stream().filter(sameRankGroup -> sameRankGroup.size() == 3).count() == 1;
    }

    protected boolean hasFourOfTheSameRank() {
        return this.getHandGroupedByRank().values()
                .stream().filter(sameRankGroup -> sameRankGroup.size() == 4).count() == 1;
    }

    private Map<CardRank, List<PlayingCard>> getHandGroupedByRank() {
        return this.getCards().stream()
                .collect(groupingBy(PlayingCard::getCardRank));
    }

    protected boolean hasNumberOfDistinctRanks(int numberOfUniqueRanks) {
        return this.getHandGroupedByRank().values()
                .stream().filter(sameRankGroup -> sameRankGroup.size() == 1).count() == numberOfUniqueRanks;
    }


}
