package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;
import pl.lotto.numberreceiver.dto.NumberReceiverResponseDto;
import pl.lotto.numberreceiver.dto.UserNumbersResponseDto;
import pl.lotto.numberreceiver.validation.NumberValidator2;
import pl.lotto.numberreceiver.validation.ValidationResult;
import static pl.lotto.numberreceiver.dto.NumberReceiverResponseDto.failure;
import static pl.lotto.numberreceiver.dto.NumberReceiverResponseDto.success;

public class NumberReceiverFacade {

    NumberValidator2 validator;
    UserNumbersRepository userNumbersRepository;
    IdGenerable idGenerator;
    DrawDateGenerator drawDateGenerator;

    NumberReceiverFacade(NumberValidator2 validator, UserNumbersRepository userNumbersRepository, IdGenerable idGenerator, DrawDateGenerator drawDateGenerator) {
        this.validator = validator;
        this.userNumbersRepository = userNumbersRepository;
        this.idGenerator = idGenerator;
        this.drawDateGenerator = drawDateGenerator;
    }

    public NumberReceiverResponseDto inputNumbers(Collection<Integer> inputNumbers) {
        ValidationResult validation = validator.validate(inputNumbers);
        if (validation.wasError()) {
            return failure(validation);
        }
        String uniqueId = idGenerator.createIdentifier();
        userNumbersRepository.save(uniqueId, inputNumbers);
        LocalDateTime drawDate = drawDateGenerator.getNextDrawDate();
        return success(uniqueId, drawDate);
    }

    private UUID generateUniqueIdForUser() {
        return UUID.randomUUID();
    }

    public UserNumbersResponseDto userNumbers() {
        Collection<Integer> numbers = userNumbersRepository.findAll();
        return new UserNumbersResponseDto(numbers);
    }
}
