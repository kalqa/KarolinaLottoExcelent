package pl.lotto.numberreceiver;

public enum NumberReceiverMessage {

    SUCCESS("Numbers accepted for next draw.");

    NumberReceiverMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
