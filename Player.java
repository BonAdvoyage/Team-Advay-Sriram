public abstract class Player extends Patch{
    protected void transition();
    //selects the shape corresponding to the shape number
    //sets that shape on the corresponding xcoor and ycoor by transitioning it(all shapes start with (0,0))
    protected void placeShape(int xcoor,int ycoor,int shape);
    public int[] checkNeighbors(int xcoor, int ycoor){Super.checkNeighbors(xcoor,ycoor)};
}