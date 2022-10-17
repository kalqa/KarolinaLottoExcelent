package pl.lotto.numberreceiver.dto;

import java.util.Collection;

public record UserNumbersResponseDto(Collection<Integer> numbers) {
}
