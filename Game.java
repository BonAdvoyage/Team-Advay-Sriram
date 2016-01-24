import cs1.Keyboard;

public class Game{
    public Object grid [][] = new Object [20][20];
    protected int turns, generations, AI_Pop, Person_Pop, Unoccupied_Pop;
    protected String difficulty = "";
    protected final String listOfShapes [] =  new String [20];
    protected final int presetCoors [][] = new int [20][20];
 //   protected final int stillLife [][] = new int [20][20];

    public Game(){
        //forloops to set x and y coors to each patch
        for(int row=0;row<grid.length;row++){
            for(int patch=0;patch<row;patch++){
                Patch p=new Unoccupied(row,patch);
                //Unoccupied u=new Unoccupied(row,patch);
                setPatch(row,patch,(Unoccupied)p);
            }
        }
        turns=0; generations=0;
        AI_Pop=4;
        Person_Pop=4;
        Unoccupied_Pop=392;
        difficulty = "Easy";
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
                if (grid [x][y] == 1){ans += "% ";}
                if (grid [x][y] == 2){ans += "# ";}
                if (grid [x][y] == 0){ans += "- ";}
            }
            ans += "\n";
        }
        return ans;
    }
    
    public void setPatch(int xcoor, int ycoor, Patch p){
        //creates a player on that patch
        if (p instanceof Player){
            p=(Player)p;
            if (p instanceof Person){
                p=(Person)p;
                p=new Person(xcoor,ycoor);
                grid[xcoor][ycoor]=p;}
            if (p instanceof AI){
                p=(AI)p;
                p=new AI(xcoor,ycoor);
                grid[xcoor][ycoor]=p;}
        }   
        else if (p instanceof Unoccupied){
            p=(Unoccupied)p;
            p=new Unoccupied(xcoor,ycoor);
            grid[xcoor][ycoor]=p;}
    }
    public void clearPatch(int xcoor, int ycoor){
        //creates an unoccupied on that patch
        Unoccupied o=new Unoccupied(xcoor,ycoor);
        setPatch(xcoor,ycoor,o);
    }
    //win if one population is greater after 1 turn
    public boolean gameOver (){
        if (AI_Pop>Person_Pop){System.out.println("AI wins!"); return true;}
        if (AI_Pop<Person_Pop){System.out.println("Person wins!"); return true;}
        return false;
    }
    public static void main (String [] args){
        Game g=new Game();
        g.toString();
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