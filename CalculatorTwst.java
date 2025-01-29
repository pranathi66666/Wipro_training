import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({
        "2, 3, 5",
        "-1, -1, -2",
        "10, 5, 15",
        "0, 7, 7"
    })
    void testAddition(int a, int b, int expected) {
        assertEquals(expected, Calculator.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
        "5, 3, 2",
        "-1, -1, 0",
        "10, 5, 5",
        "0, 7, -7"
    })
    void testSubtraction(int a, int b, int expected) {
        assertEquals(expected, Calculator.subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({
        "2, 3, 6",
        "-1, -1, 1",
        "10, 5, 50",
        "0, 7, 0"
    })
    void testMultiplication(int a, int b, int expected) {
        assertEquals(expected, Calculator.multiply(a, b));
    }

    @ParameterizedTest
    @MethodSource("provideDivisionData")
    void testDivision(int a, int b, double expected) {
        assertEquals(expected, Calculator.divide(a, b), 0.001);
    }

    static Stream<Object[]> provideDivisionData() {
        return Stream.of(
            new Object[]{6, 3, 2.0},
            new Object[]{10, 2, 5.0},
            new Object[]{7, 2, 3.5},
            new Object[]{15, 5, 3.0}
        );
    }

    @ParameterizedTest
    @CsvSource({
        "5, 0"
    })
    void testDivisionByZero(int a, int b) {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(a, b));
    }
}
