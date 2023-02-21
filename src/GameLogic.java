import java.util.Scanner;

public class GameLogic {
    private int score;
    private int round;
    private int maxRounds;

    public int getScore() {
        return score;
    }

    public int getRound() {
        return round;
    }

    public int getMaxRounds() {
        return maxRounds;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void showChallenge(int num1, int num2, char operator) {
        System.out.println("\nThe challenge is: " + num1 + " " + operator + " " + num2);
    }

    // Prompt user for max height of random numbers
    public int getMaxBound(Scanner scanner) {
        int maxBound = 0;
        boolean illegalNumber = true;
        String promptOne = "Enter the heighest number for calculation (2-100): ";
        while(illegalNumber) {
            maxBound = this.checkIfInt(scanner, promptOne);
            if(maxBound < 2 || maxBound > 100) {
                System.out.println("Only from 2-100. Try again");
            } else{
                illegalNumber = false;
            }
        }
        System.out.println("Heighest number to calculate with: " + maxBound);
        return maxBound;
    }

    // Check if number is an integer
    public int checkIfInt(Scanner scanner, String promptOne) {
        int number = 0;
        boolean notANumber = true;
        while(notANumber) {
            System.out.print(promptOne);
            try {
                number = scanner.nextInt();
                scanner.nextLine();
                notANumber = false;
            } catch (Exception e) {
                System.out.println("That is not a whole number. Try again.");
                scanner.nextLine();

            }
        }
        return number;
    }

    public int getUserGuess(Scanner scanner) {
        String promptOne = "Guess the outcome. Whole numbers only: ";
        int guess = this.checkIfInt(scanner, promptOne);
        System.out.println("Your guess: " + guess);
        return guess;
    }

    public void guessedCorrect(int solution, int userGuess) {
        if(solution == userGuess) {
            System.out.println("You've guessed CORRECT and scored a point");
            this.score++;

        } else {
            System.out.println("WRONG GUESS!! The answer was: " + solution);
            System.out.println("One point subtracted  ):");
            this.score--;
        }
        System.out.println("Current score: " + this.score);
    }

    public  void userMaxRounds(Scanner scanner) {
        int rounds = 0;
        boolean illegalNumber = true;
        String promptOne = "Enter number of rounds you want to play (1-10): ";
        while(illegalNumber) {
            rounds = this.checkIfInt(scanner, promptOne);
            if(rounds < 1 || rounds > 10) {
                System.out.println("Only from 1-10. Try again");
            } else{
                illegalNumber = false;
            }
        }
        System.out.println("Number of rounds to play: " + rounds);
        this.maxRounds = rounds;
    }
}
