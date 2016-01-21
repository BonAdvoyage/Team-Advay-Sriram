public abstract class Player extends Patch{
    protected void transition();
    //selects the shape corresponding to the shape number
    //sets that shape on the corresponding xcoor and ycoor by transitioning it(all shapes start with (0,0))
    protected void placeShape(int xcoor,int ycoor,int shape);
    public int[] checkNeighbors(int xcoor, int ycoor){
        int[] neighbors=int[2];
        for (int[] xcoor:grid){
            for(int ycoor: xcoor){
                if(     grid[xcoor][ycoor+1] instanceof Person){neighbors[0]=neighbors[0]++;}
                else if(grid[xcoor][ycoor+1] instanceof AI){    neighbors[1]=neighbors[1]++;}
                if(     grid[xcoor][ycoor-1] instanceof Person){neighbors[0]=neighbors[0]++;}
                else if(grid[xcoor][ycoor-1] instanceof AI){    neighbors[1]=neighbors[1]++;}
                if(     grid[xcoor+1][ycoor] instanceof Person){neighbors[0]=neighbors[0]++;}
                else if(grid[xcoor+1][ycoor] instanceof AI){    neighbors[1]=neighbors[1]++;}
                if(     grid[xcoor-1][ycoor] instanceof Person){neighbors[0]=neighbors[0]++;}
                else if(grid[xcoor-1][ycoor] instanceof AI){    neighbors[1]=neighbors[1]++;}
            }
        }
        return neighbors;
    }
}