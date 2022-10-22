package pl.lotto.numberreceiver;

import java.util.Collection;

class NumberValidator {

    private final NumberSizeValidator numberSizeValidator = new NumberSizeValidator();
    private final NumberRepetitionValidator numberRepetitionValidator = new NumberRepetitionValidator();
    private final NumberRangeValidator numberRangeValidator = new NumberRangeValidator();

    public boolean validate(Collection<Integer> inputNumbers) {

    return numberSizeValidator.didUserGiveSixNumbers(inputNumbers)
            && numberRepetitionValidator.areNumbersUnique(inputNumbers)
            && numberRangeValidator.areNumbersInRange(inputNumbers);
    }

    private static class NumberRangeValidator {

        static final int MIN_USER_INPUT = 0;
        static final int MAX_USER_INPUT = 100;

        boolean areNumbersInRange(Collection<Integer> inputNumbers) {
            return inputNumbers.stream()
                    .allMatch(number -> number > MIN_USER_INPUT && number < MAX_USER_INPUT);
        }
    }

    private static class NumberSizeValidator {
       static final int HOW_MANY_NUMBERS_FROM_USER = 6;

       boolean didUserGiveSixNumbers(Collection<Integer> inputNumbers) {
            return inputNumbers.size() == HOW_MANY_NUMBERS_FROM_USER;
        }
    }

    private static class NumberRepetitionValidator {

       boolean areNumbersUnique(Collection<Integer> inputNumbers) {
            return (inputNumbers.stream()
                    .distinct()
                    .count() == inputNumbers.size());
        }
    }
}
