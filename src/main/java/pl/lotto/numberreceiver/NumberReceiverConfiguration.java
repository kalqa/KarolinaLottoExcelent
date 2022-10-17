package pl.lotto.numberreceiver;

public class NumberReceiverConfiguration {

    public NumberReceiverFacade buildModuleForTests(UserNumbersRepository userNumbersRepository) {
        NumberSizeValidator numberValidator = new NumberSizeValidator();
        return new NumberReceiverFacade(numberValidator, userNumbersRepository);
    }
}
