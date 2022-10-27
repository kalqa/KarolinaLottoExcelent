package pl.lotto.numberreceiver.validation;

enum NumberValidationError {

    NOT_IN_RANGE("not in range"),
    NOT_SIX_NUMBERS("six numbers"),
    NOT_UNIQUE("not unique");

    private final String message;

    NumberValidationError(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }
}
