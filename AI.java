public class AI extends Player {
    //creates an AI on the xcoor and ycoor of the grid
    //the AI will be identified by class and xcoor and ycoor
    public AI(int xcoor,int ycoor){
        Patch a=new Patch(xcoor,ycoor);
    }
    //follows the standard Conway's game of life rules
    //when transition is finished, the adjacent cells of opposite teams self destruct
    //the population is tallied up after each generation
    //everything is saved to a txt file after every generation
    //terminal prints after x generations
    public void transition(){
        if checkNeighbors 
    }
    //places the shape at the xcoor and ycoor if unoccupied
    //of occupied, try again
    public String placeShape(int xcoor, int ycoor, int shape){
        
    }
    public int[] checkNeighbors(int xcoor,int ycoor){ Super.checkNeighbors(xcoor,ycoor);}
    
    public int checkNumNeighbors ();
    
}