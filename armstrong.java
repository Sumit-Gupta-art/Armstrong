

import java.util.Scanner;

public class armstrong {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter number to check : ");
        int originalNum = userInput.nextInt();
        userInput.nextLine();
        int pow = countNoOfDigits(originalNum);
        int sum = sumCalculator(originalNum, pow);
        if (verifyArmstrong(originalNum, sum)) {
            System.out.println(originalNum + " is armstrong number");
        } else {
            System.out.println(originalNum + " is NOT armstrong number");
        }
    }

    public static int countNoOfDigits(int number) {
        int noOfDigits = 0;
        while (number > 0) {
//            number /= 10;
            number = eliminateLastDigit(number);
            noOfDigits++;
        }
        return noOfDigits;
    }

    public static int fetchLastDigit(int number) {
        return number %= 10;
    }

    public static int eliminateLastDigit(int number) {
        return number /= 10;
    }

    public static int sumCalculator(int number, int pow) {
        int sum = 0;
        while (number > 0) {
            int lastDigit = fetchLastDigit(number);
            number = eliminateLastDigit(number);
            int powerCalculation = powCalculator(lastDigit, pow);
            sum += powerCalculation;
        }
        return sum;
    }

    public static int powCalculator(int base, int pow) {
        int output = 1;
        while (pow > 0) {
            output = output * base;
            pow--;
        }
        return output;
    }

    public static boolean verifyArmstrong(int number, int sum) {
        if (number == sum) {
            return true;
        }
        return false;
    }
}