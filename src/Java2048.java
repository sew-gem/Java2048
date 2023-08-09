 public class JAVA2048{
    public static void main(String[] args){
        Game g = new Game(); //intialized the gameBoard with [4][4]
        g.printArray();
        
        for(int x = 0; x < 3; x++){
            g.addNewNumber();
        }
        g.printArray();
        for(int x = 0; x < 3; x++){ //do this 3 times
            g.addNewNumber();
            g.printArray();
            g.pushUp();
            g.printArray();

            g.addNewNumber();
            g.printArray();
            g.pushDown();
            g.printArray();

            g.addNewNumber();
            g.printArray();
            g.pushLeft();
            g.printArray();
            
            g.addNewNumber();
            g.printArray();
            g.pushRight();
            g.printArray();
        }
    }
 }

  