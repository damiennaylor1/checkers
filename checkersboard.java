public class checkersboard {
	public static void main(String args[]) {
		System.out.println("    1   2   3   4   5   6   7   8 ");
		System.out.println("   --- --- --- --- --- --- --- ---");
		String[] a = {"A","B","C","D","E","F","G","H"};
		for (int i=0; i<8;i++) {
			for (int i2=0; i2<9;i2++) {
				if (i < 8) {
					if (i2==0) {
						System.out.print(a[i] + " ");
					}
					System.out.print("|   ");
				} else {
					System.out.print("|   |");
				}
			}
			System.out.println("");
			System.out.println("   --- --- --- --- --- --- --- ---");
		}
	}
}