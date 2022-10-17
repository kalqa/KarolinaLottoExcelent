package pl.lotto.numberreceiver;

public class NumberReceiverConfiguration {

    public NumberReceiverFacade buildModuleForTests() {
        NumberSizeValidator numberValidator = new NumberSizeValidator();
        return new NumberReceiverFacade(numberValidator);
    }
}
