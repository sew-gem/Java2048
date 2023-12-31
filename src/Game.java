import java.util.ArrayList;
import java.util.Random;

public class Game {  //store actual data of game 

    private int[][] gameBoard; 
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
        int choice = r.nextInt(emptySpacesX.size()); //randomly choose position
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
        boolean[] alreadyCombined = {false, false, false, false};
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
                    else{
                        if(alreadyCombined[X]){ 
                            gameBoard[X+1][y] = value;
                            gameBoard[x][y] = 0;
                        }
                        else{
                        gameBoard[X][y] *= 2;
                        alreadyCombined[X] = true; 
                        gameBoard[x][y] = 0; 
                        }
                    }
                }
            }
        }
    }

    public void pushDown(){
        System.out.println("Pushing down..."); // alert that printing arr[] will be after value has been push up
        boolean[] alreadyCombined = {false, false, false, false};
        //iterate through the collumns [y]
        for(int y = 0; y < 4; y++){
            for(int x = 2; x >= 0; x--){ //for everthing doing backwards
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
                    else{ if(alreadyCombined[X]){ 
                            gameBoard[X-1][y] = value;
                            gameBoard[x][y] = 0;
                        }
                        else{
                        gameBoard[X][y] *= 2;
                        alreadyCombined[X] = true; 
                        gameBoard[x][y] = 0; 
                        }
                    }
                }
            }
        }
    }


    public void pushLeft(){
        System.out.println("Pushing left..."); // alert that printing arr[] will be after value has been push up
        boolean[] alreadyCombined = {false, false, false, false};
        //iterate through the collumns [y]
        for(int x = 0; x < 4; x++){
            for(int y = 1; y < 4; y++){ //for everthing doing backwards
                //determine whether or not it empty
                if(gameBoard[x][y] != 0){
                    int value = gameBoard[x][y];
                    int Y = y-1;
                    while((Y >= 0) && (gameBoard[x][y] == 0)){
                        Y--;
                    }

                    // possible result
                    if(Y == -1){ //add new value at the top right corner
                        gameBoard[x][0] = value;
                        gameBoard[x][y] = 0;
                    }
                    else if(gameBoard[x][Y] != value){ //if 2 value are different >> add value right after the value before
                        gameBoard[x][Y+1] = value;
                        gameBoard[x][y] = 0;
                    }
                    else{ if(alreadyCombined[Y]){ 
                            gameBoard[x][Y+1] = value;
                            gameBoard[x][y] = 0;
                        }
                        else{
                        gameBoard[x][Y] *= 2;
                        alreadyCombined[Y] = true; 
                        gameBoard[x][y] = 0; 
                        }
                    }
                }
            }
        }
    }

    public void pushRight(){
        System.out.println("Pushing right..."); // alert that printing arr[] will be after value has been push up
        boolean[] alreadyCombined = {false, false, false, false};
        //iterate through the collumns [y]
        for(int x = 0; x < 4; x++){
            for(int y = 2; y > 0; y--){ //for everthing doing backwards
                //determine whether or not it empty
                if(gameBoard[x][y] != 0){
                    int value = gameBoard[x][y];
                    int Y = y+1;
                    while((Y <= 3) && (gameBoard[x][y] == 0)){
                        Y++;
                    }

                    // possible result
                    if(Y == 4){ //add new value at the top right corner
                        gameBoard[x][3] = value;
                        gameBoard[x][y] = 0;
                    }
                    else if(gameBoard[x][Y] != value){ //if 2 value are different >> add value right after the value before
                        gameBoard[x][Y-1] = value;
                        gameBoard[x][y] = 0;
                    }
                    else{ if(alreadyCombined[Y]){ 
                            gameBoard[x][Y+1] = value;
                            gameBoard[x][y] = 0;
                        }
                        else{
                        gameBoard[x][Y] *= 2;
                        alreadyCombined[Y] = true; 
                        gameBoard[x][y] = 0; 
                        }
                    }
                    
                }
            }
        }
    }

    
}
  