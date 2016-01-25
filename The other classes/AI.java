public class AI extends Player {
    //creates an AI on the xcoor and ycoor of the grid
    //the AI will be identified by class and xcoor and ycoor
    private int enemies;
    private int allies;
    public AI(int xcoor,int ycoor){
        
        super(xcoor,ycoor);
    }
    //follows the standard Conway's game of life rules
    //when transition is finished, the adjacent cells of opposite teams self destruct
    //the population is tallied up after each generation
    //everything is saved to a txt file after every generation
    //terminal prints after x generations
    public void transition(){
        if (checkNumNeighbors < 2 || checkNumNeighbors > 3){
            
        }
        else{ break;}
    }
    //places the shape at the xcoor and ycoor if unoccupied
    //of occupied, try again
    public void placeShape(int xcoor, int ycoor, int shape){
        
    }
    public int[] checkNeighbors(int xcoor,int ycoor){return super.checkNeighbors(xcoor,ycoor);}
    
    //accessor to get neighbors
    //records enemy neighbors and ally neighbors
    public int checkNumNeighbors(int xcoor, int ycoor){
        allies=checkNeighbors(xcoor,ycoor)[1];
        enemies=checkNeighbors(xcoor,ycoor)[0];
        return allies+enemies;       
    }
    
}