package pl.lotto.numberreceiver;

import java.util.Collection;
import pl.lotto.numberreceiver.dto.NumberReceiverResponseDto;
import static pl.lotto.numberreceiver.NumberReceiverMessage.FAILED;
import static pl.lotto.numberreceiver.NumberReceiverMessage.SUCCESS;

public class NumberReceiverFacade {

    NumberSizeValidator validator;

    NumberReceiverFacade(NumberSizeValidator numberSizeValidator) {
        this.validator = numberSizeValidator;
    }

    public NumberReceiverResponseDto inputNumbers(Collection<Integer> inputNumbers) {
        if (validator.doesUserGaveSixNumbers(inputNumbers)) {
            return new NumberReceiverResponseDto(SUCCESS.name());
        }
        return new NumberReceiverResponseDto(FAILED.name());
    }
}
