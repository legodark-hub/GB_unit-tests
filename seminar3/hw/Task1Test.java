package seminar3.hw;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Task1Test {
 private Task1 task;

    @BeforeEach
    void setUp() {
        task = new Task1();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 10, 100}) // Четные числа
    public void testEvenNumber(int number) {
        assertTrue(task.evenOddNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 7}) // Нечетные числа
    public void testOddNumber(int number) {
        assertFalse(task.evenOddNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0}) // Ноль
    public void testZero(int number) {
        assertTrue(task.evenOddNumber(number));
    }
}
