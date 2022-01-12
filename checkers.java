import java.util.Scanner;
public class checkers {
    int[][] positions = new int[8][8];
    int jumpcount = 0;
    String[] a = {"A","B","C","D","E","F","G","H"};
    String letters = "ABCDEFGH"; 
    String numbers = "12345678";
    Scanner scan = new Scanner(System.in);
    // Initializing variables that are used in >1 method
    public int moveCheck(int cord2, int cord1, int turn) {
        // This method checks for legal moves and returns how many legal moves it has.
        int cord = positions[cord2][cord1];
        String tstring = "";
        int free = 0; int legalcheck = 0;  int check=0;
        if (cord == 2) {
            if (turn == 2 || free == 1) {
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
                            check = 1;
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
            if (turn==1 || free == 1) {
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
            }
        } else if (cord == 0) {
            check=1;
        } else if ((cord == 3 && turn == 1) || (cord == 4 && turn == 2) || (free == 1)) {
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
        System.out.println("    1   2   3   4   5   6   7   8 ");
        System.out.println("   --- --- --- --- --- --- --- ---");
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
    public void main() {
        // Set the player checkers
        // /*
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
        } // */
        int turn = 0;
        System.out.println("Welcome to checkers!");
        int free=0; int robot = 0; int robotturn = 0;
        System.out.println("Do you wish to enable free play? (no turns)");
        String freeornot = scan.nextLine();
        if (freeornot.toLowerCase().equals("yes")) {
            free = 1;
        } else {
            System.out.println("Would you like to enable the computer opponent?");
            String computerornot = scan.nextLine();
            if (computerornot.toLowerCase().equals("yes")) {
                robot = 1;
            }
            System.out.println("Would you like to coinflip to decide who goes first, or choose?");
            String CorC = scan.nextLine().toLowerCase();
            if (CorC.equals("coinflip") || CorC.equals("coin flip") || CorC.equals("coin") || CorC.equals("flip")) {
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
                        System.out.println("ERROR: Coinflip is less than 1 or greater than 2");
                        System.out.println("Player 2 is chosen due to this error.");
                        // There should be 0 scenarios where this is executed but just in case.
                        break;
                }
            } else if (CorC.equals("choose") || CorC.equals("pick")) {
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
        int turnCheck=0; 
        int winner = 0;
        int gameCondition = 0; int check = 0; 
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
            int cord1 = 0; int cord2 = 0; int cord3 = 0; int cord4 = 0;
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
                for (int i=0;i<36;i++) {
                    if (numberlist[i] > biggest) {
                        biggest = numberlist[i];
                        biggestindex = i;
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
                    for (int i=0;i<36;i++) {
                        if (stop2 == false && numberlist[i] == biggest) {
                            stop2 = true;
                            biggestindex = i + (chance-1);
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
                // I have absolutely no idea why exactly it adds 48 to the value and I should 
                // probably be more way more concerned, but if its not broke dont fix it
                // Theory: something to do with ASCII
            }
            if (turnCheck==0) {
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
            if (input.length() > 1) {
                if (robotturn == 0) {
                    char char1 = input.charAt(0); 
                    char char2 = input.charAt(1);
                    cord1 = letters.indexOf(char1);
                    cord2 = numbers.indexOf(char2);
                    if (cord1 > -1) {
                        if (cord2 > -1) {
                            // This checks if the inputs are within 1-8
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
            if (work == true) {
                    int cord = positions[cord2][cord1];
                    if (cord == 2) {
                        if (turn == 2 || free == 1) {
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
                                    if (legalcheck == 0) {
                                        System.out.println("There are no legal moves for this piece!");
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
                                            default:
                                                System.out.println("There are no legal moves for this piece!");
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
                                            default:
                                                System.out.println("There are no legal moves for this piece!");
                                                check=1;
                                                break;
                                        }    
                                            
                                    }
                                    break;
                            }
                        } else {
                            System.out.println("That is not your piece!");
                            check=1;
                        }
                    } else if (cord == 1) {
                        if (turn==1 || free == 1) {
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
                                    if (legalcheck == 0) {
                                        System.out.println("There are no legal moves for this piece!");
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
                                            default:
                                                System.out.println("There are no legal moves for this piece!");
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
                                            default:
                                                System.out.println("There are no legal moves for this piece!");
                                                check=1;
                                                break;
                                        }    
                                            
                                    }
                                    break;
                            }
                        } else {
                            System.out.println("That is not your piece!");
                            check=1;
                        }
                    } else if (cord == 0) {
                        System.out.println("There is no checker piece at this spot! (" +letters.charAt(cord1)+""+numbers.charAt(cord2)+")");
                        print();
                        check=1;
                    } else if ((cord == 3 && turn == 1) || (cord == 4 && turn == 2) || (free == 1)) {
                        // Checks if the piece is a king & it is the appropriate turn
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
                                        default:
                                            System.out.println("There are no legal moves for this piece!");
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
                                        default:
                                            System.out.println("There are no legal moves for this piece!");
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
                                        default:
                                            System.out.println("There are no legal moves for this piece!");
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
                                        default:
                                            System.out.println("There are no legal moves for this piece!");
                                            check=1;
                                            break;
                                    }    
                                }
                            }
                        }
                        if (legalcheck == 0) {
                            System.out.println("There are no legal moves for this piece!");
                        }
                    }
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
                        for (int i=0;i<tstring.length();i++) {
                            if ((tstring.length()-i)>1) {
                                if (tstring.charAt(i) == char3) {
                                    if (tstring.charAt(i+1) == char4) {
                                       // Being extra careful to not go out of bounds
                                       if (i+2 < tstring.length()) {
                                           if (tstring.charAt(i+2) == '%') {
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
