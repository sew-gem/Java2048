public class Game {  //store actual data of game 

    private int[] [] gameBoard;

    public Game(){
        gameBoard = new int[4][4]; //constructor
    }

    public void printArray(){
        for(int[] x: gameBoard){
            System.out.format("%6d%6d%6d%6d%n", x[0], x[1], x[2], x[3]);
        }
    }

}
