import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {


    /*
    Whole idea behind this:

    - Create a method to generate a random number between two index's
    - Method will take in the first number & second
    - Make a continuous game
    - Make so if they guess number, if its false it will say Wrong Awnser
    - Create a system in the backend where they have 5 awnsers
    - Create a score system [Added later]
    - Add GUI System to it later
    -
    -

     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Number Guess by");
        System.out.println("Created by Keldan Rafuse - 10/5/2023");
        System.out.println();

        while(true) {
            boolean guessedRandNum = false;
            final int maxAttempts = 5;
            int attempts = 0;

            // Generate the first number from the user's input
            System.out.print("Enter first minimum number: ");
            int firstIndex = scanner.nextInt();

            // Generate the second number from the user's input
            System.out.print("Enter second maximum number: ");
            int secondIndex = scanner.nextInt();

            // Create an instance of the hiddenNumber
            int hiddenNum = randomNumber(firstIndex, secondIndex);

            // Display the user the index
            System.out.println("Your random number is " + hashNumber(hiddenNum));

            // Implementation of the entering guess's
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == hiddenNum) {
                    System.out.println();
                    System.out.println("Congratulations! You guessed the number correctly.");
                    guessedRandNum = true;
                    break;
                } else {
                    System.out.println("Wrong answer. Try again.");
                    attempts++;
                    if (attempts < maxAttempts) {
                        System.out.println("You have " + (maxAttempts - attempts) + " attempts left.");
                    }
                }
            }

            if (!guessedRandNum) {
                System.out.println();
                System.out.println("You've used all your attempts. The correct number was: " + hiddenNum);
            }

            // Implementation of the continuous game system
            System.out.println("Do you want to continue playing? (yes/no)");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("You have ended the game! Thanks for playing :)");
                break;
            }
        }
    }

    // Method created to generate the random number between two index's
    public static int randomNumber(int firstNum, int secondNum) {
        // Create a random between the two arguments
        int random = ThreadLocalRandom.current().nextInt(firstNum, secondNum);
        return random;
    }

    public static String hashNumber(int number) {
        // Calculate the number of digits in the input number
        int numDigits = String.valueOf(number).length();
        StringBuilder hash = new StringBuilder();

        // Loop through the digits & add X for each digit
        for (int i = 0; i < numDigits; i++) {
            hash.append('X');
        }

        return hash.toString();
    }

}