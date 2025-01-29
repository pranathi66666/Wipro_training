import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderedTest {

    @Test
    @Order(1)
    void testA() {
        System.out.println("Executing testA");
    }

    @Test
    @Order(3)
    void testB() {
        System.out.println("Executing testB");
    }

    @Test
    @Order(2)
    void testC() {
        System.out.println("Executing testC");
    }
}
