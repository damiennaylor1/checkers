import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    //Introductory message
            System.out.println("Welcome to checkers!");
	    Boolean playAgain = true; while (playAgain == true) {
	        // Loop for replayability
	        checkers send = new checkers();
	        send.main();
	        System.out.println("Would you like to play again?");
	        String answer = scan.nextLine().toLowerCase();
	        if (answer.equals("yes") || answer.equals("y")) {} else {
	            playAgain = false;
	        }
	    }
	}
}
