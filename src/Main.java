// schrijf een klein rekenoefening programma die rekensommen maakt en om een input vraagt en de input checkt met het correcte antwoord.
// # bouw een applicatie die twee random nummers uit print en hier een som van maakt. GEDAAN
// # vervolgens moet deze om een invoer vragen en checken of de invoer klopt met de gegeven som. GEDAAN
// # Bonus : maak de methode zo dat er een random operator wordt gebruikt van de soort + - * of /. en hier dus een som van maakt. GEDAAN
// (tip voeg deze stap voor stap toe niet allemaal gelijk want elke heeft zijn uitdagingen)
// # Bonus bouw in dat je van te voren kan opgeven hoeveel vragen je wilt beantwoorden.
// # Bonus: bouw een punten systeem erbij voor goede antwoorden en foute antwoorden. GEDAAN
// # Bonus: bij het aftrekken kom je soms negatief uit. als dit het geval is draai dan de nummers om. GEDAAN
// # Bonus: bij het delen kom je soms op decimalen uit. maak de functie zo dat dit niet meer het geval is. GEDAAN
// # Tip modulo uitkomst van het grootste getal zetten en deze voorin in de berekening zetten GEDAAN
// # Bonus: schrijf de functie zo dat je zelf kan ingeven hoe hoog de getalen mogen zijn


import java.util.Random;
import java.util.Scanner;

public class Main {

//    static char[] arithOperators = {'+', '-', '*', '/', '%'};
    static char[] arithOperators = {'-'};
    static int score;
    static int maxRounds;
    static int roundsCounter;

    static char getRandomOperator() {
        Random random = new Random();
        return arithOperators[random.nextInt(0, arithOperators.length)];
    }

    public static int getRandomInt(int maxBound) {
        Random random = new Random();
        return random.nextInt(1, maxBound + 1);
    }

    // return solution as int
    public static int getSolution(int num1, int num2, char operator) {
        double solution = doTheMagic(num1, num2, operator);

        //round to nearest int
        return (int) Math.round(solution + .49999);
    }

    // check operator and calculate
    private static double doTheMagic(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;

            case '/':
                return num1 / num2;

            case '%':
                return num1 % num2;
            default:
                return -1; // Never used
        }
    }

    public static int getUserGuess(Scanner scanner) {
        String promptOne = "Guess the outcome. Whole numbers only: ";
        int guess = checkIfInt(scanner, promptOne);
        System.out.println("Your guess: " + guess);
        return guess;
    }

    // check if user input is an int.
    private static int checkIfInt(Scanner scanner, String promptOne) {
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

    public static void guessedCorrect(int solution, int userGuess) {
        if(solution == userGuess) {
            System.out.println("You've guessed CORRECT and scored a point");
            score++;

        } else {
            System.out.println("WRONG GUESS!! The answer was: " + solution);
            System.out.println("One point subtracted  ):");
            score--;
        }
        System.out.println("Current score: " + score);
    }

    public static int getRounds(Scanner scanner) {
        int rounds = 0;
        boolean illegalNumber = true;
        String promptOne = "Enter number of rounds you want to play (1-10): ";
        while(illegalNumber) {
            rounds = checkIfInt(scanner, promptOne);
            if(rounds < 1 || rounds > 10) {
                System.out.println("Only from 1-10. Try again");
            } else{
                illegalNumber = false;
            }
        }
        System.out.println("Number of rounds to play: " + rounds);
        return rounds;
    }

    public static int getMaxBound(Scanner scanner) {
        int maxBound = 0;
        boolean illegalNumber = true;
        String promptOne = "Enter the heighest number for calculation (2-100): ";
        while(illegalNumber) {
            maxBound = checkIfInt(scanner, promptOne);
            if(maxBound < 2 || maxBound > 100) {
                System.out.println("Only from 2-100. Try again");
            } else{
                illegalNumber = false;
            }
        }
        System.out.println("Heighest number to calculate with: " + maxBound);
        return maxBound;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        maxRounds = getRounds(scanner);
        int maxBound = getMaxBound(scanner);

        // Start of rounds
    while(roundsCounter < maxRounds) {
        // create two random integers and one random operator
        int randNumber1 = getRandomInt(maxBound);
        int randNumber2 = getRandomInt(maxBound);
        char randNumberOperator = getRandomOperator();

        // The minus/modulo-swap, biggest number first.
        if((randNumberOperator == '%' || randNumberOperator == '-') && (randNumber1 < randNumber2)) {
            int tempNumber = randNumber1;
            randNumber1 = randNumber2;
            randNumber2 = tempNumber;
        }

        // Gameplay:
        System.out.println("\nROUND: " + (roundsCounter + 1));
        System.out.println("\nThe challenge is: " + randNumber1 + " " + randNumberOperator + " " + randNumber2);
        int solution = getSolution(randNumber1, randNumber2, randNumberOperator);
        System.out.println("The solution is: " + solution);
        int userGuess = getUserGuess(scanner);
        guessedCorrect(solution, userGuess);
        roundsCounter++;
        System.out.println("*************");
    }

        System.out.println("Game has ended. You've played " + maxRounds + " rounds and your final score is: " + score);
    }
}