import java.util.ArrayList;
import java.util.Random;

public class Game {  //store actual data of game 

    private int[] [] gameBoard;
    private Random r = new Random();

    public Game(){
        gameBoard = new int[4][4]; //constructor
    }

    public void printArray(){
        for(int[] x: gameBoard){
            System.out.format("%6d%6d%6d%6d%n", x[0], x[1], x[2], x[3]);
        }
        System.out.format("%n");
    }

    public void addNewNumber(){
        ArrayList<Integer> emptySpacesX = new ArrayList<Integer>();
        ArrayList<Integer> emptySpacesY = new ArrayList<Integer>();
        for(int x = 0; x < 4; x++){
            for (int y = 0; y < 4; y++){
                if(gameBoard[x][y] == 0){
                    int[] c = {x,y};
                    emptySpacesX.add(new Integer(x));
                    emptySpacesY.add(new Integer(y));
                }
            }
        }
        int choice = r.nextInt(emptySpacesX.size());
        int numberChooser = r.nextInt(10); //value 0 - 9
        int newNumber = 1;
        if(numberChooser == 0){
            newNumber = 2;
        }
        int X = emptySpacesX.get(choice);
        int Y = emptySpacesY.get(choice);
        gameBoard[X][Y] = newNumber;
    }

    public void pushUp(){
        System.out.println("Pushing up..."); // alert that printing arr[] will be after value has been push up
        //iterate through the collumns [y]
        for(int y = 0; y < 4; y++){
            for(int x = 1; x < 4; x++){
                //determine whether or not it empty
                if(gameBoard[x][y] != 0){
                    int value = gameBoard[x][y];
                    int X = x;
                    while((X >= 0) && (gameBoard[x][y] != 0)){
                        X--;
                    }

                    // possible result
                    if(X == 4){ //add new value at the very bottom corner
                        gameBoard[3][y] = value;
                        gameBoard[x][y] = 0;
                    }
                    else if(gameBoard[x][y] != value){ //if 2 value are different >> add value right after the value before
                        gameBoard[X+1][y] = value;
                        gameBoard[x][y] = 0;
                    }
                    else{ // duplicated if 2 values are the same
                        gameBoard[X][y] *= 2; 
                        gameBoard[x][y] = 0; 
                    }
                }
            }
        }
    }

    public void pushDown(){
        System.out.println("Pushing down..."); // alert that printing arr[] will be after value has been push up
        //iterate through the collumns [y]
        for(int y = 0; y < 4; y++){
            for(int x = 2; x > -1; x--){ //for everthing doing backwards
                //determine whether or not it empty
                if(gameBoard[x][y] != 0){
                    int value = gameBoard[x][y];
                    int X = x;
                    while((X <= 3) && (gameBoard[x][y] != 0)){
                        X++;
                    }

                    // possible result
                    if(X == -1){ //add new value at the top right corner
                        gameBoard[0][y] = value;
                        gameBoard[x][y] = 0;
                    }
                    else if(gameBoard[x][y] != value){ //if 2 value are different >> add value right after the value before
                        gameBoard[X-1][y] = value;
                        gameBoard[x][y] = 0;
                    }
                    else{ // duplicated if 2 values are the same
                        gameBoard[X][y] *= 2; 
                        gameBoard[x][y] = 0; 
                    }
                }
            }
        }
    }

}
  