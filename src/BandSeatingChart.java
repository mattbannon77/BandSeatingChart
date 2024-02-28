import java.util.Scanner;
//------------------------------------------------------------------------------------------------
public class BandSeatingChart {
//------------------------------------------------------------------------------------------------
private static final int MAX_ROWS = 10;
private static final int MAX_POSITIONS_PER_ROW = 8;
private static final int POSITION_WEIGHT_LIMIT = 100;
private static final Scanner keyboard = new Scanner(System.in);
//------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        // Welcome and prompt user to enter number of rows
        System.out.println("Welcome to the Band of the Hour");
        System.out.println("-------------------------------");
        System.out.println("Please enter the number of rows");

        int numRows = keyboard.nextInt();

        // While loop to ensure number of rows doesn't exceed 10
        while (numRows > MAX_ROWS){
            System.out.println("ERROR: Out of range, try again:");
            numRows = keyboard.nextInt();
            // While loop to ensure number of rows is greater than 0
            while (numRows <= 0){
                System.out.println("ERROR: Out of range, try again:");
                numRows = keyboard.nextInt();
            } // End of the nested while loop
        } // End of the initial while loop





    } // End of the main method

} // End of the BandSeatingChart class
