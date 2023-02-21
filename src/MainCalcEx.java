import java.util.Scanner;

public class MainCalcEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameLogic game = new GameLogic();
        game.userMaxRounds(scanner);
        int maxBound = game.getMaxBound(scanner);
        while(game.getRound() < game.getMaxRounds()) {
            CalcEX exercise = new CalcEX(maxBound);
            System.out.println("**************");
            System.out.println("\nROUND: " + (game.getRound() + 1));
            game.showChallenge(exercise.getFirstNumber(), exercise.getSecondNumber(), exercise.getOperator());
            System.out.println(exercise.getSolution());
            int userGuess = game.getUserGuess(scanner);
            game.guessedCorrect(exercise.getSolution(), userGuess);
            game.setRound(game.getRound() + 1);
        }
        System.out.println("##################################");
        System.out.println("\nGame has ended. You've played " + game.getMaxRounds() + " rounds. Total score: " + game.getScore() + "\n");
        System.out.println("##################################");

    }
}
