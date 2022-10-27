package pl.lotto.numberreceiver;

import java.util.UUID;

class UserIdGenerator {

    public String createIdentifier() {
        return UUID.randomUUID().toString();

    }
}
