package ie.gmit.dip;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.management.InvalidAttributeValueException;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class InsuranceProgramTest {
    private static InsuranceProgram insuranceProgram;
    @BeforeAll
    public static void setUp() {
        insuranceProgram = new InsuranceProgram();
    }

    @BeforeEach
    public void init(TestInfo testInfo) {
        System.out.println("Start..." + testInfo.getDisplayName());
    }

    @Test
    @DisplayName("No extra surcharge based on age")
    public void testNoExtraSurchageBasedOnAge() throws InvalidAttributeValueException {
        assertEquals(insuranceProgram.checkSurcharge(26), 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {24, 20})
    @DisplayName("Testing extra surcharge based on age")
    public void testExtraSurchargersBasedOnAge(int input) throws InvalidAttributeValueException {
        assertEquals(insuranceProgram.checkSurcharge(input), 100);
    }

    @Test
    @DisplayName("Invalid age exception test")
    public void testInvalidAgeException() {
        Throwable exception = assertThrows(InvalidAttributeValueException.class, () -> {
            insuranceProgram.checkSurcharge(0);
        });
        assertEquals(exception.getMessage(), "Invalid age");
    }

    @Test
    @DisplayName("Test get insurance price")
    public void testGetInsurance() throws NoInsuranceException {
        assertEquals(insuranceProgram.getInsurance(0,1), 550);
        assertEquals(insuranceProgram.getInsurance(0,2), 625);
        assertEquals(insuranceProgram.getInsurance(0,0), 500);
        assertEquals(insuranceProgram.getInsurance(0,3), 725);
        assertEquals(insuranceProgram.getInsurance(0,4), 875);
        assertEquals(insuranceProgram.getInsurance(0,5), 1075);
    }

    @Test
    @DisplayName("Test getting no insurance exception")
    public void testNoInsuranceException() {
        Throwable exception = assertThrows(NoInsuranceException.class, () -> {
            insuranceProgram.getInsurance(0,6);
        });
        assertEquals(exception.getMessage(), "No insurance");
    }

    @Test
    @DisplayName("Testing check insurance method")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testCheckInsuranceMethod() throws NoInsuranceException {
        assertEquals(insuranceProgram.checkInsurance(20, 1), 650);
        assertEquals(insuranceProgram.checkInsurance(30, 0), 500);
        assertEquals(insuranceProgram.checkInsurance(18, 3), 825);
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        System.out.println("Finished..." + testInfo.getDisplayName());
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("All tests finished...");
    }
}
