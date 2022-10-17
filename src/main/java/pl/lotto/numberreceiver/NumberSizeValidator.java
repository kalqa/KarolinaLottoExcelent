package pl.lotto.numberreceiver;

import java.util.Collection;

class NumberSizeValidator {

    public static final int MAXIMAL_NUMBERS_FROM_USER = 6;

    public boolean doesUserGaveSixNumbers(Collection<Integer> inputNumbers) {
        return inputNumbers.size() == MAXIMAL_NUMBERS_FROM_USER;
    }
}
