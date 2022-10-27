package pl.lotto.numberreceiver.validation;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import static pl.lotto.numberreceiver.validation.NumberValidationError.NOT_IN_RANGE;
import static pl.lotto.numberreceiver.validation.NumberValidationError.NOT_SIX_NUMBERS;
import static pl.lotto.numberreceiver.validation.NumberValidationError.NOT_UNIQUE;

public class NumberValidator2 {

    static final int MIN_USER_INPUT = 0;
    static final int MAX_USER_INPUT = 100;
    static final int HOW_MANY_NUMBERS_FROM_USER = 6;

    List<NumberValidationError> errors = new LinkedList<>();

    public ValidationResult validate(Collection<Integer> inputNumbers) {
        if (!didUserGiveSixNumbers(inputNumbers)) {
            errors.add(NOT_SIX_NUMBERS);
        }
        if (!areNumbersUnique(inputNumbers)) {
            errors.add(NOT_UNIQUE);
        }
        if (!areNumbersInRange(inputNumbers)) {
            errors.add(NOT_IN_RANGE);
        }
        String message = String.join(",", createMessage());
        boolean wasError = !errors.isEmpty();
        return new ValidationResult(message, wasError);
    }

    private boolean didUserGiveSixNumbers(Collection<Integer> inputNumbers) {
        return inputNumbers.size() == HOW_MANY_NUMBERS_FROM_USER;
    }

    private boolean areNumbersUnique(Collection<Integer> inputNumbers) {
        return (inputNumbers.stream()
                .distinct()
                .count() == inputNumbers.size());
    }

    private boolean areNumbersInRange(Collection<Integer> inputNumbers) {
        return inputNumbers.stream()
                .allMatch(number -> number > MIN_USER_INPUT && number < MAX_USER_INPUT);
    }

    private List<String> createMessage() {
        return errors.stream()
                .map(NumberValidationError::getMessage)
                .collect(Collectors.toList());
    }

}
