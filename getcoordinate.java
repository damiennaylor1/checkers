Scanner scan = new Scanner(System.in);
String letters = "ABCDEFGH"; 
String numbers = "12345678";
System.out.println("Enter coordinate");
String input = scan.nextLine().toUpperCase();
char cord1 = input.charAt(0); 
char cord2 = input.charAt(1);
// System.out.println(letters.indexOf(cord1) + " " + numbers.indexOf(cord2));        
if (letters.indexOf(cord1) > -1) {
    if (numbers.indexOf(cord2) > -1) {
        System.out.println("Coordinate is valid");
    } else {
        System.out.println("ERROR: Number is not within board space (1-8)");
    }
} else {
    System.out.println("ERROR: Letter is not within board space (A-H)");
}