import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class Game{
    public int grid [][] = new int [20][20];
    protected int turns, generations, AI_Pop, Person_Pop, Unoccupied_Pop;
    protected String difficulty = "";
    protected final String listOfShapes [] =  {
        "glider","acorn", "block","blinker","RPentomino",
        "lightSpaceship","mediumSpaceship", "mold","beehive","loaf",
        "eater1", "eater2","tub","prepond", "rabbit", 
        "boat","reflector","toad","diehard", "BHeptomino"};
    protected final int presetCoors [][] = {
        {3, 3, 2, 6, 7, 8, 9},
        {7, 3, 2, 11, 15, 16, 19, 20, 21},
        {2, 2, 1, 2, 3, 4},
        {1, 3, 1, 2, 3},
        {3, 3, 2, 3, 4, 5, 8},
        {5, 5, 2, 5, 6, 11, 15, 16, 17, 18, 19},
        {6, 5, 4, 8, 12, 13, 19, 24, 25, 26, 27, 28, 29},
        {6, 6, 4, 5, 9, 12, 13, 16, 18, 25, 27, 28, 32},
        {4, 3, 2, 3, 5, 8, 10, 11},
        {4, 4, 2, 3, 5, 8, 10, 12, 15},
        {4, 4, 1, 2, 5, 7, 11, 15, 16},
        {7, 7, 4, 6, 7, 9, 10, 11, 13, 14, 15, 23, 24, 25, 27, 28, 32, 34, 39, 41, 47},
        {3, 3, 2, 4, 6, 7},
        {3, 3, 2, 4, 5, 9},
        {7, 3, 1, 5, 6, 7, 8, 9, 10, 13, 16},
        {3, 3, 1, 2, 4, 6, 8},
        {16, 9, 3, 14, 17, 18, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 31, 32, 35, 46},
        {4, 2, 2, 3, 4, 5, 6, 7},
        {8, 3, 7, 9, 10, 18, 22, 23, 24},
        {4, 3, 1, 3, 4, 5, 6, 7, 10}
    };
 

    public Game(){
        
        turns=0; generations=0;
        AI_Pop=4;
        Person_Pop=4;
        Unoccupied_Pop=392;
        difficulty = "Easy";
    	//1 still life bottom left
    	grid[1][1]=1;
    	grid[1][2]=1;
    	grid[2][1]=1;
    	grid[2][2]=1;
    	//AI still life top right
    	grid[17][17]=2;
    	grid[17][18]=2;
    	grid[18][17]=2;
    	grid[18][18]=2;
    }
    
    public String printShapeList(){
        String s="\n";
        for(int x=0;x<listOfShapes.length;x++){
            s+="\t"+x+": "+listOfShapes[x]+"\n";
        }
        return s;
    }
    
    //takes the shape index, 
    //finds the shape coors, 
    //makes sure those spaces are unoccupied
    //transitions to the xcoors and ycoors
    //write the shapes in 1's and then when the AI places the shape, replace all the 1's with twos?
    public void placeShape(int xcoor,int ycoor,int shape){
        //yourimplementation here
    }
    
    public int getGen(){return generations;}
   
    public int getTurn(){return turns;}
   
    public int getPersonPop(){return Person_Pop;}
   
    public int getAIPop(){return AI_Pop;}
   
    public int getUnoccupiedPop(){return Unoccupied_Pop;}
   
    public String getDifficulty(){return difficulty;}
    
    public void setDifficulty(int d){
        if (d==1) difficulty="Easy";
        if (d==2) difficulty="Hard";
    }
    
    public String toString (){
    	String ans = "";
    	for (int y = 19; y > -1; y --){
    	    for (int x = 0; x < 20;x ++ ){
    		if (grid [x][y]==1){ans += "% ";}
    		if (grid [x][y]==2){ans += "# ";}
    		if (grid [x][y]==0){ans += "- ";}
    	    }
    	    ans += "\n";
    	}
    	return ans;
    }
    
    public int[] checkNeighbors(int xcoor, int ycoor){
        int [] neighbors =new int[2];
    	if(     grid[xcoor][ycoor+1]   ==1){neighbors[0]=neighbors[0]++;}
    	else if(grid[xcoor][ycoor+1]   ==2){neighbors[1]=neighbors[1]++;}
    	if(     grid[xcoor][ycoor-1]   ==1){neighbors[0]=neighbors[0]++;}
    	else if(grid[xcoor][ycoor-1]   ==2){neighbors[1]=neighbors[1]++;}
    	if(     grid[xcoor+1][ycoor]   ==1){neighbors[0]=neighbors[0]++;}
    	else if(grid[xcoor+1][ycoor]   ==2){neighbors[1]=neighbors[1]++;}
    	if(     grid[xcoor-1][ycoor]   ==1){neighbors[0]=neighbors[0]++;}
    	else if(grid[xcoor-1][ycoor]   ==2){neighbors[1]=neighbors[1]++;}
    	if(     grid[xcoor-1][ycoor+1] ==1){neighbors[0]=neighbors[0]++;}
    	else if(grid[xcoor-1][ycoor+1] ==2){neighbors[1]=neighbors[1]++;}
    	if(     grid[xcoor+1][ycoor-1] ==1){neighbors[0]=neighbors[0]++;}
    	else if(grid[xcoor+1][ycoor-1] ==2){neighbors[1]=neighbors[1]++;}
    	if(     grid[xcoor+1][ycoor+1] ==1){neighbors[0]=neighbors[0]++;}
    	else if(grid[xcoor+1][ycoor-1] ==2){neighbors[1]=neighbors[1]++;}
    	if(     grid[xcoor-1][ycoor+1] ==1){neighbors[0]=neighbors[0]++;}
    	else if(grid[xcoor-1][ycoor-1] ==2){neighbors[1]=neighbors[1]++;}
        return neighbors;
    }
    public int checkNumNeighbors (int xcoor, int ycoor){
        int [] ans = checkNeighbors (xcoor, ycoor);
        int allies = ans [0];
        int enemies = ans [1];
        return allies + enemies;
    }
    
    public void transition ( ){
        for (int xcoor = 0; xcoor < 20; xcoor ++){
            for (int ycoor = 0; ycoor < 20; ycoor ++){
                if (checkNumNeighbors(xcoor,ycoor) > 3 || checkNumNeighbors(xcoor,ycoor) < 2) {
                    grid [xcoor][ycoor] = 0;
                }
                if (grid [xcoor][ycoor]== 0 && checkNumNeighbors (xcoor, ycoor) == 3){
                    if (checkNeighbors(xcoor, ycoor) [1] > checkNeighbors(xcoor, ycoor) [0]){
                        grid [xcoor] [ycoor] = 1;
                    }
                    else { grid [xcoor][ycoor] = 0;}
                }
            }
        }
    }
    
    public void clearPatch(int xcoor, int ycoor){
        //creates an unoccupied on that patch
    	if (grid[xcoor][ycoor]==1){Person_Pop--;}
    	if (grid[xcoor][ycoor]==2){AI_Pop--;}
        grid[xcoor][ycoor]=0;
    	Unoccupied_Pop++;
    }
    //win if one population is greater after 1 turn
    public boolean gameOver (){
        if  (AI_Pop!=Person_Pop) {return true;}
        return false;
    }
    
    public String Stats(){
    	String s="";
    	s+="stats:";
        s+="\ngenerations:"+getGen();
    	s+="\nturns:"+getTurn();
    	s+="\nPerson population:"+getPersonPop();
    	s+="\nAI population:"+getAIPop();
    	s+="\nUnoccupied population:"+getUnoccupiedPop();
    	s+="\nDifficulty level:"+getDifficulty();
    	return s;
    }
    
    //prints grid  and stats on another file
    public void write(){
        //your implementation here
    }
  /*   
    -transition:
        -handles the rules
        -handles wrapping around the map
    -main:
        -prompts user to choose who to play with
        -what difficulty level
        -print the map (includes the patches that both team start with)
        -print the map after their selections-make selections are over unoccupied squares
        -destroys enemy adjacent cells
        -print the map after 50 generations
        -check if only one team is surviving
    */
    
}