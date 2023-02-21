// schrijf een klein rekenoefening programma die rekensommen maakt en om een input vraagt en de input checkt met het correcte antwoord.
// # bouw een applicatie die twee random nummers uit print en hier een som van maakt. GEDAAN
// # vervolgens moet deze om een invoer vragen en checken of de invoer klopt met de gegeven som.
// # Bonus : maak de methode zo dat er een random operator wordt gebruikt van de soort + - * of /. en hier dus een som van maakt. GEDAAN
// (tip voeg deze stap voor stap toe niet allemaal gelijk want elke heeft zijn uitdagingen)
// # Bonus bouw in dat je van te voren kan opgeven hoeveel vragen je wilt beantwoorden.
// # Bonus: bouw een punten systeem erbij voor goede antwoorden en foute antwoorden.# Bonus: bij het aftrekken kom je soms negatief uit. als dit het geval is draai dan de nummers om.
// # Bonus: bij het delen kom je soms op decimalen uit. maak de functie zo dat dit niet meer het geval is.
// # Tip modulo uitkomst van het grootste getal zetten en deze voorin in de berekening zetten
// # Bonus: schrijf de functie zo dat je zelf kan ingeven hoe hoog de getalen mogen zijn


import java.util.Random;

public class Main {
    //
//    static char[] arithOperators = {'+', '-', '*', '/', '%'};
    static char[] arithOperators = {'-'};

    static char getRandomOperator() {
        Random random = new Random();
        return arithOperators[random.nextInt(0, arithOperators.length)];
    }

    public static int getRandomInt() {
        Random random = new Random();
        return random.nextInt(1, 99);
    }

    // return solution as int
    public static int getSolution(int num1, int num2, char operator) {
        double solution = doTheMagic(num1, num2, operator);
        System.out.println("double solution is " + solution);
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
        }
        return 0; // Is hier een truc voor?? Staat er voor niets bij, maar is verplicht.
    }


    public static void main(String[] args) {

        // create and print two random integers

        int randNumber1 = getRandomInt();
        int randNumber2 = getRandomInt();
        char randNumberOperator = getRandomOperator();

        // The minus/modulo-swap, biggest number first.
        if((randNumberOperator == '%' || randNumberOperator == '-') && (randNumber1 < randNumber2)) {
            int tempNumber = randNumber1;
            randNumber1 = randNumber2;
            randNumber2 = tempNumber;
        }
        System.out.println("The challenge is: " + randNumber1 + " " + randNumberOperator + " " + randNumber2);
        int solution = getSolution(randNumber1, randNumber2, randNumberOperator);
        System.out.println(solution);
//        int guess = getGuess();

    }
}