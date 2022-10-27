package pl.lotto.numberreceiver;

public class NumberReceiverConfiguration {

    public NumberReceiverFacade buildModuleForTests(UserNumbersRepository userNumbersRepository) {
        NumberValidator numberValidator = new NumberValidator();
        UserIdGenerator idGenerator = new UserIdGenerator();
        return new NumberReceiverFacade(numberValidator, userNumbersRepository, idGenerator);
    }
}

