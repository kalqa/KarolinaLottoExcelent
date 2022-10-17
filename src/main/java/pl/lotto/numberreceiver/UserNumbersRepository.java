package pl.lotto.numberreceiver;

import java.util.Collection;

public interface UserNumbersRepository {

    Collection<Integer> save(Collection<Integer> numbers);

    Collection<Integer> findAll();
}
