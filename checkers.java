import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        // Set the player checkers
        Scanner scan = new Scanner(System.in);
        int [][] positions = new int[8][8];
        // /*
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) { 
                //Set player 1 pieces
                if (y == 0 || y == 2) {
                    if (x == 1 ||x == 3 ||x == 5 ||x == 7) {
                        positions[x][y] = 1;
                    }
                }
                else if (y == 1) {
                    if (x == 0 ||x == 2 ||x == 4 ||x == 6) {
                        positions[x][y] = 1;
                    }
                }
                //Set player 2 pieces
                else if (y == 5 || y == 7) {
                    if (x == 0 ||x == 2 ||x == 4 ||x == 6) {
                        positions[x][y] = 2;
                    }
                }
                else if (y == 6) {
                    if (x == 1 ||x == 3 ||x == 5 ||x == 7) {
                        positions[x][y] = 2;
                    }
                }
                else {
                        positions[x][y] = 0;
                }
            }
        } // */
        String letters = "ABCDEFGH"; 
        String numbers = "12345678";
        String[] a = {"A","B","C","D","E","F","G","H"};
        int turn = 0;
        /* positions[2][0] = 4;
        positions[3][5] = 2;
        positions[3][3] = 2;
        positions[3][1] = 2;*/
        // This is for testing the multi-jump.
        // The issue so far is that it wants to satisfy overprotective requirements that need to be tweaked.
        // The issues are gone as of current knowledge but edge borders need to be tested to be wary of array outofbounds'
        System.out.println("Welcome to checkers!");
        System.out.println("Would you like to coinflip to decide who goes first, or choose?");
        String CorC = scan.nextLine().toLowerCase();
        if (CorC.equals("coinflip") || CorC.equals("coin flip") || CorC.equals("coin") || CorC.equals("flip")) {
            int chance = (int)(Math.random()*2+1);
            switch(chance) {
                case 1:
                    System.out.println("It is heads. Player 1 goes first.");
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
        int o=0;
        int j = 0; int k = 0; while (j==0) {
            if (k == 0) {
                System.out.println("    1   2   3   4   5   6   7   8 ");
                System.out.println("   --- --- --- --- --- --- --- ---");
                for (int i=0; i<8;i++) {
                    for (int i2=0; i2<8;i2++) {
                        if (i2 < 7) {
                            if (i2==0) {
                                System.out.print(a[i] + " ");
                            }
                            if (positions[i2][i] < 3) {
                                System.out.print("| " + positions[i2][i] + " ");
                            } else {
                                System.out.print("|" + (positions[i2][i]-2)+"-K");
                            }
                        } else {
                            if (positions[i2][i] < 3) {
                                System.out.print("| " + positions[i2][i] + " |");
                            } else {
                                System.out.print("|" + (positions[i2][i]-2)+"-K|");
                            }
                        }
                    }
                    System.out.println("");
                    System.out.println("   --- --- --- --- --- --- --- ---");
                }
                switch(turn) {
                    case 1:
                        System.out.println("Player 1's turn!");
                        break;
                    case 2:
                        System.out.println("Player 2's turn!");
                        break;
                }
            }
            if (o==0) {
                System.out.println("Enter coordinate of piece");
            } else {
                System.out.print("");
            }
            String input = scan.nextLine().toUpperCase();
            if (input.length() > 1) {
                char char1 = input.charAt(0); 
                char char2 = input.charAt(1);
                int cord1 = letters.indexOf(char1);
                int cord2 = numbers.indexOf(char2);
                Boolean work = false;
                int legalcheck = 0;
                String tstring = "";
                if (cord1 > -1) {
                    if (cord2 > -1) {
                        work = true;
                    } else {
                        System.out.println("ERROR: Number is not within board space (1-8)");
                    }
                } else {
                    System.out.println("ERROR: Letter is not within board space (A-H)");
                }
                if (work == true) {
                    // Using logic perimeters, these pieces can be moved if the move is legal.
                    // However this would need to be rewritten to support kings as it is solely to support normal pieces
                    // and has 0 infrastructure to support kings.
                    int cord = positions[cord2][cord1];
                    if (cord == 2) {
                        if (turn == 2) {
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
                                                if ((cord2-1) > 0) {
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
                                                if ((cord2+1) < 7) {
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
                                        k=1;
                                        break;
                                    }
                                    break;
                                case 0:
                                    if (positions[cord2+1][cord1-1] != cord) {
                                        switch (positions[cord2+1][cord1-1] + 1) {
                                            case 2:
                                                if ((cord2+1) < 7) {
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
                                                k=1;
                                                break;
                                        }
                                    }
                                    break;
                                case 7:
                                    if (positions[cord2-1][cord-1] != cord) {
                                        switch (positions[cord2-1][cord1-1] + 1) {
                                            case 2:
                                                if ((cord2-1) > 0) {
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
                                                k=1;
                                                break;
                                        }    
                                            
                                    }
                                    break;
                            }
                        } else {
                            System.out.println("That is not your piece!");
                            k=1;
                        }
                    } else if (cord == 1) {
                        if (turn==1) {
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
                                        }    
                                    }
                                    if (positions[cord2-1][cord1+1] != cord) {
                                        switch (positions[cord2-1][cord1+1] + 1) {
                                            case 3:
                                                if ((cord2-1) > 0) {
                                                    if (cord2-2 >= 0) {
                                                        if (positions[cord2-2][cord1+2] == 0) {
                                                            System.out.println("A piece take from "+letters.charAt(cord1+1)+""+numbers.charAt(cord2-1)+" to " + letters.charAt(cord1+2)+""+numbers.charAt(cord2-2)+" is available.");
                                                            legalcheck++;
                                                            tstring += letters.charAt(cord1+1); tstring += numbers.charAt(cord2-1); tstring += '%';
                                                            
                                                        }
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
                                        k=1;
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
                                                k=1;
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
                                                k=1;
                                                break;
                                        }    
                                            
                                    }
                                    break;
                            }
                        } else {
                            System.out.println("That is not your piece!");
                            k=1;
                        }
                    } else if (cord == 0) {
                        System.out.println("There is no checker piece at this spot! (" +letters.charAt(cord1)+""+numbers.charAt(cord2)+")");
                        k=1;
                    } else if (cord == 3 || cord == 4) {
                        if (cord1-1 >= 0) {
                            if (cord2-1 >= 0) {
                                if (positions[cord2-1][cord1-1] != cord) {
                                    switch (positions[cord2-1][cord1+1] + 1) {
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
                                            k=1;
                                            break;
                                    }    
                                }
                            }
                            if (cord2+1 <= 7) {
                                if (positions[cord2+1][cord1-1] != cord) {
                                    switch (positions[cord2+1][cord1+1] + 1) {
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
                                            k=1;
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
                                            k=1;
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
                                            k=1;
                                            break;
                                    }    
                                }
                            }
                        }
                    }
                    if (legalcheck > 0) {
                        int x=0; int l=0;
                        while (x==0) {
                            System.out.println("Enter target coordinate");
                            String input2 = scan.nextLine().toUpperCase();
                            char char3 = input2.charAt(0); 
                            char char4 = input2.charAt(1);
                            int cord3 = letters.indexOf(char3);
                            int cord4 = numbers.indexOf(char4);
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
                                    x=1;
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
                                    /* Debugging multi-jump errors (resolved, issue was that im stupid but keeping this here for future use)
                                    System.out.println(letters.charAt(cord5)+""+numbers.charAt(cord6));
                                    System.out.println(cord1+" "+cord2+" "+cord3+" "+cord4+" "+cord5+" "+cord6);
                                    System.out.println((cord4-cord2)+" "+(cord3-cord1));
                                    */
                                    x=1;
                                    Boolean done = false;
                                    while (done==false) {
                                        Boolean jumped = false;
                                        if (cord3-cord1 > 0) {
                                            System.out.println("here1");
                                            //if (cord6<6 && cord6>1 && cord5>6 && cord5>1) { <-- These commented if statements need to be removed, too lazy at the moment
                                                System.out.println("here2");
                                                if (cord6<6 && cord5<6) {
                                                    if (positions[cord6+1][cord5+1] != cord && positions[cord6+1][cord5+1] != 0) {
                                                        if (positions[cord6+2][cord5+2] == 0) {
                                                            System.out.println("Double jump possible, being executed.");
                                                            positions[cord6][cord5] = 0;
                                                            positions[cord6+1][cord5+1] = 0;
                                                            positions[cord6+2][cord5+2] = cord;
                                                            jumped = true;
                                                            cord6 = cord6+2;
                                                            cord5 = cord5+2;
                                                        }
                                                    }
                                                }
                                                if (cord6>1 && cord5<6) {
                                                    if (positions[cord6-1][cord5+1] != cord && positions[cord6-1][cord5+1] != 0) {
                                                        if (positions[cord6-2][cord5+2] == 0) {
                                                            if (positions[cord6][cord5] == cord) {
                                                                System.out.println("Double jump possible, being executed.");
                                                                positions[cord6][cord5] = 0;
                                                                positions[cord6-1][cord5+1] = 0;
                                                                positions[cord6-2][cord5+2] = cord;
                                                                jumped = true;
                                                                cord6 = cord6-2;
                                                                cord5 = cord5+2;
                                                            }
                                                        }
                                                    }
                                                }
                                            //}
                                        } else {
                                            System.out.println("here4");
                                            //if (cord6<6 && cord6>1 && cord5>6 && cord5>1) {
                                                System.out.println("here1");
                                                if (cord6>1 && cord5>1) {
                                                    if (positions[cord6-1][cord5-1] != cord && positions[cord6-1][cord5-1] != 0) {
                                                        if (positions[cord6-2][cord5-2] == 0) {
                                                            System.out.println("Double jump possible, being executed.");
                                                            positions[cord6][cord5] = 0;
                                                            positions[cord6-1][cord5-1] = 0;
                                                            positions[cord6-2][cord5-2] = cord;
                                                            jumped = true;
                                                            cord6 = cord6-2;
                                                            cord5 = cord5-2;
                                                        }
                                                    }
                                                }
                                                if (cord6<6 && cord5>1) {
                                                    if (positions[cord6+1][cord5-1] != cord && positions[cord6+1][cord5-1] != 0) {
                                                        if (positions[cord6+2][cord5-2] == 0) {
                                                            if (positions[cord6][cord5] == cord) {
                                                                System.out.println("Double jump possible, being executed.");
                                                                positions[cord6][cord5] = 0;
                                                                positions[cord6+1][cord5-1] = 0;
                                                                positions[cord6+2][cord5-2] = cord;
                                                                jumped = true;
                                                                cord6 = cord6+2;
                                                                cord5 = cord5-2;
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
                                    l=1;k=1;
                                    break;
                            }
                            if (l==0) {
                                k = 0; o=0;
                                switch(turn){
                                    case 1: turn=2; break;
                                    case 2: turn=1; break;
                                }
                            } else {
                                l = 0;
                            }
                        }
                    }
                }
            } else {k=1; o=1;}
        }
    }
}
