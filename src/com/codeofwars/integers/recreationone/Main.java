package com.codeofwars.integers.recreationone;

import com.codeofwars.integers.recreationone.core.PokerHand;

public class Main {

    public static void main(String[] args) {
        PokerHand hand = new PokerHand("KS TH 5S JS TS");
        System.out.println(hand.getHandStrength());
    }
}
