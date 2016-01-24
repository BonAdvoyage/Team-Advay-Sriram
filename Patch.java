public class Patch extends Game {
    protected int xcoor, ycoor;
    public Patch(int xcoor,int ycoor){
        int[] p={xcoor,ycoor};
        grid[xcoor][ycoor]=p;
        this.xcoor=xcoor;
        this.ycoor=ycoor;
    }
   
    public int getXCoor(){return xcoor;}
   
    public int getYCoor(){return ycoor;}
    
    public int[] checkNeighbors(int xcoor, int ycoor){
        int[] neighbors=new int[2];
            if(     grid[xcoor][ycoor+1] instanceof Person){neighbors[0]  =neighbors[0]++;}
            else if(grid[xcoor][ycoor+1] instanceof AI){    neighbors[1]  =neighbors[1]++;}
            if(     grid[xcoor][ycoor-1] instanceof Person){neighbors[0]  =neighbors[0]++;}
            else if(grid[xcoor][ycoor-1] instanceof AI){    neighbors[1]  =neighbors[1]++;}
            if(     grid[xcoor+1][ycoor] instanceof Person){neighbors[0]  =neighbors[0]++;}
            else if(grid[xcoor+1][ycoor] instanceof AI){    neighbors[1]  =neighbors[1]++;}
            if(     grid[xcoor-1][ycoor] instanceof Person){neighbors[0]  =neighbors[0]++;}
            else if(grid[xcoor-1][ycoor] instanceof AI){    neighbors[1]  =neighbors[1]++;}
            if(     grid[xcoor-1][ycoor+1] instanceof Person){neighbors[0]=neighbors[0]++;}
            else if(grid[xcoor-1][ycoor+1] instanceof AI){    neighbors[1]=neighbors[1]++;}
            if(     grid[xcoor+1][ycoor-1] instanceof Person){neighbors[0]=neighbors[0]++;}
            else if(grid[xcoor+1][ycoor-1] instanceof AI){    neighbors[1]=neighbors[1]++;}
            if(     grid[xcoor+1][ycoor+1] instanceof Person){neighbors[0]=neighbors[0]++;}
            else if(grid[xcoor+1][ycoor-1] instanceof AI){    neighbors[1]=neighbors[1]++;}
            if(     grid[xcoor-1][ycoor+1] instanceof Person){neighbors[0]=neighbors[0]++;}
            else if(grid[xcoor-1][ycoor-1] instanceof AI){    neighbors[1]=neighbors[1]++;}
        return neighbors[] ;
    }
    
}