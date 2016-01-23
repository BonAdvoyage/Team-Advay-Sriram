public class Person extends Player {
    //creates a Person on the xcoor and ycoor of the grid
    //the Person will be identified by class and xcoor and ycoor
    public Person(int xcoor,int ycoor){
        Person a=new Patch(xcoor,ycoor);
    }
    //follows the standard Conway's game of life rules
    //when transition is finished, the adjacent cells of opposite teams self destruct
    //the population is tallied up after each generation
    //everything is saved to a txt file after every generation
    //terminal prints after x generations
    public void transition(){
        
    }
    //places the shape at the xcoor and ycoor if unoccupied
    //of occupied, try again
    public void placeShape(int xcoor, int ycoor, int shape){
        
    }
    public int[] checkNeighbors(int xcoor,int ycoor){super.checkNeighbors(xcoor,ycoor);}

    public int checkNumNeighbors(int xcoor, int ycoor){
        return checkNeighbors(xcoor,ycoor)[0];       
    }
}