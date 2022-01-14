import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    //Introductory message
	    System.out.println("Welcome to checkers!"); scan.nextLine();
	    System.out.println("Do you wish to enable free play? (no turns)");
        String freeornot = scan.nextLine(); // Free mode selection
        int free=0, robot=0, turn=0, robotturn=0; // Initializing variables
        if (freeornot.toLowerCase().equals("yes")) {
            free = 1;
        } else {
        	// Computer mode selection
            System.out.println("Would you like to enable the computer opponent?");
            String computerornot = scan.nextLine();
            if (computerornot.toLowerCase().equals("yes")) {
                robot = 1;
            }
            
            // Coinflip for deciding which player starts first
            System.out.println("Would you like to coinflip to decide who goes first, or choose?");
            String CorC = scan.nextLine().toLowerCase();
            if (CorC.equals("coinflip") || CorC.equals("coin flip") || CorC.equals("coin") || CorC.equals("flip")) {
                // Do a coinflip to randomly select which player starts
            	int chance = (int)(Math.random()*2+1);
                switch(chance) {
                    case 1:
                        if (robot == 0) {
                            System.out.println("It is heads. Player 1 goes first.");
                        } else {
                            System.out.println("It is heads. Computer goes first.");
                            robotturn = 1;
                        }
                        turn=1;
                        break;
                    case 2:
                        System.out.println("It is tails. Player 2 goes first.");
                        turn=2;
                        break;
                    default:
                    	// Backup in-case there is somehow an error
                        System.out.println("ERROR: Coinflip is less than 1 or greater than 2");
                        System.out.println("Player 2 is chosen due to this error.");
                        break;
                }
            } else if (CorC.equals("choose") || CorC.equals("pick")) {
            	// Let user manually decide which player goes first
                Boolean chosen = false;
                do{
                    System.out.println("Type 1 or 2 to decide who goes first.");
                    int chosep = scan.nextInt();
                    if (chosep==1 || chosep==2) {
                        turn=chosep;
                        chosen=true;
                    } else {
                        System.out.println("INVALID NUMBER, MUST BE (1-2)");
                    }
                }while(chosen==false);
            }
        }
        int[] sendThis = {free,robot,turn,robotturn};
	    Boolean playAgain = true; while (playAgain == true) {
	        // Loop for replayability
	        checkers send = new checkers();
	        send.main(sendThis);
	        System.out.println("Would you like to play again?");
	        String answer = scan.nextLine().toLowerCase();
	        if (answer.equals("yes") || answer.equals("y")) {} else {
	            playAgain = false;
	        }
	    }
	}
}
