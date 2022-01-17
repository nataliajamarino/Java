package ie.gmit.dip;

// This code is almost impossible to write meaningfully test cases against,
//it need to be refactored into at least two methods.


import javax.management.InvalidAttributeValueException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InsuranceProgram {
    private static int surcharge = 100; // under 25 years
    private static int basicInsurance = 500; // Default insurance price
    // Create accident surcharge map to get value based on accident
    private static Map<Integer, Integer> accidentSurchargeMap;
    static {
        accidentSurchargeMap = new HashMap<>();
        accidentSurchargeMap.put(0, 0);
        accidentSurchargeMap.put(1, 50);
        accidentSurchargeMap.put(2, 125);
        accidentSurchargeMap.put(3, 225);
        accidentSurchargeMap.put(4, 375);
        accidentSurchargeMap.put(5, 575);
    }
    public static void main(String[] args) throws NoInsuranceException {
        InsuranceProgram i = new InsuranceProgram();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        System.out.print("\nHow many accidents did you have? ");
        int accidents = input.nextInt();
        i.checkInsurance(age, accidents);
    }

    public int checkInsurance(int age, int accidents) throws NoInsuranceException {
        try {
            int ageSurcharge = checkSurcharge(age);
            int insurancePrice = getInsurance(ageSurcharge, accidents);

            return insurancePrice;
        } catch (InvalidAttributeValueException | NoInsuranceException e) {
            throw new NoInsuranceException("No insurance available");
        }
    }

    public int getInsurance(int ageSurcharge, int accidents) throws NoInsuranceException {
        if (accidents > 5) {
            throw new NoInsuranceException("No insurance");
        }
        int accidentSurcharge = accidentSurchargeMap.get(accidents);
        System.out.println("Additional surcharge for accident: " + accidentSurcharge + " \ntotal amount to pay: " + (basicInsurance + accidentSurcharge + ageSurcharge));
        return basicInsurance + accidentSurcharge + ageSurcharge;
    }

    public int checkSurcharge(int age) throws InvalidAttributeValueException {
        // Invalid age
        if (age == 0) {
            throw new InvalidAttributeValueException("Invalid age");
        }

        if (age < 25) {
            System.out.println("Additional age surcharge " + surcharge);
            return surcharge;
        }

        System.out.println("No additional age surcharge");
        return 0;
    }
}
