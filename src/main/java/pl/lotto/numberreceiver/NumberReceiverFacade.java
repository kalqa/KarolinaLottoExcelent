package pl.lotto.numberreceiver;

import java.util.Collection;
import java.util.List;
import pl.lotto.numberreceiver.dto.NumberReceiverResponseDto;
import pl.lotto.numberreceiver.dto.UserNumbersResponseDto;
import static pl.lotto.numberreceiver.NumberReceiverMessage.FAILED;
import static pl.lotto.numberreceiver.NumberReceiverMessage.SUCCESS;

public class NumberReceiverFacade {

    NumberSizeValidator validator;

    UserNumbersRepository userNumbersRepository;

    NumberReceiverFacade(NumberSizeValidator validator, UserNumbersRepository userNumbersRepository) {
        this.validator = validator;
        this.userNumbersRepository = userNumbersRepository;
    }

    public NumberReceiverResponseDto inputNumbers(Collection<Integer> inputNumbers) {
        if (validator.doesUserGaveSixNumbers(inputNumbers)) {
            userNumbersRepository.save(inputNumbers);
            return new NumberReceiverResponseDto(SUCCESS.name());
        }
        return new NumberReceiverResponseDto(FAILED.name());
    }

    public UserNumbersResponseDto userNumbers() {
        Collection<Integer> numbers = userNumbersRepository.findAll();
        return new UserNumbersResponseDto(numbers);
    }
}
