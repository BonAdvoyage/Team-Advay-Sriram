import cs1.Keyboard;

public class Game{
    public Object grid [][] = new Object [20][20];
    protected int turns, generations, AI_Pop, Person_Pop, Unoccupied_Pop;
    protected String difficulty = "";
    protected final String listOfShapes [] =  new String [20];
    protected final int presetCoors [][] = new int [20][20];
 //   protected final int stillLife [][] = new int [20][20];

    public Game(){
        turns=0; generations=0;
        AI_Pop=4;
        Person_Pop=4;
        Unoccupied_Pop=392;
        difficulty = "Easy";
    	//person still life bottom left
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
   
    public int getGen(){return generations;}
   
    public int getTurn(){return turns;}
   
    public int getPersonPop(){return Person_Pop;}
   
    public int getAIPop(){return AI_Pop;}
   
    public int getUnoccupiedPop(){return Unoccupied_Pop;}
   
    public String getDifficulty(){return difficulty;}
    
    public String toString (){
        String ans = "";
        for (int y = 19; y > -1; y --){
            for (int x = 0; x < 20;x ++ ){
                if (grid [x][y] instanceof Person){ans += "% ";}
                if (grid [x][y] instanceof AI){ans += "# ";}
                if (grid [x][y] instanceof Unoccupied){ans += "- ";}
            }
            ans += "\n";
        }
        return ans;
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
        if (AI_Pop>Person_Pop){System.out.println("AI wins!"); return true;}
        if (AI_Pop<Person_Pop){System.out.println("Person wins!"); return true;}
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
    
  /*   
    -transition:
        -handles the rules
        -handles wrapping around the map
    -main:
        -prompts user to choose who to play with
        -what difficulty level
        -print the map (includes the patches that both team start with)
        -ask player1 to select 5 (Should we print each time they select one?)
        -ask player2 to select 5 (Should we print each time they select one?)
        -print the map after their selections-make selections are over unoccupied squares
        -destroys enemy adjacent cells
        -print the map after 50 generations
        -check if only one team is surviving
    */
    
}