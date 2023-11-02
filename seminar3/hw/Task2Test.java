package seminar3.hw;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Task2Test {
    private Task2 checker;

    @BeforeEach
    void setUp() {
        checker = new Task2();
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 50, 99}) // Числа в интервале
    public void testNumberInIntervalInside(int number) {
        assertTrue(checker.numberInInterval(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 100, 0, 101}) // Числа за пределами интервала
    public void testNumberInIntervalOutside(int number) {
        assertFalse(checker.numberInInterval(number));
    }
}
