public abstract class Player extends Patch{
    public Player(int xcoor, int ycoor){super(xcoor,ycoor);}
    protected abstract void transition();
    //selects the shape corresponding to the shape number
    //sets that shape on the corresponding xcoor and ycoor by transitioning it(all shapes start with (0,0))
    protected abstract void placeShape(int xcoor,int ycoor,int shape);
    public int[] checkNeighbors(int xcoor, int ycoor){super.checkNeighbors(xcoor,ycoor);}
}