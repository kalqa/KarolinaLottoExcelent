package pl.lotto.numberreceiver;

import java.util.UUID;

class UserIdGenerator implements IdGenerable {

    @Override
    public String createIdentifier() {
        return UUID.randomUUID().toString();
    }
}
