import java.utils.Keyboard;

public class Game{
    public int grid [][] = new int [20][20];
    protected int turns, generations, AI_Pop, Person_Pop, Unoccupied_Pop;
    protected String difficulty = "";
    protected final String list [] =  new String [20];
    protected final int preset_coors [][] = new int [20][20];

    public Game(){
        //forloops to set x and y coors to each patch
        for(int[] row:grid){
            for(int patch:row){
                setPatch(row,patch,Unoccupied);
            }
        }
        turns=0; generations=0;
        AI_Pop=4;
        Person_Pop=4;
        Unoccupied_Pop=392;
        difficulty = "Easy";
    }
   
    //methods
    public int getXCoor(){return xcoor;}
    public int getYCoor(){return ycoor;}
    public int getGen(){return generations;}
    public int getTurn(){get turns;}
    public int getPersonPop(){return Person_Pop;}
    public int getAIPop(){return AI_pop;}
    public int getUnoccupiedPop(){return Unoccupied_Pop;}
    public String getDifficulty(){return difficulty;}
    public String toString (){
        String ans = "";
        for (int y = 19; y > -1; y --){
            for (int x = 0; x < 20;x ++ ){
                if (grid [x][y] = 1 ){ ans += "% ";}
                if (grid [x][y] = 2){ans += "# ";}
                if (grid [x][y] = 0){ans += "- ";}
            }
            ans += "\n";
        }
        return ans;
    }
    public void setPatch(int xcoor, int ycoor, Player p){
        //creates a player on that patch
        if p instanceof Person{int[xcoor][ycoor]=Person(xcoor,ycoor);}
        if p instanceof AI{int[xcoor][ycoor]=Person(xcoor,ycoor);}
    }
    public void clearPatch(int xcoor, int ycoor){
        //creates an unoccupied on that patch
        int[xcoor][ycoor]=Unoccupied(xcoor,ycoor);
        
    }
    
  /*   public static void main (String [] args){
        turns = 0; generations = 0;
        System.out.println ("Please select difficulty: Easy, Regular, or Hard");
        if (Keyboard.readint() = "Easy" || Keyboard.readint() =  "Regular" || Keyboard.readint() = "Hard" ){
            difficulty = Keyboard.readint ();
        }
        else{ System.out.println ("That isn't a difficulty; why don't you try again.")}
        System.out.println ("Please select one starting structure; or, enter 'list' for a list of possible structures");
        if (Keyboard.readint() = "list" ){
            difficulty = Keyboard.readint ();
        }
        else{ System.out.println ("That isn't a difficulty; why don't you try again.")}
        
    }
    
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