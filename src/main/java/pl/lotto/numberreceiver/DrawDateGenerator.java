package pl.lotto.numberreceiver;

import java.time.LocalDate;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.temporal.TemporalAdjusters.next;

class DrawDateGenerator {
    public static LocalDate getNextDrawDate() {
        return LocalDate.now().
                with(next(SATURDAY));
    }
}
