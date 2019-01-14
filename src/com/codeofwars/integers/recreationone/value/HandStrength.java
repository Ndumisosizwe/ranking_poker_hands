package com.codeofwars.integers.recreationone.value;

/**
 * @author Ndumiso
 * @since 07-Nov-18
 */
public enum HandStrength {
    STRAIGHT_FLUSH(9),
    FOUR_OF_A_KIND(8),
    FULL_HOUSE(7),
    FLUSH(6),
    STRAIGHT(5),
    THREE_OF_A_KIND(4),
    TWO_PAIR(3),
    ONE_PAIR(2),
    HIGH_CARDS(1);

    private Integer numericalStrength;

    HandStrength(Integer numericalStrength) {
        this.numericalStrength = numericalStrength;
    }

    public Integer getNumericalStrength() {
        return numericalStrength;
    }
}
