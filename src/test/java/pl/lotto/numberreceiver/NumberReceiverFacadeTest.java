package pl.lotto.numberreceiver;

import java.util.List;

import org.junit.jupiter.api.Test;
import pl.lotto.numberreceiver.dto.NumberReceiverResponseDto;
import pl.lotto.numberreceiver.dto.UserNumbersResponseDto;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberReceiverFacadeTest {

    @Test
    public void should_return_success_when_user_inputs_six_numbers() {
        // given
        UserNumbersRepository repository = new InMemoryUserNumbersRepository();
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().buildModuleForTests(repository);
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6);

        // when
        NumberReceiverResponseDto response = numberReceiverFacade.inputNumbers(numbersFromUser);

        // then
        NumberReceiverResponseDto expectedResponse = new NumberReceiverResponseDto("success");
        assertThat(response.message()).isEqualToIgnoringCase(expectedResponse.message());
    }

    @Test
    public void should_return_failed_when_user_inputs_less_than_six_numbers() {
        // given
        UserNumbersRepository repository = new InMemoryUserNumbersRepository();
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().buildModuleForTests(repository);
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5);

        // when
        NumberReceiverResponseDto response = numberReceiverFacade.inputNumbers(numbersFromUser);

        // then
        NumberReceiverResponseDto expectedResponse = new NumberReceiverResponseDto("failed");
        assertThat(response.message()).isEqualToIgnoringCase(expectedResponse.message());
    }

    @Test
    public void should_return_failed_when_user_inputs_more_than_six_numbers() {
        // given
        UserNumbersRepository repository = new InMemoryUserNumbersRepository();
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().buildModuleForTests(repository);
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6, 7);

        // when
        NumberReceiverResponseDto response = numberReceiverFacade.inputNumbers(numbersFromUser);

        // then
        NumberReceiverResponseDto expectedResponse = new NumberReceiverResponseDto("failed");
        assertThat(response.message()).isEqualToIgnoringCase(expectedResponse.message());
    }

    @Test
    public void should_return_failed_when_user_input_duplicated_numbers() {
        // given
        UserNumbersRepository repository = new InMemoryUserNumbersRepository();
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().buildModuleForTests(repository);
        List<Integer> numbersFromUser = List.of(1, 1, 3, 4, 5, 6);

        // when
        NumberReceiverResponseDto response = numberReceiverFacade.inputNumbers(numbersFromUser);

        // then
        NumberReceiverResponseDto expectedResponse = new NumberReceiverResponseDto("failed");
        assertThat(response.message()).isEqualToIgnoringCase(expectedResponse.message());
    }

    @Test
    public void should_return_success_when_user_inputs_numbers_in_range_of_1_to_99_inclusive() {
        // given
        UserNumbersRepository repository = new InMemoryUserNumbersRepository();
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().buildModuleForTests(repository);
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6);

        // when
        NumberReceiverResponseDto response = numberReceiverFacade.inputNumbers(numbersFromUser);

        // then
        NumberReceiverResponseDto expectedResponse = new NumberReceiverResponseDto("success");
        assertThat(response.message()).isEqualToIgnoringCase(expectedResponse.message());
    }

    @Test
    public void should_return_failed_when_user_inputs_numbers_out_of_range_of_1_to_99_inclusive() {
        // given
        UserNumbersRepository repository = new InMemoryUserNumbersRepository();
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().buildModuleForTests(repository);
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 100);

        // when
        NumberReceiverResponseDto response = numberReceiverFacade.inputNumbers(numbersFromUser);

        // then
        NumberReceiverResponseDto expectedResponse = new NumberReceiverResponseDto("failed");
        assertThat(response.message()).isEqualToIgnoringCase(expectedResponse.message());
    }

    @Test
    public void should_create_user_draw_identifier_when_saving_user_numbers() {

    }

    @Test
    public void should_inform_user_when_next_draw() {

    }

    @Test
    public void should_return_saved_numbers_when_they_ask() {
        // given
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 8);
        UserNumbersRepository repository = new InMemoryUserNumbersRepository(numbersFromUser);
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().buildModuleForTests(repository);

        // when
        UserNumbersResponseDto response = numberReceiverFacade.userNumbers();

        // then
        List<Integer> expectedNumbersFromUser = List.of(1, 2, 3, 4, 5, 8);
        UserNumbersResponseDto expectedResponse = new UserNumbersResponseDto(expectedNumbersFromUser);
        assertThat(response).isEqualTo(expectedResponse);
    }

}
