package homework5.Program3;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class JunitTest {
    @BeforeAll
    public static void setUp() throws Exception {
        System.out.println("Input Type: int");
        System.out.println("Output Type: boolean.");
    }

    @BeforeEach
    public void startOfTest() throws Exception {
        System.out.println("Starting Test");
    }

    @Test
    public void checkPalindrome(){
        assertTrue(ArmstrongNumber.isArmstrong(5));
        assertFalse(ArmstrongNumber.isArmstrong(15));
        assertTrue(ArmstrongNumber.isArmstrong(1000));
        assertTrue(ArmstrongNumber.isArmstrong(81)));
    }

    @AfterEach
    public void afterTest() throws Exception {
        System.out.println("Test Passed");
    }

    @AfterAll
    public static void afterAllTests() throws Exception {
        System.out.println("All Tests Passed");
    }
}
