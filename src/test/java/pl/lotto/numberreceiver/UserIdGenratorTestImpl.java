package pl.lotto.numberreceiver;

import java.util.UUID;

public class UserIdGenratorTestImpl implements IdGenerable {
    @Override
    public String createIdentifier() {
        return UUID.randomUUID().toString();
    }
}
