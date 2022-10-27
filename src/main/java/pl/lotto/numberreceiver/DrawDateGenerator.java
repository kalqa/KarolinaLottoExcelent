package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.temporal.TemporalAdjusters.next;

class DrawDateGenerator {
    public LocalDateTime getNextDrawDate() {
//        LocalDateTime.now(clock);
        return LocalDateTime.now()
                .with(next(SATURDAY));
    }

//    private LocalDateTime generateDrawDate() {
//        return LocalDateTime.now();
//    }
}
