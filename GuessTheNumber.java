import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;
        int userguess = 0;
        int attempts = 0;

        System.out.println("Welcome to my Game");
        System.out.println("I have selected a number between 1 and 100. Can you try guess?");

        while(userguess != numberToGuess){
            System.out.print("Enter your number: ");
            try{
                userguess = sc.nextInt();
                attempts++;

                if(userguess<1 || userguess>100){
                    System.out.println("Enter a number between 1 and 100.");
                } else if (userguess < numberToGuess) {
                    System.out.println("Too low, try again.");
                } else if (userguess > numberToGuess) {
                    System.out.println("Too high, try again");
                }else {
                    System.out.println("Congrutulation! You have the number in " + attempts + " attempts");
                }
            } catch (Exception e) {
                System.out.println("Invalid number! Enter a valid number.");
                sc.next();
            }
        }
        sc.close();
    }
}