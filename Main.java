import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    intro();
  }


  public static void intro() {
    Scanner scnr = new Scanner(System.in);
    String input = "";
    
    System.out.println();
    System.out.println("Let's play Tic-Tac-Toe! Enter \"play\" to start!");
    input = scnr.next();

    while(!(input.equals("play"))) {
      System.out.println("Let's play Tic-Tac-Toe! Enter play to start!");
      input = scnr.next();
    }

    if(input.equals("play")) {
      playGame();
    }

    scnr.close();
  }

  public static void playGame() {
    Scanner scnr = new Scanner(System.in);
    int counter = 0;

    int row;
    int column;
    String[][] gridArray = {
    {" ", " ", " "}, 
    {" ", " ", " "}, 
    {" ", " ", " "}
  };

  spacing();

  grid(gridArray);

    while(gameStillInPlay(gridArray)) {
      if(counter == 0) {
        System.out.println("Player 1, make your move." );
        System.out.println("Enter index of row: ");
        row = scnr.nextInt();

        System.out.println("Enter index of column: ");
        column = scnr.nextInt();
        System.out.println();
      }
      else {
        System.out.println("Player 2, make your move." );
        System.out.println("Enter index of row: ");
        row = scnr.nextInt();

        System.out.println("Enter index of column: ");
        column = scnr.nextInt();
        System.out.println();
      }


      if(row == 0) {
        if(column == 0) {
          counter = display(gridArray, row, column, counter);
        }
        else if(column == 1) {
          counter = display(gridArray, row, column, counter);
        }
        else if(column == 2) {
          counter = display(gridArray, row, column, counter);
        }
        else {
          invalidChoice(gridArray);
        }
      }
      else if(row == 1) {
        if(column == 0) {
          counter = display(gridArray, row, column, counter);
        }
        else if(column == 1) {
          counter = display(gridArray, row, column, counter);
        }
        else if(column == 2) {
          counter = display(gridArray, row, column, counter);
        }
        else {
          invalidChoice(gridArray);
        }
      } 
      else if(row == 2) {
        if(column == 0) {
          counter = display(gridArray, row, column, counter);
        }
        else if(column == 1) {
          counter = display(gridArray, row, column, counter);
        }
        else if(column == 2) {
          counter = display(gridArray, row, column, counter);
        }
        else {
          invalidChoice(gridArray);
        }
      }
      else {
        invalidChoice(gridArray);
      }
    }

    counter++;
    scnr.close();
  }



  public static boolean gameStillInPlay(String[][] arr) {
    if(arr[0][0] == "X" && arr[0][1] == "X" && arr[0][2] == "X") {
      gameOverMessage();
      return false;
    }
    else if(arr[0][0] == "X" && arr[1][0] == "X" && arr[2][0] == "X") {
      gameOverMessage();
      return false;
    }
    else if(arr[0][2] == "X" && arr[1][2] == "X" && arr[2][2] == "X") {
      gameOverMessage();
      return false;
    }
    else if(arr[2][0] == "X" && arr[2][1] == "X" && arr[2][2] == "X") {
      gameOverMessage();
      return false;
    }
    else if(arr[0][0] == "O" && arr[1][1] == "O" && arr[2][2] == "O") {
      gameOverMessage();
      return false;
    }
    else if(arr[0][2] == "O" && arr[1][1] == "O" && arr[2][0] == "O") {
      gameOverMessage();
      return false;
    }
    else if (arr[0][1] == "O" && arr[1][1] == "O" && arr[2][1] == "O") {
      gameOverMessage();
      return false;
    }
    else if(arr[0][0] == "O" && arr[0][1] == "O" && arr[0][2] == "O") {
      gameOverMessage();
      return false;
    }
    else if(arr[0][0] == "O" && arr[1][0] == "O" && arr[2][0] == "O") {
      gameOverMessage();
      return false;
    }
    else if(arr[0][2] == "O" && arr[1][2] == "O" && arr[2][2] == "O") {
      gameOverMessage();
      return false;
    }
    else if(arr[2][0] == "O" && arr[2][1] == "O" && arr[2][2] == "O") {
      gameOverMessage();
      return false;
    }
    else if(arr[0][0] == "O" && arr[1][1] == "O" && arr[2][2] == "O") {
      gameOverMessage();
      return false;
    }
    else if(arr[0][2] == "O" && arr[1][1] == "O" && arr[2][0] == "O") {
      gameOverMessage();
      return false;
    }
    else if (arr[0][1] == "O" && arr[1][1] == "O" && arr[2][1] == "O") {
      gameOverMessage();
      return false;
    }
    else if(catsGame(arr) == 9) {
      System.out.println("Cats Game!");
      return false;
    }
    else {
      return true;
    }

  }

public static void grid(String[][] gridArray) {
  for(String[] Row : gridArray) {
      System.out.println(Arrays.toString(Row));
    }
    System.out.println();
}

public static int display(String[][] gridArray, int row, int column, int counter) {
  int tracker = counter;

  if(gridArray[row][column].contains("X") || gridArray[row][column].contains("O")) {
    grid(gridArray);
    System.out.println("Position invalid! Choose again!");
    }
    else {
      if(counter == 0) {
        gridArray[row][column] = "X";
        grid(gridArray);
        tracker++;
      }
      else {
        gridArray[row][column] = "O";
        grid(gridArray);
        tracker--;
      }
    }

    return tracker;
} 

public static void gameOverMessage() {
  System.out.println("Game over!");
  System.out.println();
}

public static void invalidChoice(String[][] gridArray) {
  System.out.println("Invalid Choice!"); 
  grid(gridArray);
}

public static void spacing() {
  System.out.println();
  System.out.println();
}


public static int catsGame(String[][] arr) {
int counter = 0;

  for(int i = 0; i < arr.length; i++) {
    for(int j = 0; j < arr[i].length; j++) {
      if(arr[i][j] != " ") {
        counter++;
      }
    }
  }

  return counter;
}
}