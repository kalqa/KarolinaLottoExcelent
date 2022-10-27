package pl.lotto.numberreceiver;

import java.util.Collection;

import pl.lotto.numberreceiver.dto.NumberReceiverResponseDto;
import pl.lotto.numberreceiver.dto.UserNumbersResponseDto;
import static pl.lotto.numberreceiver.NumberReceiverMessage.FAILED;
import static pl.lotto.numberreceiver.NumberReceiverMessage.SUCCESS;

public class NumberReceiverFacade {

    NumberValidator validator;
    UserNumbersRepository userNumbersRepository;
    UserIdGenerator idGenerator;

    NumberReceiverFacade(NumberValidator validator, UserNumbersRepository userNumbersRepository, UserIdGenerator idGenerator) {
        this.validator = validator;
        this.userNumbersRepository = userNumbersRepository;
        this.idGenerator = idGenerator;
    }

    public NumberReceiverResponseDto inputNumbers(Collection<Integer> inputNumbers) {
        if (validator.validate(inputNumbers)) {
            userNumbersRepository.save(idGenerator.createIdentifier(), inputNumbers);
            return new NumberReceiverResponseDto(SUCCESS.name());
        }
        return new NumberReceiverResponseDto(FAILED.name());
    }

    public UserNumbersResponseDto userNumbers() {
        Collection<Integer> numbers = userNumbersRepository.findAll();
        return new UserNumbersResponseDto(numbers);
    }
}
