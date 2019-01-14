package com.codeofwars.integers.recreationone.value;

/**
 * @author Ndumiso
 * @since 07-Nov-18
 */
public enum CardRank {

    A(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7),
    EIGHT(8), NINE(9), T(10), J(11), Q(12), K(13);

    private Integer numericValue;

    CardRank(Integer numericValue) {
        this.numericValue = numericValue;
    }

    public int getNumericValue() {
        return numericValue;
    }
}
