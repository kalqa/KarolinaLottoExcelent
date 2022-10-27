package pl.lotto.numberreceiver;

import java.time.LocalDate;

enum NumberReceiverMessage {

    SUCCESS("Numbers accepted for next draw.","" , DrawDateGenerator.getNextDrawDate()),
    FAILED("Failed to accept numbers.", "");


    private String ticketId;

    NumberReceiverMessage(String message, String ticketId, LocalDate drawDate) {
        this.ticketId = ticketId;

    }

    NumberReceiverMessage(String message, String failureReason) {
    }

}
//tu w success ustawić info do usera o przyjęciu liczb, tickecie i dacie nastepnego losowania
//w failed dać zwrotkę co poszło nie tak