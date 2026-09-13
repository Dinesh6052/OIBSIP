import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int round = 0;
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("======================================");
        System.out.println("     WELCOME TO NUMBER GUESSING GAME");
        System.out.println("======================================");

        while (playAgain) {

            round++;

            System.out.println("\n---------- ROUND " + round + " ----------");

            // Select Difficulty
            System.out.println("\nSelect Difficulty:");
            System.out.println("1. Easy   (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard   (1-200, 5 attempts)");

            int choice;

            while (true) {

                System.out.print("\nEnter your choice (1-3): ");

                if (scanner.hasNextInt()) {

                    choice = scanner.nextInt();

                    if (choice >= 1 && choice <= 3) {
                        break;
                    } else {
                        System.out.println("Invalid choice! Please enter 1, 2, or 3.");
                    }

                } else {

                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next();

                }
            }

            int maxNumber = 100;
            int maxAttempts = 7;

            switch (choice) {

                case 1:
                    maxNumber = 50;
                    maxAttempts = 10;
                    System.out.println("\nDifficulty: EASY");
                    break;

                case 2:
                    maxNumber = 100;
                    maxAttempts = 7;
                    System.out.println("\nDifficulty: MEDIUM");
                    break;

                case 3:
                    maxNumber = 200;
                    maxAttempts = 5;
                    System.out.println("\nDifficulty: HARD");
                    break;
            }

            // Generate Random Number
            int randomNumber = random.nextInt(maxNumber) + 1;

            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and "
                    + maxNumber + ".");

            System.out.println("You have " + maxAttempts + " attempts.");

            // Game Loop
            while (attempts < maxAttempts) {

                System.out.println("\n------------------------------");

                System.out.println("Attempt "
                        + (attempts + 1)
                        + " of "
                        + maxAttempts);

                System.out.print("Enter your guess: ");

                if (!scanner.hasNextInt()) {

                    System.out.println("Invalid input! Please enter a number.");

                    scanner.next();

                    continue;
                }

                int guess = scanner.nextInt();

                // Validate Range
                if (guess < 1 || guess > maxNumber) {

                    System.out.println("Please enter a number between 1 and "
                            + maxNumber);

                    continue;
                }

                attempts++;

                // Check Guess
                if (guess > randomNumber) {

                    System.out.println("Too High!");

                } else if (guess < randomNumber) {

                    System.out.println("Too Low!");

                } else {

                    System.out.println("\n================================");
                    System.out.println("          CORRECT! 🎉");
                    System.out.println("================================");

                    System.out.println("You guessed the number "
                            + randomNumber
                            + " in "
                            + attempts
                            + " attempts.");

                    guessedCorrectly = true;

                    // Score Calculation
                    int roundScore =
                            (maxAttempts - attempts + 1) * 10;

                    totalScore += roundScore;

                    System.out.println("Round Score: " + roundScore);

                    break;
                }
            }

            // Result
            if (guessedCorrectly) {

                System.out.println("\nROUND " + round + " SUMMARY");

                System.out.println("Round " + round
                        + " — guessed in "
                        + attempts
                        + " attempts.");

            } else {

                System.out.println("\n================================");
                System.out.println("          YOU LOST! 😢");
                System.out.println("================================");

                System.out.println("The correct number was: "
                        + randomNumber);

                System.out.println("\nROUND " + round + " SUMMARY");

                System.out.println("You used all "
                        + maxAttempts
                        + " attempts.");
            }

            System.out.println("\nTotal Score: " + totalScore);

            // Play Again
            String answer;

            while (true) {

                System.out.print("\nDo you want to play again? (yes/no): ");

                answer = scanner.next().toLowerCase();

                if (answer.equals("yes")
                        || answer.equals("no")) {

                    break;

                } else {

                    System.out.println("Please enter yes or no.");
                }
            }

            if (answer.equals("no")) {

                playAgain = false;
            }
        }

        // Final Summary
        System.out.println("\n======================================");
        System.out.println("          GAME OVER");
        System.out.println("======================================");

        System.out.println("Total Rounds Played: " + round);

        System.out.println("Final Score: " + totalScore);

        System.out.println("\nThank you for playing!");
        System.out.println("======================================");

        scanner.close();
    }
}