import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int MAX_ATTEMPTS = 10;
    private static final int RANGE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;
        int totalScore = 0;
        int round = 0;

        do {
            round++;
            int numberToGuess = random.nextInt(RANGE) + 1;
            int attempts = 0;
            boolean guessed = false;

            printBanner("Welcome to the Number Guessing Game! Round " + round);
            System.out.println("I'm thinking of a number between 1 and " + RANGE + ".");
            System.out.println("Can you guess what it is? You have " + MAX_ATTEMPTS + " attempts.");
            printSeparator('-');

            while (attempts < MAX_ATTEMPTS && !guessed) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                loadingAnimation();

                if (userGuess < numberToGuess) {
                    System.out.println("\nYour guess is too low. Try again!");
                    printSeparator('-');
                } else if (userGuess > numberToGuess) {
                    System.out.println("\nYour guess is too high. Try again!");
                    printSeparator('-');
                } else {
                    System.out.println("\nCongratulations! You've guessed the number correctly.");
                    guessed = true;
                    printSeparator('-');
                    int points = (MAX_ATTEMPTS - attempts + 1) * 10;
                    totalScore += points;
                    System.out.println("You earned " + points + " points! Total Score: " + totalScore);
                }
            }

            if (!guessed) {
                System.out.println("\nSorry, you've used all your attempts. The number was " + numberToGuess + ".\n");
            }

            printSeparator('-');
            System.out.println("Do you want to play another round? (yes/no)");
            scanner.nextLine();  // consume newline
            String response = scanner.nextLine();
            playAgain = response.equalsIgnoreCase("yes");

            printSeparator('*');
        } while (playAgain);

        System.out.println("Thank you for playing the Number Guessing Game!");
        System.out.println("Your total score is: " + totalScore);
        printSeparator('*');
        System.out.println("              Come play again soon! Goodbye!             ");
        printSeparator('=');
        System.out.println();
        scanner.close();
    }

    private static void printBanner(String message) {
        printSeparator('=');
        System.out.println("          " + message + "          ");
        printSeparator('-');
    }

    private static void printSeparator(char symbol) {
        for (int i = 0; i < 60; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }

    private static void loadingAnimation() {
        System.out.print("Checking");
        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(250); // 250ms * 4 = 1000ms (1 second)
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
