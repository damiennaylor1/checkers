import java.util.Scanner;

//This class will run the game 
public class checkers {
	// Initializing variables that are used in the program
    int[][] positions = new int[8][8]; // Array used for 8x8 board
    int jumpcount = 0;
    
    /*These Strings will be called for assigning values and 
    * for preventing a piece from giving an out of bounds error
    */ 
    String[] a = {"A","B","C","D","E","F","G","H"};
    String letters = "ABCDEFGH"; 
    String numbers = "12345678";
    
    
    Scanner scan = new Scanner(System.in);
    
    public int moveCheck(int cord2, int cord1, int turn) {
        // This method checks for legal moves and returns how many legal moves it has.
        int cord = positions[cord2][cord1];
        String tstring = "";
        int free = 0; int legalcheck = 0;  int check=0;
        
        if (cord == 2) { // If the piece belongs to Player 2
            if (turn == 2 || free == 1) {
                switch (cord2) { // Checks for legal moves between rows 2-7
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        if (positions[cord2-1][cord1-1] != cord) {
                            switch (positions[cord2-1][cord1-1] + 1) {
                                case 2:
                                    if ((cord2-1) > 0 && cord1-1 > 0) {
                                        if (positions[cord2-2][cord1-2] == 0) {
                                            legalcheck++; // Adds '1' to variable when a move is available
                                            tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                            
                                        }
                                    }
                                    break;
                                case 1:
                                    legalcheck++; 
                                    tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1);
                                    break;
                            }    
                                
                        }
                        if (positions[cord2+1][cord1-1] != cord) {
                            switch (positions[cord2+1][cord1-1] + 1) {
                                case 2:
                                    if ((cord2+1) < 7 && cord1-1 > 0) {
                                        if (positions[cord2+2][cord1-2] == 0) {
                                            legalcheck++;
                                            tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1); tstring += '%';
                                            
                                        }
                                    }
                                    break;
                                case 1:
                                    legalcheck++;
                                    tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1);
                                    break;
                            }
                        }
                        if (legalcheck == 0) {
                            check = 1;
                            break;
                        }
                        break;
                    case 0: // This is to check for legal moves for a piece in danger of an arrayoutofbound error (On the edge of the board)
                        if (positions[cord2+1][cord1-1] != cord) {
                            switch (positions[cord2+1][cord1-1] + 1) {
                                case 2:
                                    if ((cord2+1) < 7 && cord1-1 > 0) {
                                        if (positions[cord2+2][cord1-2] == 0) {
                                            legalcheck++;
                                            tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1); tstring += '%';
                                            
                                        }
                                    }
                                    break;
                                case 1:
                                    legalcheck++;
                                    tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1);
                                    break;
                                default:
                                    check=1;
                                    break;
                            }
                        }
                        break;
                    case 7: // This is to check for legal moves for a piece in danger of an arrayoutofbound error (On the edge of the board)
                        if (positions[cord2-1][cord-1] != cord) {
                            switch (positions[cord2-1][cord1-1] + 1) {
                                case 2:
                                    if ((cord2-1) > 0 && cord1-1 > 0) {
                                        if (positions[cord2-2][cord1-2] == 0) {
                                            legalcheck++;
                                            tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                            
                                        }
                                    }
                                    break;
                                case 1:
                                    tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1);
                                    legalcheck++;
                                    break;
                                default: // If no legal moves available
                                    check=1;
                                    break;
                            }    
                                
                        }
                        break;
                }
            } else {
            }
        } else if (cord == 1) { // If the piece belongs to Player 1
            if (turn==1 || free == 1) {
                switch (cord2) { // Checks for legal moves between rows 2-7
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        if (positions[cord2+1][cord1+1] != cord) {
                            switch (positions[cord2+1][cord1+1] + 1) {
                                case 3:
                                    if ((cord2+1) < 7 && cord1+1 < 7) {
                                        if (positions[cord2+2][cord1+2] == 0) {
                                            legalcheck++;
                                            tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1); tstring += '%';
                                            
                                        }
                                    }
                                    break;
                                case 1:
                                    legalcheck++;
                                    tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1);
                                    break;
                            }    
                        }
                        if (positions[cord2-1][cord1+1] != cord) {
                            switch (positions[cord2-1][cord1+1] + 1) {
                                case 3:
                                    if (cord2-2 >= 0 && cord1+2 <= 7) {
                                        if (positions[cord2-2][cord1+2] == 0) {
                                            legalcheck++;
                                            tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                        }
                                    }
                                    break;
                                case 1:
                                    legalcheck++;
                                    tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1);
                                    break;
                            }
                        }
                        if (legalcheck == 0) {
                            check=1;
                            break;
                        }
                        break;
                    case 0: // Checks for legal moves for a piece on an edge of the board
                        if (positions[cord2+1][cord1+1] != cord) {
                            switch (positions[cord2+1][cord1+1] + 1) {
                                case 3:
                                    if ((cord2+1) < 7) {
                                        if (positions[cord2+2][cord1+2] == 0) {
                                            legalcheck++;
                                            tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1); tstring += '%';
                                            
                                        }
                                    }
                                    break;
                                case 1:
                                    legalcheck++;
                                    tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1);
                                    break;
                                default: // If no legal moves available
                                    check=1;
                                    break;
                            }
                        }
                        break;
                    case 7: // Checks for legal moves for a piece on an edge of the board
                        if (positions[cord2-1][cord1+1] != cord) {
                            switch (positions[cord2-1][cord1+1] + 1) {
                                case 3:
                                    if ((cord2+1) < 7) {
                                        if (positions[cord2-2][cord1+2] == 0) {
                                            legalcheck++;
                                            tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                            
                                        }
                                    }
                                    break;
                                case 1:
                                    tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1);
                                    legalcheck++;
                                    break;
                                default:
                                    check=1;
                                    break;
                            }    
                                
                        }
                        break;
                }
            } else {
            }
        } else if (cord == 0) {
            check=1;
        } else if ((cord == 3 && turn == 1) || (cord == 4 && turn == 2) || (free == 1)) { 
        	// Checks for legal moves for player pieces that were promoted to 'kings'
            if (cord1-1 >= 0) {
                if (cord2-1 >= 0) {
                    if (positions[cord2-1][cord1-1] != cord) {
                        switch (positions[cord2-1][cord1-1] + 1) {
                            case 2:
                            case 3:
                                if (cord2-2 >= 0 && cord1-2 >= 0) {
                                    if (positions[cord2-2][cord1-2] == 0) {
                                        legalcheck++;
                                        tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                        
                                    }
                                }
                                break;
                            case 1:
                                tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1);
                                legalcheck++;
                                break;
                            default:
                                check=1;
                                break;
                        }    
                    }
                }
                if (cord2+1 <= 7) {
                    if (positions[cord2+1][cord1-1] != cord) {
                        switch (positions[cord2+1][cord1-1] + 1) {
                            case 2:
                            case 3:
                                if (cord2+2 <= 7 && cord1-2 >= 0) {
                                    if (positions[cord2+2][cord1-2] == 0) {
                                        legalcheck++;
                                        tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1); tstring += '%';
                                        
                                    }
                                }
                                break;
                            case 1:
                                tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1);
                                legalcheck++;
                                break;
                            default:
                                check=1;
                                break;
                        }    
                    }
                }
            }
            if (cord1+1 <= 7) {
                if (cord2-1 >= 0) {
                    if (positions[cord2-1][cord1+1] != cord) {
                        switch (positions[cord2-1][cord1+1] + 1) {
                            case 2:
                            case 3:
                                if (cord2-2 >= 0 && cord1+2 <= 7) {
                                    if (positions[cord2-2][cord1+2] == 0) {
                                        legalcheck++;
                                        tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                        
                                    }
                                }
                                break;
                            case 1:
                                tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1);
                                legalcheck++;
                                break;
                            default:
                                check=1;
                                break;
                        }    
                    }
                }
                if (cord2+1 <= 7) {
                    if (positions[cord2+1][cord1+1] != cord) {
                        switch (positions[cord2+1][cord1+1] + 1) {
                            case 2:
                            case 3:
                                if (cord2+2 <= 7 && cord1+2 <= 7) {
                                    if (positions[cord2+2][cord1+2] == 0) {
                                        legalcheck++;
                                        tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1); tstring += '%';
                                        
                                    }
                                }
                                break;
                            case 1:
                                tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1);
                                legalcheck++;
                                break;
                            default:
                                check=1;
                                break;
                        }    
                    }
                }
            }
        }
        return legalcheck;
    }
    public void print() {
        // This method prints out the game board
    	
    	//Print out top 2 rows
        System.out.println("    1   2   3   4   5   6   7   8 ");
        System.out.println("   --- --- --- --- --- --- --- ---");
        
        //Display board
        for (int col=0; col<8;col++) {
            for (int row=0; row<8;row++) {
                if (row < 7) {
                    if (row==0) {
                        System.out.print(a[col] + " ");
                    }
                    if (positions[row][col] < 3) {
                        System.out.print("| " + positions[row][col] + " ");
                    } else {
                        // If a piece is a king it has a "-K" added and has different syntax to support it
                        System.out.print("|" + (positions[row][col]-2)+"-K");
                    }
                } else {
                    if (positions[row][col] < 3) {
                        System.out.print("| " + positions[row][col] + " |");
                    } else {
                        System.out.print("|" + (positions[row][col]-2)+"-K|");
                    }
                }
            }
            System.out.println("");
            System.out.println("   --- --- --- --- --- --- --- ---");
        }
    }
    public void jumpcountprint() {
        // If a piece can capture more than 1 piece it uses this method for each consecutive jump it performs
        switch (jumpcount) {
            case 0:
                jumpcount++;
                System.out.println("Double jump!");
                break;
            case 1:
                jumpcount++;
                System.out.println("Triple jump!");
                break;
            case 2:
                jumpcount++;
                System.out.println("Quadruple jump!");
                break;
            case 3:
                jumpcount++;
                System.out.println("Quintiple jump!");
                break;
            case 4:
                jumpcount++;
                System.out.println("Sextuple jump!");
                break;
        }
    }
    public int[] main(int[] receiveThis) {
    	
    	// Declare variables for running the game
        int turn = 0;
        int free=0; int robot = 0; int robotturn = 0;
        
        // Set the starting player checkers
    	
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) { 
            	
                //Set player 1 pieces
                if (col == 0 || col == 2) {
                    if (row == 1 ||row == 3 ||row == 5 ||row == 7) {
                        positions[row][col] = 1;
                    }
                }
                else if (col == 1) {
                    if (row == 0 ||row == 2 ||row == 4 ||row == 6) {
                        positions[row][col] = 1;
                    }
                }
                
                //Set player 2 pieces
                else if (col == 5 || col == 7) {
                    if (row == 0 ||row == 2 ||row == 4 ||row == 6) {
                        positions[row][col] = 2;
                    }
                }
                else if (col == 6) {
                    if (row == 1 ||row == 3 ||row == 5 ||row == 7) {
                        positions[row][col] = 2;
                    }
                }
                else {
                        positions[row][col] = 0;
                }
            }
        }
        // Get input. Let user choose game mode and other options
        free = receiveThis[0]; robot = receiveThis[1]; turn = receiveThis[2]; robotturn = receiveThis[3];
        
        // Declare variables
        int turnCheck=0; 
        int winner = 0;
        int gameCondition = 0; int check = 0; 
        
        // Display text for informing which player's turn it is
        while (gameCondition==0) {
            if (check == 0) {
                print();
                switch(turn) {
                    case 1:
                        System.out.println("Player 1's turn!");
                        if (robot == 1) {
                            robotturn = 1;
                        }
                        break;
                    case 2:
                        System.out.println("Player 2's turn!");
                        if (robot == 1) {
                            robotturn = 0;
                        }
                        break;
                }
            }
            if (free == 0) {
                // Checks for legal moves
                int legalmoves=0;
                for (int i=0;i<8;i++) {
                    for (int i2=0;i2<8;i2++) {
                        if (positions[i2][i] == turn) {
                            int checklegal = moveCheck(i2,i,turn);
                            legalmoves += checklegal;
                        }
                    }
                }
                
                //Ends the game if a player has no legal moves on their turn
                if (legalmoves == 0) { 
                	gameCondition = 1;
                    if (turn == 1) {
                        winner = 2;
                    } else {
                        winner = 1;
                    }
                    System.out.println("Player " + turn + " has no legal moves. Player " + winner + " has won!");
                    break;
                }
            }
            
            // Robot for computer mode
  
            //Variables
            int cord1 = 0; int cord2 = 0; int cord3 = 0; int cord4 = 0;
            
            // Robot/AI
            if (robotturn == 1) {
                int[] numberlist = new int[36]; String results = ""; int[] frequency = new int[8];
                for (int i=0;i<36;i++) {
                    numberlist[i] = -2;
                }
                for (int col=0;col<8;col++) {
                    for (int row=0;row<8;row++) {
                        if (positions[col][row] == 1 || positions[col][row] == 3) {
                            String sendTo = row+""+col;
                            String addon = checkMoves(sendTo);
                            results += addon;
                            if (addon.length() > 0) {
                                for (int col2=0;col2<(addon.length() / 5);col2++) {
                                    int z = Integer.parseInt(String.valueOf(addon.charAt(4+(5*col2))));
                                    // this gets the score of the move
                                    Boolean stop = false;
                                    for (int row2=0;row2<36;row2++) {
                                        if (numberlist[row2] == -2 && stop == false) {
                                            numberlist[row2] = z;
                                            stop = true;
                                            frequency[z]++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                int biggest = -2; int biggestindex = -1;
                for (int num=0;num<36;num++) {
                    if (numberlist[num] > biggest) {
                        biggest = numberlist[num];
                        biggestindex = num;
                    }
                }
                if (frequency[biggest+1] > 1) {
                    Boolean stop2 = false;
                    int chance = (int)Math.floor(Math.random()*((frequency[biggest+1])-1+1)+1);
                    for (int col=0;col<(chance-1);col++) {
                        for (int row=0;row<36;row++) {
                            if (stop2 == false) {
                                if (numberlist[row] == biggest) {
                                    numberlist[row] = 0;
                                    stop2 = true;
                                }
                            } else {
                                numberlist[row-1] = numberlist[row];
                                numberlist[row] = 0;
                            }
                        }
                    }
                    stop2 = false;
                    for (int num=0;num<36;num++) {
                        if (stop2 == false && numberlist[num] == biggest) {
                            stop2 = true;
                            biggestindex = num + (chance-1);
                        }
                    }
                    // picks a random move if the highest score has a frequency >1
                }
                String yeah5 = "" + biggest;
                int findbiggest = 4+(5*biggestindex);
                cord1 = results.charAt(findbiggest-4)-48;
                cord2 = results.charAt(findbiggest-3)-48;
                cord3 = results.charAt(findbiggest-2)-48;
                cord4 = results.charAt(findbiggest-1)-48;
            }
            if (turnCheck==0) { // Let user select a piece
                System.out.println("Enter coordinate of piece");
            } else {
                System.out.print("");
                // Weird issue with picking who goes first, would not let the user enter
            }
            String input = "  ";
            if (robotturn == 0) {
                // The program shouldn't wait for an input from the user if the computer is playing
                input = scan.nextLine().toUpperCase();
            }
            Boolean work = false;
            String tstring = ""; int legalcheck = 0;
            /*if (input.equals("END")) {
            // This block is for testing the main file for replayability
                for (int i=0;i<8;i++) {
                    for (int i2=0;i2<8;i2++) {
                        if (positions[i][i2] == 2) {
                            positions[i][i2] = 0;
                        }
                    }
                }
            }*/
            // Error check user input
            if (input.length() > 1) {
                if (robotturn == 0) {
                    char char1 = input.charAt(0); 
                    char char2 = input.charAt(1);
                    cord1 = letters.indexOf(char1);
                    cord2 = numbers.indexOf(char2);
                    if (cord1 > -1) {
                        if (cord2 > -1) {
                            // This checks if the inputs are within 1-8 and A-H. Displays error 
                        	// message to user if inputs are beyond board's boundaries
                            work = true;
                        } else {
                            System.out.println("ERROR: Number is not within board space (1-8)");
                        }
                    } else {
                        System.out.println("ERROR: Letter is not within board space (A-H)");
                    }
                } else {
                    work = true;
                    System.out.println(letters.charAt(cord1)+""+numbers.charAt(cord2));
                }
            } else {check=1; turnCheck=1;}
            
            // This will display to the user what legal moves are available for the piece they selected
            if (work == true) {
                    int cord = positions[cord2][cord1];
                    
                    if (cord == 2) { // For Player 2
                        if (turn == 2 || free == 1) {
                            switch (cord2) {
                                // Check and display legal moves for a piece between rows 2-7
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                    if (positions[cord2-1][cord1-1] != cord) {
                                        switch (positions[cord2-1][cord1-1] + 1) {
                                            case 2:
                                                if ((cord2-1) > 0 && cord1-1 > 0) {
                                                    if (positions[cord2-2][cord1-2] == 0) {
                                                        System.out.println("A piece take from "+letters.charAt(cord1-1)+""+numbers.charAt(cord2-1)+" to " + letters.charAt(cord1-2)+""+numbers.charAt(cord2-2)+" is available.");
                                                        legalcheck++;
                                                        tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                                        
                                                    }
                                                }
                                                break;
                                            case 1:
                                                System.out.println(letters.charAt(cord1-1)+""+numbers.charAt(cord2-1) + " is a legal move.");
                                                legalcheck++;
                                                tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1);
                                                break;
                                        }    
                                            
                                    }
                                    if (positions[cord2+1][cord1-1] != cord) {
                                        switch (positions[cord2+1][cord1-1] + 1) {
                                            case 2:
                                                if ((cord2+1) < 7 && cord1-1 > 0) {
                                                    if (positions[cord2+2][cord1-2] == 0) {
                                                        System.out.println("A piece take from "+letters.charAt(cord1-1)+""+numbers.charAt(cord2+1)+" to " + letters.charAt(cord1-2)+""+numbers.charAt(cord2+2)+" is available.");
                                                        legalcheck++;
                                                        tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1); tstring += '%';
                                                        
                                                    }
                                                }
                                                break;
                                            case 1:
                                                System.out.println(letters.charAt(cord1-1)+""+numbers.charAt(cord2+1) + " is a legal move.");
                                                legalcheck++;
                                                tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1);
                                                break;
                                        }
                                    }
                                    if (legalcheck == 0) { // If piece player selected has no legal moves available
                                        System.out.println("There are no legal moves for this piece!");
                                        check=1;
                                        break;
                                    }
                                    break;
                                case 0: // This is to check for legal moves for a piece in danger of an arrayoutofbound error (On the edge of the board)
                                    if (positions[cord2+1][cord1-1] != cord) {
                                        switch (positions[cord2+1][cord1-1] + 1) {
                                            case 2:
                                                if ((cord2+1) < 7 && cord1-1 > 0) {
                                                    if (positions[cord2+2][cord1-2] == 0) {
                                                        System.out.println("A piece take from "+letters.charAt(cord1-1)+""+numbers.charAt(cord2+1)+" to " + letters.charAt(cord1-2)+""+numbers.charAt(cord2+2)+" is available.");
                                                        legalcheck++;
                                                        tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1); tstring += '%';
                                                        
                                                    }
                                                }
                                                break;
                                            case 1:
                                                System.out.println(letters.charAt(cord1-1)+""+numbers.charAt(cord2+1) + " is a legal move.");
                                                legalcheck++;
                                                tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1);
                                                break;
                                            default: // If piece player selected has no legal moves available
                                                System.out.println("There are no legal moves for this piece!");
                                                check=1;
                                                break;
                                        }
                                    }
                                    break;
                                case 7: // This is to check for legal moves for a piece in danger of an arrayoutofbound error (On the edge of the board)
                                    if (positions[cord2-1][cord-1] != cord) {
                                        switch (positions[cord2-1][cord1-1] + 1) {
                                            case 2:
                                                if ((cord2-1) > 0 && cord1-1 > 0) {
                                                    if (positions[cord2-2][cord1-2] == 0) {
                                                        System.out.println("A piece take from "+letters.charAt(cord1-1)+""+numbers.charAt(cord2-1)+" to " + letters.charAt(cord1-2)+""+numbers.charAt(cord2-2)+" is available.");
                                                        legalcheck++;
                                                        tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                                        
                                                    }
                                                }
                                                break;
                                            case 1:
                                                System.out.println(letters.charAt(cord1-1)+""+numbers.charAt(cord2-1) + " is a legal move.");
                                                tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1);
                                                legalcheck++;
                                                break;
                                            default: // If piece player selected has no legal moves available
                                                System.out.println("There are no legal moves for this piece!");
                                                check=1;
                                                break;
                                        }    
                                    }
                                    break;
                            }
                        } else { // If user chose a piece that isn't owned by them
                            System.out.println("That is not your piece!");
                            check=1;
                        }
                    } else if (cord == 1) { // For Player 1
                        if (turn==1 || free == 1) {
                            switch (cord2) { // Check and display legal moves for a piece between rows 2-7
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                    if (positions[cord2+1][cord1+1] != cord) {
                                        switch (positions[cord2+1][cord1+1] + 1) {
                                            case 3:
                                                if ((cord2+1) < 7 && cord1+1 < 7) {
                                                    if (positions[cord2+2][cord1+2] == 0) {
                                                        System.out.println("A piece take from "+letters.charAt(cord1+1)+""+numbers.charAt(cord2+1)+" to " + letters.charAt(cord1+2)+""+numbers.charAt(cord2+2)+" is available.");
                                                        legalcheck++;
                                                        tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1); tstring += '%';
                                                        
                                                    }
                                                }
                                                break;
                                            case 1:
                                                System.out.println(letters.charAt(cord1+1)+""+numbers.charAt(cord2+1) + " is a legal move.");
                                                legalcheck++;
                                                tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1);
                                                break;
                                        }    
                                    }
                                    if (positions[cord2-1][cord1+1] != cord) {
                                        switch (positions[cord2-1][cord1+1] + 1) {
                                            case 3:
                                                if (cord2-2 >= 0 && cord1+2 <= 7) {
                                                    if (positions[cord2-2][cord1+2] == 0) {
                                                        System.out.println("A piece take from "+letters.charAt(cord1+1)+""+numbers.charAt(cord2-1)+" to " + letters.charAt(cord1+2)+""+numbers.charAt(cord2-2)+" is available.");
                                                        legalcheck++;
                                                        tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                                    }
                                                }
                                                break;
                                            case 1:
                                                System.out.println(letters.charAt(cord1+1)+""+numbers.charAt(cord2-1) + " is a legal move.");
                                                legalcheck++;
                                                tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1);
                                                break;
                                        }
                                    }
                                    // If piece player selected has no legal moves available
                                    if (legalcheck == 0) { 
                                        System.out.println("There are no legal moves for this piece!");
                                        check=1;
                                        break;
                                    }
                                    break;
                                    
                                case 0: // This is to check for legal moves for a piece in danger of an arrayoutofbound error (On the edge of the board)
                                    if (positions[cord2+1][cord1+1] != cord) {
                                        switch (positions[cord2+1][cord1+1] + 1) {
                                            case 3:
                                                if ((cord2+1) < 7) {
                                                    if (positions[cord2+2][cord1+2] == 0) {
                                                        System.out.println("A piece take from "+letters.charAt(cord1+1)+""+numbers.charAt(cord2+1)+" to " + letters.charAt(cord1+2)+""+numbers.charAt(cord2+2)+" is available.");
                                                        legalcheck++;
                                                        tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1); tstring += '%';
                                                        
                                                    }
                                                }
                                                break;
                                            case 1:
                                                System.out.println(letters.charAt(cord1+1)+""+numbers.charAt(cord2+1) + " is a legal move.");
                                                legalcheck++;
                                                tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1);
                                                break;
                                            default: // If piece player selected has no legal moves available
                                                System.out.println("There are no legal moves for this piece!");
                                                check=1;
                                                break;
                                        }
                                    }
                                    break;
                                case 7: // This is to check for legal moves for a piece in danger of an arrayoutofbound error (On the edge of the board)
                                    if (positions[cord2-1][cord1+1] != cord) {
                                        switch (positions[cord2-1][cord1+1] + 1) {
                                            case 3:
                                                if ((cord2+1) < 7) {
                                                    if (positions[cord2-2][cord1+2] == 0) {
                                                        System.out.println("A piece take from "+letters.charAt(cord1+1)+""+numbers.charAt(cord2-1)+" to " + letters.charAt(cord1+2)+""+numbers.charAt(cord2-2)+" is available.");
                                                        legalcheck++;
                                                        tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                                        
                                                    }
                                                }
                                                break;
                                            case 1:
                                                System.out.println(letters.charAt(cord1+1)+""+numbers.charAt(cord2-1) + " is a legal move.");
                                                tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1);
                                                legalcheck++;
                                                break;
                                            default: // If piece player selected has no legal moves available
                                                System.out.println("There are no legal moves for this piece!");
                                                check=1;
                                                break;
                                        }    
                                            
                                    }
                                    break;
                            }
                        } else { // If player chose a piece that isn't owned by them
                            System.out.println("That is not your piece!");
                            check=1;
                        }
                    } else if (cord == 0) { // If player entered a coordinate with no piece on it (empty square)
                        System.out.println("There is no checker piece at this spot! (" +letters.charAt(cord1)+""+numbers.charAt(cord2)+")");
                        print();
                        check=1;
                    } else if ((cord == 3 && turn == 1) || (cord == 4 && turn == 2) || (free == 1)) {
                        // Checks if the piece selected is a king & it is the appropriate turn
                    	// Will display possible legal moves to player
                        if (cord1-1 >= 0) {
                            if (cord2-1 >= 0) {
                                if (positions[cord2-1][cord1-1] != cord) {
                                    switch (positions[cord2-1][cord1-1] + 1) {
                                        case 2:
                                        case 3:
                                            if (cord2-2 >= 0 && cord1-2 >= 0) {
                                                if (positions[cord2-2][cord1-2] == 0) {
                                                    System.out.println("A piece take from "+letters.charAt(cord1-1)+""+numbers.charAt(cord2-1)+" to " + letters.charAt(cord1-2)+""+numbers.charAt(cord2-2)+" is available.");
                                                    legalcheck++;
                                                    tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                                    
                                                }
                                            }
                                            break;
                                        case 1:
                                            System.out.println(letters.charAt(cord1-1)+""+numbers.charAt(cord2-1) + " is a legal move.");
                                            tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1);
                                            legalcheck++;
                                            break;
                                        default: // If piece selected has no legal moves
                                            System.out.println("There are no legal moves for this piece!");
                                            check=1;
                                            break;
                                    }    
                                }
                            }
                            if (cord2+1 <= 7) { // This is to check for legal moves for a king piece in danger of an arrayoutofbound error (On the edge of the board)
                                if (positions[cord2+1][cord1-1] != cord) {
                                    switch (positions[cord2+1][cord1-1] + 1) {
                                        case 2:
                                        case 3:
                                            if (cord2+2 <= 7 && cord1-2 >= 0) {
                                                if (positions[cord2+2][cord1-2] == 0) {
                                                    System.out.println("A piece take from "+letters.charAt(cord1-1)+""+numbers.charAt(cord2+1)+" to " + letters.charAt(cord1-2)+""+numbers.charAt(cord2+2)+" is available.");
                                                    legalcheck++;
                                                    tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1); tstring += '%'; 
                                                }
                                            }
                                            break;
                                        case 1:
                                            System.out.println(letters.charAt(cord1-1)+""+numbers.charAt(cord2+1) + " is a legal move.");
                                            tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1);
                                            legalcheck++;
                                            break;
                                        default: // If piece selected has no legal moves
                                            System.out.println("There are no legal moves for this piece!");
                                            check=1;
                                            break;
                                    }    
                                }
                            }
                        }
                        if (cord1+1 <= 7) { // This is to check for legal moves for a king piece in danger of an arrayoutofbound error (On the edge of the board)
                            if (cord2-1 >= 0) {
                                if (positions[cord2-1][cord1+1] != cord) {
                                    switch (positions[cord2-1][cord1+1] + 1) {
                                        case 2:
                                        case 3:
                                            if (cord2-2 >= 0 && cord1+2 <= 7) {
                                                if (positions[cord2-2][cord1+2] == 0) {
                                                    System.out.println("A piece take from "+letters.charAt(cord1+1)+""+numbers.charAt(cord2-1)+" to " + letters.charAt(cord1+2)+""+numbers.charAt(cord2-2)+" is available.");
                                                    legalcheck++;
                                                    tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                                    
                                                }
                                            }
                                            break;
                                        case 1:
                                            System.out.println(letters.charAt(cord1+1)+""+numbers.charAt(cord2-1) + " is a legal move.");
                                            tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1);
                                            legalcheck++;
                                            break;
                                        default: // If piece selected has no legal moves
                                            System.out.println("There are no legal moves for this piece!");
                                            check=1;
                                            break;
                                    }    
                                }
                            }
                            if (cord2+1 <= 7) { // This is to check for legal moves for a king piece in danger of an arrayoutofbound error (On the edge of the board)
                                if (positions[cord2+1][cord1+1] != cord) {
                                    switch (positions[cord2+1][cord1+1] + 1) {
                                        case 2:
                                        case 3:
                                            if (cord2+2 <= 7 && cord1+2 <= 7) {
                                                if (positions[cord2+2][cord1+2] == 0) {
                                                    System.out.println("A piece take from "+letters.charAt(cord1+1)+""+numbers.charAt(cord2+1)+" to " + letters.charAt(cord1+2)+""+numbers.charAt(cord2+2)+" is available.");
                                                    legalcheck++;
                                                    tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1); tstring += '%';
                                                    
                                                }
                                            }
                                            break;
                                        case 1:
                                            System.out.println(letters.charAt(cord1+1)+""+numbers.charAt(cord2+1) + " is a legal move.");
                                            tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1);
                                            legalcheck++;
                                            break;
                                        default: // If piece selected has no legal moves
                                            System.out.println("There are no legal moves for this piece!");
                                            check=1;
                                            break;
                                    }    
                                }
                            }
                        }
                        if (legalcheck == 0) { // If piece selected has no legal moves
                            System.out.println("There are no legal moves for this piece!");
                        }
                    }
                // Let user enter in target coordinate (Where the selected piece will be moved to)
                if (legalcheck > 0 || robotturn == 1) {
                    int inputCondition=0; // Variable used for rerunning input process again if invalid input was received
                    int legalCheck2=0; // Checks if target coordinate entered by user was valid
                    char char3 = 'a'; char char4 = 'b';
                    while (inputCondition==0) {
                        if (robotturn == 0) {
                            System.out.println("Enter target coordinate");
                            String input2 = scan.nextLine().toUpperCase();
                            char3 = input2.charAt(0); 
                            char4 = input2.charAt(1);
                            cord3 = letters.indexOf(char3);
                            cord4 = numbers.indexOf(char4);
                        } else {
                            // For immersion's sake, the program still displays the same lines but does not read in text when the computer plays
                            System.out.println("Enter target coordinate");
                            char3 = letters.charAt(cord3);
                            char4 = numbers.charAt(cord4);
                            System.out.println(char3+""+char4);
                        }
                        int intcheck = 0;
                        for (int num=0;num<tstring.length();num++) {
                            if ((tstring.length()-num)>1) {
                                if (tstring.charAt(num) == char3) {
                                    if (tstring.charAt(num+1) == char4) {
                                       // Being extra careful to not go out of bounds
                                       if (num+2 < tstring.length()) {
                                           if (tstring.charAt(num+2) == '%') {
                                               intcheck = 2;
                                           } else {
                                               intcheck = 1;
                                           }
                                       } else {
                                           intcheck = 1;
                                       }
                                       break;
                                    }
                                }
                            }
                        }
                        switch (intcheck) {
                            case 1:
                                positions[cord2][cord1] = 0;
                                positions[cord4][cord3] = cord;
                                inputCondition=1;
                                switch(cord3) {
                                    case 0:
                                        if (cord==2) {
                                            positions[cord4][cord3] = 4;
                                        }
                                        break;
                                    case 7:
                                        if (cord==1) {
                                            positions[cord4][cord3] = 3;
                                        }
                                        break;
                                }
                                break;
                            case 2:
                                positions[cord2][cord1] = 0;
                                positions[cord4][cord3] = 0;
                                int cord6 = cord4+(cord4-cord2);
                                int cord5 = cord3+(cord3-cord1);
                                positions[cord6][cord5] = cord;
                                inputCondition=1;
                                Boolean done = false;
                                while (done==false) {
                                    Boolean jumped = false;
                                    if (cord3-cord1 > 0 || cord > 2) {
                                        //if (cord6<6 && cord6>1 && cord5>6 && cord5>1) { <-- These commented if statements need to be removed, too lazy at the moment
                                            if (cord6<6 && cord5<6) {
                                                if (positions[cord6+1][cord5+1] != cord && positions[cord6+1][cord5+1] != 0) {
                                                    if (positions[cord6+2][cord5+2] == 0) {
                                                        print();
                                                        jumpcountprint();
                                                        positions[cord6][cord5] = 0;
                                                        positions[cord6+1][cord5+1] = 0;
                                                        positions[cord6+2][cord5+2] = cord;
                                                        jumped = true;
                                                        cord6 = cord6+2;
                                                        cord5 = cord5+2;
                                                        if (cord5 == 7 && cord == 1) {
                                                            positions[cord6][cord5] = 3;
                                                        }
                                                        check=1;
                                                    }
                                                }
                                            }
                                            if (cord6>1 && cord5<6) {
                                                if (positions[cord6-1][cord5+1] != cord && positions[cord6-1][cord5+1] != 0) {
                                                    if (positions[cord6-2][cord5+2] == 0) {
                                                        if (positions[cord6][cord5] == cord) {
                                                            print();
                                                            jumpcountprint();
                                                            positions[cord6][cord5] = 0;
                                                            positions[cord6-1][cord5+1] = 0;
                                                            positions[cord6-2][cord5+2] = cord;
                                                            jumped = true;
                                                            cord6 = cord6-2;
                                                            cord5 = cord5+2;
                                                            if (cord5 == 7 && cord == 1) {
                                                                positions[cord6][cord5] = 3;
                                                            }
                                                            check=1;
                                                        }
                                                    }
                                                }
                                            }
                                        //}
                                    } if (cord3-cord1 < 0 || cord > 2) {
                                        //if (cord6<6 && cord6>1 && cord5>6 && cord5>1) {
                                            if (cord6>1 && cord5>1) {
                                                if (positions[cord6-1][cord5-1] != cord && positions[cord6-1][cord5-1] != 0) {
                                                    if (positions[cord6-2][cord5-2] == 0) {
                                                        print();
                                                        jumpcountprint();
                                                        positions[cord6][cord5] = 0;
                                                        positions[cord6-1][cord5-1] = 0;
                                                        positions[cord6-2][cord5-2] = cord;
                                                        jumped = true;
                                                        cord6 = cord6-2;
                                                        cord5 = cord5-2;
                                                        if (cord5 == 0 && cord == 2) {
                                                            positions[cord6][cord5] = 4;
                                                        }
                                                        check=1;
                                                    }
                                                }
                                            }
                                            if (cord6<6 && cord5>1) {
                                                if (positions[cord6+1][cord5-1] != cord && positions[cord6+1][cord5-1] != 0) {
                                                    if (positions[cord6+2][cord5-2] == 0) {
                                                        if (positions[cord6][cord5] == cord) {
                                                            print();
                                                            jumpcountprint();
                                                            positions[cord6][cord5] = 0;
                                                            positions[cord6+1][cord5-1] = 0;
                                                            positions[cord6+2][cord5-2] = cord;
                                                            jumped = true;
                                                            cord6 = cord6+2;
                                                            cord5 = cord5-2;
                                                            if (cord5 == 0 && cord == 2) {
                                                                positions[cord6][cord5] = 4;
                                                            }
                                                            check=1;
                                                        }
                                                    }
                                                }
                                            }
                                        //} 
                                    }
                                    if (jumped == false) {
                                        done = true;
                                    }
                                    // Need to check perimeters to allow for multi jumping.
                                    // For instance, is the position out of bounds?
                                    // Perimeters working for now, needs testing
                                }
                                break;
                            default:
                                System.out.println("Invalid move.");
                                if (robotturn == 1) {
                                    positions[-1][-1] = 0;
                                }
                                legalCheck2=1;check=1;
                                break;
                        }
                        if (legalCheck2==0) {
                        	check = 0; turnCheck=0;
                            switch(turn){
                                case 1: turn=2; break;
                                case 2: turn=1; break;
                            }
                            jumpcount = 0;
                        } else {
                        	legalCheck2 = 0;
                        }
                    }
                }
            }
        }
        int[] returnThis = new int[1]; // Required to return value so returning empty int[].
        return returnThis;
    }
    public String checkMoves(String incoming) {
        int cord1 = Integer.parseInt(String.valueOf(incoming.charAt(0)));
        int cord2 = Integer.parseInt(String.valueOf(incoming.charAt(1)));
        int cord = positions[cord2][cord1];
        String tstring = ""; String output = ""; int legalcheck = 0; int check = 0;
        if (cord == 2) {
            if (cord == 2) {
                switch (cord2) {
                    // This is to check if the piece is not in danger of an arrayoutofbound error (is it on the edge of the board?)
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        if (positions[cord2-1][cord1-1] != cord) {
                            switch (positions[cord2-1][cord1-1] + 1) {
                                case 2:
                                    if ((cord2-1) > 0 && cord1-1 > 0) {
                                        if (positions[cord2-2][cord1-2] == 0) {
                                            legalcheck++;
                                            tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                            
                                        }
                                    }
                                    break;
                                case 1:
                                    legalcheck++;
                                    tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1);
                                    break;
                            }    
                                
                        }
                        if (positions[cord2+1][cord1-1] != cord) {
                            switch (positions[cord2+1][cord1-1] + 1) {
                                case 2:
                                    if ((cord2+1) < 7 && cord1-1 > 0) {
                                        if (positions[cord2+2][cord1-2] == 0) {
                                            legalcheck++;
                                            tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1); tstring += '%';
                                            
                                        }
                                    }
                                    break;
                                case 1:
                                    legalcheck++;
                                    tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1);
                                    break;
                            }
                        }
                        if (legalcheck == 0) {
                            check=1;
                            break;
                        }
                        break;
                    case 0:
                        if (positions[cord2+1][cord1-1] != cord) {
                            switch (positions[cord2+1][cord1-1] + 1) {
                                case 2:
                                    if ((cord2+1) < 7 && cord1-1 > 0) {
                                        if (positions[cord2+2][cord1-2] == 0) {
                                            legalcheck++;
                                            tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1); tstring += '%';
                                            
                                        }
                                    }
                                    break;
                                case 1:
                                    legalcheck++;
                                    tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1);
                                    break;
                                default:
                                	check=1;
                                    break;
                            }
                        }
                        break;
                    case 7:
                        if (positions[cord2-1][cord-1] != cord) {
                            switch (positions[cord2-1][cord1-1] + 1) {
                                case 2:
                                    if ((cord2-1) > 0 && cord1-1 > 0) {
                                        if (positions[cord2-2][cord1-2] == 0) {
                                            legalcheck++;
                                            tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                            
                                        }
                                    }
                                    break;
                                case 1:
                                    tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1);
                                    legalcheck++;
                                    break;
                                default:
                                	check=1;
                                    break;
                            }    
                                
                        }
                        break;
                }
            } else {
            }
        } else if (cord == 1) {
            if (cord==1) {
                switch (cord2) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        if (positions[cord2+1][cord1+1] != cord) {
                            switch (positions[cord2+1][cord1+1] + 1) {
                                case 3:
                                    if ((cord2+1) < 7 && cord1+1 < 7) {
                                        if (positions[cord2+2][cord1+2] == 0) {
                                            legalcheck++;
                                            tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1); tstring += '%';
                                            
                                        }
                                    }
                                    break;
                                case 1:
                                    legalcheck++;
                                    tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1);
                                    break;
                            }    
                        }
                        if (positions[cord2-1][cord1+1] != cord) {
                            switch (positions[cord2-1][cord1+1] + 1) {
                                case 3:
                                    if (cord2-2 >= 0 && cord1+2 <= 7) {
                                        if (positions[cord2-2][cord1+2] == 0) {
                                            legalcheck++;
                                            tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                        }
                                    }
                                    break;
                                case 1:
                                    legalcheck++;
                                    tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1);
                                    break;
                            }
                        }
                        if (legalcheck == 0) {
                        	check=1;
                            break;
                        }
                        break;
                    case 0:
                        if (positions[cord2+1][cord1+1] != cord) {
                            switch (positions[cord2+1][cord1+1] + 1) {
                                case 3:
                                    if ((cord2+1) < 7) {
                                        if (positions[cord2+2][cord1+2] == 0) {
                                            legalcheck++;
                                            tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1); tstring += '%';
                                            
                                        }
                                    }
                                    break;
                                case 1:
                                    legalcheck++;
                                    tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1);
                                    break;
                                default:
                                	check=1;
                                    break;
                            }
                        }
                        break;
                    case 7:
                        if (positions[cord2-1][cord1+1] != cord) {
                            switch (positions[cord2-1][cord1+1] + 1) {
                                case 3:
                                    if ((cord2+1) < 7) {
                                        if (positions[cord2-2][cord1+2] == 0) {
                                            legalcheck++;
                                            tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                            
                                        }
                                    }
                                    break;
                                case 1:
                                    tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1);
                                    legalcheck++;
                                    break;
                                default:
                                	check=1;
                                    break;
                            }    
                                
                        }
                        break;
                }
            } else {
            	check=1;
            }
        } else if (cord == 0) {
        	check=1;
        } else if ((cord == 3) || (cord == 4)) {
            if (cord1-1 >= 0) {
                if (cord2-1 >= 0) {
                    if (positions[cord2-1][cord1-1] != cord) {
                        switch (positions[cord2-1][cord1-1] + 1) {
                            case 2:
                            case 3:
                                if (cord2-2 >= 0 && cord1-2 >= 0) {
                                    if (positions[cord2-2][cord1-2] == 0) {
                                        legalcheck++;
                                        tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                        
                                    }
                                }
                                break;
                            case 1:
                                tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2-1);
                                legalcheck++;
                                break;
                            default:
                            	check=1;
                                break;
                        }    
                    }
                }
                if (cord2+1 <= 7) {
                    if (positions[cord2+1][cord1-1] != cord) {
                        switch (positions[cord2+1][cord1-1] + 1) {
                            case 2:
                            case 3:
                                if (cord2+2 <= 7 && cord1-2 >= 0) {
                                    if (positions[cord2+2][cord1-2] == 0) {
                                        legalcheck++;
                                        tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1); tstring += '%';
                                        
                                    }
                                }
                                break;
                            case 1:
                                tstring += letters.charAt(cord1-1); tstring += numbers.charAt(cord2+1);
                                legalcheck++;
                                break;
                            default:
                                check=1;
                                break;
                        }    
                    }
                }
            }
            if (cord1+1 <= 7) {
                if (cord2-1 >= 0) {
                    if (positions[cord2-1][cord1+1] != cord) {
                        switch (positions[cord2-1][cord1+1] + 1) {
                            case 2:
                            case 3:
                                if (cord2-2 >= 0 && cord1+2 <= 7) {
                                    if (positions[cord2-2][cord1+2] == 0) {
                                        legalcheck++;
                                        tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                        
                                    }
                                }
                                break;
                            case 1:
                                tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1);
                                legalcheck++;
                                break;
                            default:
                            	check=1;
                                break;
                        }    
                    }
                }
                if (cord2+1 <= 7) {
                    if (positions[cord2+1][cord1+1] != cord) {
                        switch (positions[cord2+1][cord1+1] + 1) {
                            case 2:
                            case 3:
                                if (cord2+2 <= 7 && cord1+2 <= 7) {
                                    if (positions[cord2+2][cord1+2] == 0) {
                                        legalcheck++;
                                        tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1); tstring += '%';
                                        
                                    }
                                }
                                break;
                            case 1:
                                tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2+1);
                                legalcheck++;
                                break;
                            default:
                            	check=1;
                                break;
                        }    
                    }
                }
            }
            if (legalcheck == 0) {
            }
        }
        if (legalcheck > 0) {
            int inputCondition=0; int legalCheck2=0;
            for (int row=0;row<4;row++) {
                if (tstring.length() == 0) {
                    break;
                }
                int[][] positions2 = new int[8][8];
                for (int row2=0;row2<8;row2++) {
                    for (int col2=0;col2<8;col2++) {
                        positions2[row2][col2] = positions[row2][col2];
                    }
                }
                int intcheck = 0; int score = 0;
                if (tstring.length() > 2) {
                    if (tstring.charAt(2) == '%') {
                        intcheck=2;
                    }
                }
                int cord3 = letters.indexOf(tstring.charAt(0));
                int cord4 = numbers.indexOf(tstring.charAt(1));
                int cord6 = cord4; int cord5 = cord3;
                switch (intcheck) {
                    case 2:
                        positions2[cord2][cord1] = 0;
                        positions2[cord4][cord3] = 0;
                        cord6 = cord4+(cord4-cord2);
                        cord5 = cord3+(cord3-cord1);
                        positions2[cord6][cord5] = cord;
                        score++;
                        /* Debugging multi-jump errors (resolved, issue was that im stupid but keeping this here for future use)
                        System.out.println(letters.charAt(cord5)+""+numbers.charAt(cord6));
                        System.out.println(cord1+" "+cord2+" "+cord3+" "+cord4+" "+cord5+" "+cord6);
                        System.out.println((cord4-cord2)+" "+(cord3-cord1));
                        */
                        inputCondition=1;
                        Boolean done = false;
                        while (done==false) {
                            Boolean jumped = false;
                            if (cord3-cord1 > 0 || cord > 2) {
                                //if (cord6<6 && cord6>1 && cord5>6 && cord5>1) { <-- These commented if statements need to be removed, too lazy at the moment
                                    if (cord6<6 && cord5<6) {
                                        if (positions2[cord6+1][cord5+1] != cord && positions2[cord6+1][cord5+1] != 0) {
                                            if (positions2[cord6+2][cord5+2] == 0) {
                                                positions2[cord6][cord5] = 0;
                                                positions2[cord6+1][cord5+1] = 0;
                                                positions2[cord6+2][cord5+2] = cord;
                                                jumped = true;
                                                cord6 = cord6+2;
                                                cord5 = cord5+2;
                                                if (cord5 == 7 && cord == 1) {
                                                    positions2[cord6][cord5] = 3;
                                                }
                                                check=1;
                                                score++;
                                            }
                                        }
                                    }
                                    if (cord6>1 && cord5<6) {
                                        if (positions2[cord6-1][cord5+1] != cord && positions2[cord6-1][cord5+1] != 0) {
                                            if (positions2[cord6-2][cord5+2] == 0) {
                                                if (positions2[cord6][cord5] == cord) {
                                                    positions2[cord6][cord5] = 0;
                                                    positions2[cord6-1][cord5+1] = 0;
                                                    positions2[cord6-2][cord5+2] = cord;
                                                    jumped = true;
                                                    cord6 = cord6-2;
                                                    cord5 = cord5+2;
                                                    if (cord5 == 7 && cord == 1) {
                                                        positions2[cord6][cord5] = 3;
                                                    }
                                                    check=1;
                                                    score++;
                                                }
                                            }
                                        }
                                    }
                                //}
                            } if (cord3-cord1 < 0 || cord > 2) {
                                //if (cord6<6 && cord6>1 && cord5>6 && cord5>1) {
                                    if (cord6>1 && cord5>1) {
                                        if (positions2[cord6-1][cord5-1] != cord && positions2[cord6-1][cord5-1] != 0) {
                                            if (positions2[cord6-2][cord5-2] == 0) {
                                                positions2[cord6][cord5] = 0;
                                                positions2[cord6-1][cord5-1] = 0;
                                                positions2[cord6-2][cord5-2] = cord;
                                                jumped = true;
                                                cord6 = cord6-2;
                                                cord5 = cord5-2;
                                                if (cord5 == 0 && cord == 2) {
                                                    positions2[cord6][cord5] = 4;
                                                }
                                                check=1;
                                                score++;
                                            }
                                        }
                                    }
                                    if (cord6<6 && cord5>1) {
                                        if (positions2[cord6+1][cord5-1] != cord && positions2[cord6+1][cord5-1] != 0) {
                                            if (positions2[cord6+2][cord5-2] == 0) {
                                                if (positions2[cord6][cord5] == cord) {
                                                    positions2[cord6][cord5] = 0;
                                                    positions2[cord6+1][cord5-1] = 0;
                                                    positions2[cord6+2][cord5-2] = cord;
                                                    jumped = true;
                                                    cord6 = cord6+2;
                                                    cord5 = cord5-2;
                                                    if (cord5 == 0 && cord == 2) {
                                                        positions2[cord6][cord5] = 4;
                                                    }
                                                    check=1;
                                                    score++;
                                                }
                                            }
                                        }
                                    }
                                //} 
                            }
                            if (jumped == false) {
                                done = true;
                            }
                        }
                        break;
                    default:
                        legalCheck2=1;check=1;
                        break;
                }
                Boolean penalty = false;
                // These perimeters need fixing
                if (cord5 > 0 && cord5 < 7 && cord6 > 0 && cord6 < 7) {
                    /*
                    if (positions2[cord6+1][cord5+1] != cord && positions[cord6+1][cord5+1] != 0 && positions[cord6-1][cord5-1] == 0 && penalty = false) {
                        penalty = true;
                        score--;
                    }
                    if (positions2[cord6+1][cord5-1] != cord && positions[cord6+1][cord5-1] != 0 && positions[cord6-1][cord5+1] == 0 && penalty = false) {
                        penalty = true;
                        score--;
                    }
                    if (positions2[cord6-1][cord5+1] != cord && positions[cord6+1][cord5+1] != 0 && positions[cord6+1][cord5-1] == 0 && penalty = false) {
                        penalty = true;
                        score--;
                    }
                    if (positions2[cord6-1][cord5-1] != cord && positions[cord6+1][cord5+1] != 0 && positions[cord6+1][cord5+1] == 0 && penalty = false) {
                        penalty = true;
                        score--;
                    } */ // this shit dont work lol
                }
                output += cord1+""+cord2 + letters.indexOf(tstring.charAt(0)) + numbers.indexOf(tstring.charAt(1)) + score;
                if (tstring.length() > 2) {
                    if (tstring.charAt(2) == '%') {
                        tstring = tstring.substring(3);
                    } else {
                        tstring = tstring.substring(2);
                    }
                    // This removes the transmitted moves from the string to enable easier coding
                } else {
                    tstring = "";
                }
            }
        }
        return (output);
    }
}
