public class Patch extends Game {
    protected int xcoor, ycoor;\
    public Patch(xcoor,ycoor){
        grid[xcoor][ycoor]=Patch p;
    }
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
                if(     grid[xcoor-1][ycoor+1] instanceof Person){neighbors[0]=neighbors[0]++;}
                else if(grid[xcoor-1][ycoor+1] instanceof AI){    neighbors[1]=neighbors[1]++;}
                if(     grid[xcoor+1][ycoor-1] instanceof Person){neighbors[0]=neighbors[0]++;}
                else if(grid[xcoor+1][ycoor-1] instanceof AI){    neighbors[1]=neighbors[1]++;}
                if(     grid[xcoor+1][ycoor+1] instanceof Person){neighbors[0]=neighbors[0]++;}
                else if(grid[xcoor+1][ycoor-1] instanceof AI){    neighbors[1]=neighbors[1]++;}
                if(     grid[xcoor-1][ycoor+1] instanceof Person){neighbors[0]=neighbors[0]++;}
                else if(grid[xcoor-1][ycoor-1] instanceof AI){    neighbors[1]=neighbors[1]++;}
            }
        }
        return neighbors;
    }
    
}