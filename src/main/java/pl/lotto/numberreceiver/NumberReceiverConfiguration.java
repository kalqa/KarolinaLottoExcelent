package pl.lotto.numberreceiver;

import pl.lotto.numberreceiver.validation.NumberValidator2;

public class NumberReceiverConfiguration {

    public NumberReceiverFacade buildModuleForTests(UserNumbersRepository userNumbersRepository, IdGenerable idGenerator) {
        NumberValidator2 numberValidator = new NumberValidator2();
        DrawDateGenerator drawDateGenerator = new DrawDateGenerator();
        return new NumberReceiverFacade(numberValidator, userNumbersRepository, idGenerator, drawDateGenerator);
    }
}

