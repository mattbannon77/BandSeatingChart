import java.util.Scanner;
//------------------------------------------------------------------------------------------------
public class BandSeatingChart {
//------------------------------------------------------------------------------------------------
private static final int MAX_ROWS = 10;
private static final int MAX_POSITIONS_PER_ROW = 8;
private static final int POSITION_WEIGHT_LIMIT = 100;
private static final Scanner keyboard = new Scanner(System.in);

public static double [][] bandArray;
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
            }
        }

        bandArray = new double [numRows][];

        // Array to save each row's character
        char[] rowLetters = new char[numRows];
        char currentLetter = 'A';

        // For loop to increment character
        for (int i = 0; i < numRows; i++){
            rowLetters[i] = currentLetter;
            currentLetter++;
        }

        // For loop to get positions in each row
        for (int i = 0; i < numRows; i++){

            char rowLetter = rowLetters[i];
            System.out.println("Please enter number of positions in row " + rowLetter + ":");
            int numPositions = keyboard.nextInt();

            // While loop to ensure number of positions doesn't exceed 8
            while (numPositions > MAX_POSITIONS_PER_ROW){
                System.out.println("ERROR: Out of range, try again:");
                numPositions = keyboard.nextInt();
            }

            // While loop to ensure number of positions is greater than 0
            while (numPositions < 0) {
                System.out.println("\"ERROR: Out of range, try again:");
                numPositions = keyboard.nextInt();
            }

            bandArray [i] = new double [numPositions];

        }
//------------------------------------------------------------------------------------------------
        // While loop to keep prompting user input until the exit input is given
        boolean exit = false;
        while (exit != true){
            System.out.println("(A)dd, (R)emove, (P)rint, e(X)it: ");
            char answer = keyboard.next().charAt(0);
//------------------------------------------------------------------------------------------------
            // Code for adding a person
          if (Character.toUpperCase(answer) == 'A'){
              int rowIndex;
              char rowLetter;

              while (true){
                  System.out.println("Please enter row letter:");
                  rowLetter = keyboard.next().toUpperCase().charAt(0);

                  rowIndex = -1;
                  for (int i = 0; i < numRows; i++){
                      if (rowLetters[i] == rowLetter){
                          rowIndex = i;
                          break;
                      }
                  }
                  if (rowIndex != -1){
                      break;
                  } else {
                      System.out.println("ERROR: Out of range, try again");
                  }
              }

              System.out.println("Please enter position number (1 to " + bandArray[rowIndex].length + "):");
              int position = keyboard.nextInt();
              if (position < 1 || position > 4) {
                  System.out.println("ERROR: Out of range, try again");
                  position = keyboard.nextInt();
              }
              position--;
              if (bandArray[rowIndex][position] != 0.0) {
                  System.out.println("ERROR: There is already a musician there.");
                  continue;
              }
              System.out.println("Please enter weight (45.0 to 200.0):");
              double weight = keyboard.nextDouble();

              while (weight < 45.0 || weight > 200.0) {
                  System.out.println("ERROR: Out of range, try again");
                  weight = keyboard.nextDouble();
              }
              double rowTotalWeight = 0.0;
              for (int i = 0; i < bandArray[rowIndex].length; i++){
                  rowTotalWeight = rowTotalWeight + bandArray[rowIndex][i];
              }
              if (rowTotalWeight + weight > POSITION_WEIGHT_LIMIT * bandArray[rowIndex].length) {
                  System.out.println("ERROR: That would exceed the average weight limit");
                  continue;
              }
              bandArray[rowIndex][position] = weight;
              System.out.println("****** Musician added");
          } // end of the code for adding a person
//------------------------------------------------------------------------------------------------
          // Code to remove a person
          else if (Character.toUpperCase(answer) == 'R') {
              System.out.println("Please enter row letter:");
              char rowLetter = keyboard.next().charAt(0);
              rowLetter = Character.toUpperCase(rowLetter);

              int rowIndex = -1;
              for (int i = 0; i < numRows; i++) {
                  if (rowLetters[i] == rowLetter) {
                      rowIndex = i;
                      break;
                  }
              }
              if (rowIndex == -1) {
                  System.out.println("ERROR: Out of range, try again");
                  continue;
              }
              System.out.println("Please enter position number (1 to " + bandArray[rowIndex].length + "):");
              int position = keyboard.nextInt();
              if (position < 1 || position > 4) {
                  System.out.println("ERROR: Out of range, try again");
                  continue;
              }
              position--;
              if (bandArray[rowIndex][position] == 0.0) {
                  System.out.println("ERROR: That position is vacant.");
                  continue;
              }
              bandArray[rowIndex][position] = 0.0;
              System.out.println("****** Musician removed.");
            } // End of the code to remove a person
//------------------------------------------------------------------------------------------------
            // Code to print all weights
            else if (Character.toUpperCase(answer) == 'P') {
                printArray();
            } // End of the code to print all weights
//------------------------------------------------------------------------------------------------
            // Code to exit
            else if (Character.toUpperCase(answer) == 'X') {
                exit = true;
                System.out.println("Exiting");
            } // End of code to exit
//------------------------------------------------------------------------------------------------
            // Code to display error for invalid input
            else {
                System.out.println("ERROR: Invalid menu option, try again");
            }
        }
    } // End of the main method
    //------------------------------------------------------------------------------------------------
    // Start if the printArray method
    public static void printArray (){

        for (int i = 0; i < bandArray.length; i++){
            System.out.print((char)(i + 65) + ":");

            double total = 0.0;

            for (int k = 0; k < bandArray[i].length; k++){
                System.out.print(bandArray[i][k] + " ");
                total = total + bandArray[i][k];

            }

            int numPositions = bandArray[i].length;
            double average;

            if (numPositions <= 0){
                average = 0.0;
            }else{
                average = total/numPositions;
            }
            System.out.printf(" [%.1f, %.1f]", total, average);
            System.out.println();

        }

    } // end of the printArray method

} // End of the BandSeatingChart class
