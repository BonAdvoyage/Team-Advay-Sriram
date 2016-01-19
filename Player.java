public abstract class Player implements Game{
    protected int xcoor,ycoor;
    protected void transition();
    //selects the shape's number and the xcoor and ycoor
    protected void placeShape(int xcoor,int ycoor,int i);
}