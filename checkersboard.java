public class checkers {
    public static void main(String args[]) {
    // Set the player checkers
    	int [][] positions = new int[8][8];
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
    	}
        System.out.println("     1    2    3    4    5    6    7    8 ");
        System.out.println("   --- --- --- --- --- --- --- --- --- ---");
        String[] a = {"A","B","C","D","E","F","G","H"};
        for (int i=0; i<8;i++) {
        	for (int i2=0; i2<9;i2++) {
        		if (i < 8) {
        			if (i2==0) {
        				System.out.print(a[i] + " "); // Made this part more efficient
        				System.out.print("|  ");
        			}
        			if (i2 < 8) {
        			            System.out.print(positions[i2][i] + " |  "); //This will display the board pieces
        			} else {
        				//System.out.print("|   ");
        			}
        		} else {
        			System.out.print("| ");
        		}
        	}
        	System.out.println("");
        	System.out.println("   --- --- --- --- --- --- --- --- --- ---");
        }
    }
}
