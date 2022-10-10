package pl.lotto.numberreceiver;

import java.util.List;
import org.junit.jupiter.api.Test;
import pl.lotto.numberreceiver.dto.NumberReceiverResponseDto;
import static org.assertj.core.api.Assertions.assertThat;

public class NumberReceiverFacadeTest {

    @Test
    public void should_return_success_when_user_input_six_numbers() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacade();

        // when
        NumberReceiverResponseDto response = numberReceiverFacade.inputNumbers(List.of(1, 2, 3, 4, 5, 6));

        // then
        NumberReceiverResponseDto expectedResponse = new NumberReceiverResponseDto();
        assertThat(response).isEqualTo(expectedResponse);
    }
}
