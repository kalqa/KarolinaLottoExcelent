package pl.lotto.numberreceiver;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUserNumbersRepository implements UserNumbersRepository {

    Map<String, Collection<Integer>> database = new ConcurrentHashMap<>();

    InMemoryUserNumbersRepository() {
    }

    InMemoryUserNumbersRepository(Map<String, Collection<Integer>> database) {
        this.database = database;
    }

    public InMemoryUserNumbersRepository(List<Integer> numbersFromUser) {
        database.put(UUID.randomUUID().toString(), numbersFromUser);
    }

    @Override
    public Collection<Integer> save(String identifier, Collection<Integer> numbers) {
        database.put(identifier, numbers);
        return numbers;
    }

    @Override
    public Collection<Integer> findAll() {
        return database.values().stream().findFirst().get();
    }
}
