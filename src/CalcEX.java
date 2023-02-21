import java.util.Random;

public class CalcEX {

    private int firstNumber;
    private int secondNumber;
    private char operator;
    private int maxBound;
    private int solution;
    private static char[] arithOperators = { '/'};
//    private static char[] arithOperators = {'+', '-', '*', '/', '%'};

    public CalcEX(int maxBound) {
        this.maxBound = maxBound;
        this.firstNumber = this.getRandomInt(this.maxBound);
        this.secondNumber = this.getRandomInt(this.maxBound);
        this.operator = this.getRandomOperator();
        checkForSwap();
        this.solution = this.calcSolution(this.firstNumber, this.secondNumber, this.operator);
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public char getOperator() {
        return operator;
    }

    public int getMaxBound() {
        return maxBound;
    }

    public int getSolution() {
        return solution;
    }

    private int getRandomInt(int maxBound) {
        Random random = new Random();
        return random.nextInt(1, maxBound + 1);
    }

    private char getRandomOperator() {
        Random random = new Random();
        return arithOperators[random.nextInt(0, arithOperators.length)];
    }

    // for subtraction or modulo, check/swap biggest number first.
    private void checkForSwap() {
        if((this.operator == '%' || this.operator == '-') && (this.firstNumber < this.secondNumber)) {
            int tempNumber = this.firstNumber;
            this.firstNumber = this.secondNumber;
            this.secondNumber = tempNumber;
        }
    }

    // Return solution of calculation as Integer
    public int calcSolution(int num1, int num2, char operator) {
        double solution = doTheMagic(num1, num2, operator);

        //round to nearest int
        return (int)(solution + .5);
    }

    // Where the magic happens
    private double doTheMagic(int num1, int num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            case '%' -> num1 % num2;
            default -> -1; // Never used
        };
    }



}
