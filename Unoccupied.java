public class Unoccupied extends Patch{
    public Unoccupied(int xcoor,int ycoor){ 
        Patch(xcoor,ycoor);
    }
        //for xcoor and ycoors
            //tally up which neighbors are which
                //do somethign with that
    public int[] checkNeighbors(int xcoor, int ycoor){super.checkNeighbors(xcoor,ycoor);}
}