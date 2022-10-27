package pl.lotto.numberreceiver.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import pl.lotto.numberreceiver.validation.ValidationResult;
import static pl.lotto.numberreceiver.NumberReceiverMessage.SUCCESS;

public record NumberReceiverResponseDto(String message, String uniqueId, LocalDateTime drawDate) {

    public static NumberReceiverResponseDto failure(ValidationResult message) {
        return new NumberReceiverResponseDto(message.message(), null, null);
    }

    public static NumberReceiverResponseDto success(String uniqueId, LocalDateTime drawDate) {
        return new NumberReceiverResponseDto(SUCCESS.getMessage(), uniqueId, drawDate);
    }
}
