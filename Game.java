import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import cs1.Keyboard;
public class Game{
    public int grid [][] = new int [30][30];
    protected int turns, generations, AI_Pop, Person_Pop, Unoccupied_Pop;
    protected String difficulty = "";
    protected final String listOfShapes [] =  {
        "glider","acorn", "block","blinker","RPentomino",
        "lightSpaceship","mediumSpaceship", "mold","beehive","loaf",
        "eater1", "eater2","tub","prepond", "rabbit", 
        "boat","reflector","toad","diehard", "BHeptomino"};
    protected final int presetCoors [][] = {
        {3, 3, 1, 5, 6, 7, 8},
        {7, 3, 1, 10, 14, 15, 18, 19, 20},
        {2, 2, 0, 1, 2, 3},
        {1, 3, 0, 1, 2},
        {3, 3, 1, 2, 3, 4, 7},
        {5, 5, 1, 4, 5, 10, 14, 15, 16, 17, 18},
        {6, 5, 3, 7, 11, 12, 18, 23, 24, 25, 26, 27, 28},
        {6, 6, 3, 4, 8, 11, 12, 15, 17, 24, 26, 27, 31},
        {4, 3, 1, 2, 4, 7, 11, 10},
        {4, 4, 1, 2, 4, 7, 9, 11, 14},
        {4, 4, 0, 1, 4, 6, 10, 14, 15},
        {7, 7, 3, 5, 6, 8, 9, 10, 12, 13, 14, 22, 23, 24, 26, 27, 31, 33, 38, 40, 46},
        {3, 3, 2, 4, 6, 7},
        {3, 3, 1, 3, 4, 8},
        {7, 3, 0, 4, 5, 6, 7, 8, 9, 12, 15},
        {3, 3, 0, 1, 3, 5, 7},
        {16, 9, 2, 13, 16, 17, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 30, 31, 34, 45},
        {4, 2, 1, 2, 3, 4, 5, 6},
        {8, 3, 6, 8, 9, 17, 21, 22, 23},
        {4, 3, 0, 2, 3, 4, 5, 6, 9}
    };
    protected String [] usableShapes = new String [20];
    protected boolean save;

    public Game(){
        turns=0; generations=0;
        AI_Pop=4;
        Person_Pop=4;
        Unoccupied_Pop=(grid.length*grid.length)-AI_Pop-Person_Pop;
        difficulty = "Easy";
        
    	//1 still life bottom left
    	grid[1][1]=1;
    	grid[1][2]=1;
    	grid[2][1]=1;
    	grid[2][2]=1;
    	//AI still life top right
    	grid[27][27]=2;
    	grid[27][28]=2;
    	grid[28][27]=2;
    	grid[28][28]=2;
    	
    	
    	
    }
    
    public void setGrid(int xcoor,int ycoor, int side){ grid[xcoor][ycoor]=side; }
    
    public String printShapeList(){
        String s="\n";
        for(int x=0;x<listOfShapes.length;x++){
            s+="\t"+x+": "+listOfShapes[x]+"\n";
        }
        return s;
    }
    
    public boolean getSave(){return save;}

    public int getGen(){return generations;}
   
    public int getTurn(){return turns;}
   
    public int getPersonPop(){
        for(int xcoor=0;xcoor<grid.length;xcoor++){
            for(int ycoor=0;ycoor<grid.length;ycoor++){
                if (grid[xcoor][ycoor]==1){Person_Pop++;}
            }
        }
        return Person_Pop;
    }
   
    public int getAIPop(){
        for(int xcoor=0;xcoor<grid.length;xcoor++){
            for(int ycoor=0;ycoor<grid.length;ycoor++){
                if (grid[xcoor][ycoor]==1){AI_Pop++;}
            }
        }
        return AI_Pop;
    }
   
    public int getUnoccupiedPop(){return ((grid.length*grid.length)-AI_Pop-Person_Pop);}
    
    public int getSide(int xcoor,int ycoor){
        if (ycoor >= 29){ycoor = 0+(ycoor % 29);}
        if (ycoor <= 0){ycoor = 29-(ycoor % 29);}
        if (xcoor >= 29){xcoor = 0+(xcoor % 29);}
        if (xcoor <= 0){xcoor = 29-(xcoor % 29);}
        return grid[xcoor][ycoor];
    }
   
    public String getDifficulty(){return difficulty;}
    
    public void setDifficulty(int d){
        if (d==1) difficulty="Easy";
        if (d==2) difficulty="Hard";
    }
    public void AI (){
        if (difficulty == "Easy"){
            String usableShapes [] = {"diehard", "prepond", "eater1", "glider", "toad", "block", "blinker", "beehive"};
        }
        if (difficulty == "Hard"){
            usableShapes = listOfShapes;
        }
    }
    public String toString (){
    	String ans = "";
    	for (int y = 29; y > -1; y --){
    	    for (int x = 0; x < 30;x ++ ){
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
        int yp = ycoor + 1;
        int ym = ycoor - 1; 
        int xp = xcoor + 1;
        int xm = xcoor - 1;
        if (ycoor > 29){ycoor = -1+(ycoor % 29);}
        if (ycoor < 0){ycoor = grid.length+(ycoor % 29);}
        if (xcoor > 29){xcoor = -1+(xcoor % 29);}
        if (xcoor < 0){xcoor = grid.length+(xcoor % 29);}
        if (yp > 29){yp = -1+((yp) % 29);}
        if (ym < 0){ym = grid.length+((ym) % 29);}
        if (xp > 29){xp = -1+((xp) % 29);}
        if (xm < 0){xm = grid.length+((xm) % 29);}
    	if(     getSide(xcoor,yp)==1){neighbors[0]++;}
    	else if(getSide(xcoor,yp)==2){neighbors[1]++;}
    	if(     getSide(xcoor,ym)==1){neighbors[0]++;}
    	else if(getSide(xcoor,ym)==2){neighbors[1]++;}
    	if(     getSide(xp,ycoor)==1){neighbors[0]++;}
    	else if(getSide(xp,ycoor)==2){neighbors[1]++;}
    	if(     getSide(xm,ycoor)==1){neighbors[0]++;}
    	else if(getSide(xm,ycoor)==2){neighbors[1]++;}
    	if(     getSide(xm,yp) ==1){neighbors[0]++;}
    	else if(getSide(xm,yp) ==2){neighbors[1]++;}
    	if(     getSide(xp,ym) ==1){neighbors[0]++;}
    	else if(getSide(xp,ym) ==2){neighbors[1]++;}
    	if(     getSide(xp,yp) ==1){neighbors[0]++;}
    	else if(getSide(xp,ym) ==2){neighbors[1]++;}
    	if(     getSide(xm,yp) ==1){neighbors[0]++;}
    	else if(getSide(xm,ym) ==2){neighbors[1]++;}
        return neighbors;
    }
    public int checkNumNeighbors (int xcoor, int ycoor){
        if (ycoor > 29){ycoor = -1+(ycoor % 29);}
        if (ycoor < 0){ycoor = grid.length+(ycoor % 29);}
        if (xcoor > 29){xcoor = -1+(xcoor % 29);}
        if (xcoor < 0){xcoor = grid.length+(xcoor % 29);}
        int [] ans = checkNeighbors (xcoor, ycoor);
        int allies = ans [0];
        int enemies = ans [1];
        return (allies + enemies);
    }
    
    public void transition (){
        int map [][] = new int [30][30];
        map = grid;
        for (int xcoor = 0; xcoor < 30; xcoor ++){
            for (int ycoor = 0; ycoor < 30; ycoor ++){
                if (checkNumNeighbors(xcoor,ycoor) > 3 || checkNumNeighbors(xcoor,ycoor) < 2) {
                    if (grid[xcoor][ycoor]==1) {map [xcoor][ycoor] = 0; Unoccupied_Pop++; generations++;Person_Pop--;}
                    if (grid[xcoor][ycoor]==2) {map [xcoor][ycoor] = 0; Unoccupied_Pop++; generations++;AI_Pop--;}
                }
                else if (checkNumNeighbors (xcoor, ycoor) == 3 || checkNumNeighbors (xcoor, ycoor) == 2){
                    if ( ! (grid[xcoor][ycoor]==0 ) ){
                        if (checkNeighbors(xcoor, ycoor) [1] > checkNeighbors(xcoor, ycoor) [0]){
                            map [xcoor] [ycoor] = 2; AI_Pop++; generations++; Unoccupied_Pop++;
                        }
                        else if (checkNeighbors(xcoor, ycoor) [1] < checkNeighbors(xcoor, ycoor) [0]){
                            map [xcoor] [ycoor] = 1; Person_Pop++; generations++; Unoccupied_Pop++;
                        }
                    }
                }
            }
        }
        grid = map;
    }
    
    //win if one population is greater after 1 turn
    public boolean gameOver (){
    //    if  ((AI_Pop == 0 || Person_Pop == 0)) {return true;}
       // else if (generations > 1000) {return true;}
        //if (AI_Pop < Person_Pop|| Person_Pop < AI_Pop){return true;}
        if (AI_Pop < ( Person_Pop + 10 ) || Person_Pop < ( AI_Pop + 10 ) ){return true;}
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
    
    public boolean enoughSpace(int shape, int xcoor, int ycoor){
       //int[] coors=presetCoors[shape=coors[1]];
        if (ycoor > 29){ycoor = -1+(ycoor % 29);}
        if (ycoor < 0){ycoor = grid.length+(ycoor % 29);}
        if (xcoor > 29){xcoor = -1+(xcoor % 29);}
        if (xcoor < 0){xcoor = grid.length+(xcoor % 29);}
        int xbox = presetCoors [shape][0];
        int ybox = presetCoors [shape][1];
        for (int a = xcoor; a < xbox; a ++){
            for (int b = ycoor; b < ybox; b ++){
                if (grid [a][b] != 0){
                    System.out.println ("Not enough space. Choose another coor");
                    return false;
                }
            }
        }
        return true;
    }
    
    public void placeShape (int shape, int xcoor, int ycoor, int side){
        int index = shape;
        if (ycoor > 29){ycoor = -1+(ycoor % 29);}
        if (ycoor < 0){ycoor = grid.length+(ycoor % 29);}
        if (xcoor > 29){xcoor = -1+(xcoor % 29);}
        if (xcoor < 0){xcoor = grid.length+(xcoor % 29);}
        int xbox = presetCoors [index][0];
        int ybox = presetCoors [index][1];
        while ( enoughSpace(index,xcoor,ycoor) == true ){break;}
        for (int t = 2; t < presetCoors[index].length; t ++){
            for (int p = xcoor; p < xcoor+xbox; p++){
                for (int q = ycoor; q < ycoor +ybox; q ++){
                    if (q > 29){q = -1+(q % 29);}
                    if (q < 0){q = grid.length+(q % 29);}
                    if (p > 29){p = -1+(p % 29);}
                    if (p < 0){p = grid.length+(p % 29);}
                    if (presetCoors [index][t] == (xbox*(q-ycoor-1) + ycoor*(p-xcoor))){
                        grid [p][q] = side;
                        if(side==1){Person_Pop+=(presetCoors.length-2);Unoccupied_Pop-=(presetCoors.length-2);}
                        if(side==2){AI_Pop+=(presetCoors.length-2);Unoccupied_Pop-=(presetCoors.length-2);}
                    }
                }
            }
        }
        System.out.println(this);
        System.out.println(Stats());
    }//end placeshape
    
    //prints grid and stats on another file
    public void saveFile(){
        String stats=Stats();
        //String map=toString();
        String oldFile="";
        oldFile+=Savefile.readInfo();
        Savefile.writeInfo(oldFile+"\n"+ stats + "\n");
    }
    
    public void play(){
        System.out.print("Please choose a difficulty level: \n\t1: Easy \n\t2: Hard: ");
        String Diff=Keyboard.readString(); setDifficulty(Integer.parseInt(Diff)); 
	    System.out.println("You've selected: "+"\n"+ getDifficulty());
    	System.out.println(Stats());
	    System.out.println("Printing the grid..." + "\n"+ this);
	    if (getDifficulty().equals("Easy")){
            System.out.println("Do you want to save this game in a file? y:Yes n:No: ");
            String Save=Keyboard.readString();
            if(Save.equals("y")){//write to another file
                //File f=new File();
            	//start gameplay
            	save=true;
            	System.out.print("Select a shape:"+printShapeList()+"\nSelection: ");
                String shape=Keyboard.readString();
                int Shape=Integer.parseInt(shape);
            	System.out.println("Select where you want to place the shape:");
            	System.out.print("xcoor:");
                String xcoor=Keyboard.readString();
                int Xcoor=Integer.parseInt(xcoor);
            	System.out.print("ycoor:");
                String ycoor=Keyboard.readString();
                int Ycoor=Integer.parseInt(ycoor);
                while(! (enoughSpace(Shape,Xcoor,Ycoor)) ){
                	System.out.println("Select where you want to place the shape:");
                	System.out.print("xcoor:");
                    String newxcoor=Keyboard.readString();
                    Xcoor=Integer.parseInt(newxcoor);
                	System.out.print("ycoor:");
                    String newycoor=Keyboard.readString();
                    int NewYcoor=Integer.parseInt(newycoor);
                }
                placeShape(Shape,Xcoor,Ycoor,1); turns++;
                Shape=(int)Math.random()*usableShapes.length;
                placeShape(Shape,(int)(Math.random()*grid.length),(int)(Math.random()*grid.length),2);
                System.out.println(this);
                while (generations<5){
                    saveFile();
                    transition();
                }
                while (! (gameOver())){
                    while (generations<10){
                        saveFile();
                        transition();
                    }//end while
                    System.out.println(this);
                }//end while
                
                System.out.println(this);
                if (AI_Pop>Person_Pop){System.out.println("YOU LOSE!");}
                if (AI_Pop<Person_Pop){System.out.println("YOU WIN!");}
                System.out.print("Show stats?:");
                String Stats=Keyboard.readString();
                if (Stats.equals("y")){
                    System.out.println(Stats());
                    System.out.println("Play again?");
                    String newGame=Keyboard.readString();
                    while (newGame.equals("y")){play();break;}
                }//end yesstats
                if (Stats.equals("n")){
                    System.out.println("Play again?");
                    String newGame=Keyboard.readString();
                    while (newGame.equals("y")){play();break;}
                }//end nostats
            }//end yes save
            else if (Save.equals("n")){//continue without writing
            	//start gameplay
            	System.out.print("Select a shape:"+printShapeList()+"\nSelection: ");
                String shape=Keyboard.readString();
                int Shape=Integer.parseInt(shape);
            	System.out.println("Select where you want to place the shape:");
            	System.out.print("xcoor:");
                String xcoor=Keyboard.readString();
                int Xcoor=Integer.parseInt(xcoor);
            	System.out.print("ycoor:");
                String ycoor=Keyboard.readString();
                int Ycoor=Integer.parseInt(ycoor);
                while(! (enoughSpace(Shape,Xcoor,Ycoor)) ){
                	System.out.println("Select where you want to place the shape:");
                	System.out.print("xcoor:");
                    String newxcoor=Keyboard.readString();
                    Xcoor=Integer.parseInt(newxcoor);
                	System.out.print("ycoor:");
                    String newycoor=Keyboard.readString();
                    int NewYcoor=Integer.parseInt(newycoor);
                }
                placeShape(Shape,Xcoor,Ycoor,1); turns++;
                Shape=(int)Math.random()*usableShapes.length;
                placeShape(Shape,(int)(Math.random()*grid.length),(int)(Math.random()*grid.length),2);
                System.out.println(this);
                while (! (gameOver())){
                    while (generations<5){
                        transition();
                    }//end while
                }//end while
                if (AI_Pop>Person_Pop){System.out.println("YOU LOSE!");}
                if (AI_Pop<Person_Pop){System.out.println("YOU WIN!");}
                System.out.print("Show stats?:");
                String Stats=Keyboard.readString();
                if (Stats.equals("y")){
                    System.out.println(Stats());
                    System.out.println("Play again?");
                    String newGame=Keyboard.readString();
                    while (newGame.equals("y")){play();break;}
                }//end yesstats 
                if (Stats.equals("n")){
                    System.out.println("Play again?");
                    String newGame=Keyboard.readString();
                    while (newGame.equals("y")){play();break;}
                }//end no stats
            }//end don't save
	    }//end easy
	    else if (getDifficulty().equals("Hard")){
            System.out.print("Do you want to save this game in a file? y:Yes n:No: ");
            String Save=Keyboard.readString();
            if(Save.equals("y")){//write to another file
                //File f=new File();
            	//start gameplay
            	save=true;
            	System.out.print("Select a shape:"+printShapeList()+"\nSelection: ");
                String shape=Keyboard.readString();
                int Shape=Integer.parseInt(shape);
            	System.out.println("Select where you want to place the shape:");
            	System.out.print("xcoor:");
                String xcoor=Keyboard.readString();
                int Xcoor=Integer.parseInt(xcoor);
            	System.out.print("ycoor:");
                String ycoor=Keyboard.readString();
                int Ycoor=Integer.parseInt(ycoor);
                while(! (enoughSpace(Shape,Xcoor,Ycoor)) ){
                	System.out.println("Select where you want to place the shape:");
                	System.out.print("xcoor:");
                    String newxcoor=Keyboard.readString();
                    Xcoor=Integer.parseInt(newxcoor);
                	System.out.print("ycoor:");
                    String newycoor=Keyboard.readString();
                    int NewYcoor=Integer.parseInt(newycoor);
                }
                placeShape(Shape,Xcoor,Ycoor,1); turns++;
                Shape=(int)Math.random()*usableShapes.length;
                placeShape(Shape,(int)(Math.random()*grid.length),(int)(Math.random()*grid.length),2);
                System.out.println(this);
                while (! (gameOver())){
                    while (generations<5){
                        saveFile();
                        transition();
                    }//end while
                }//end while
                if (AI_Pop>Person_Pop){System.out.println("YOU LOSE!");}
                if (AI_Pop<Person_Pop){System.out.println("YOU WIN!");}
                System.out.print("Show stats?:");
                String Stats=Keyboard.readString();
                if (Stats.equals("y")){
                    System.out.println(Stats());
                    System.out.println("Play again?");
                    String newGame=Keyboard.readString();
                    while (newGame.equals("y")){play();break;}
                }//end stats
                if (Stats.equals("n")){
                    System.out.println("Play again?");
                    String newGame=Keyboard.readString();
                    while (newGame.equals("y")){play();break;}
                }//end dont stats
            }//end save
            else if (Save.equals("n")){//continue without writing
            	//start gameplay
            	System.out.print("Select a shape:"+printShapeList()+"\nSelection: ");
                String shape=Keyboard.readString();
                int Shape=Integer.parseInt(shape);
            	System.out.println("Select where you want to place the shape:");
            	System.out.print("xcoor:");
                String xcoor=Keyboard.readString();
                int Xcoor=Integer.parseInt(xcoor);
            	System.out.print("ycoor:");
                String ycoor=Keyboard.readString();
                int Ycoor=Integer.parseInt(ycoor);
                while(! (enoughSpace(Shape,Xcoor,Ycoor)) ){
                	System.out.println("Select where you want to place the shape:");
                	System.out.print("xcoor:");
                    String newxcoor=Keyboard.readString();
                    Xcoor=Integer.parseInt(newxcoor);
                	System.out.print("ycoor:");
                    String newycoor=Keyboard.readString();
                    int NewYcoor=Integer.parseInt(newycoor);
                }
                placeShape(Shape,Xcoor,Ycoor,1); turns++;
                Shape=(int)Math.random()*usableShapes.length;
                placeShape(Shape,(int)(Math.random()*grid.length),(int)(Math.random()*grid.length),2);
                System.out.println(this);
                while (! (gameOver())){
                    while (generations<5){
                        transition();
                    }//end while
                    System.out.println(this);
                }//end while
                if (AI_Pop>Person_Pop){System.out.println("YOU LOSE!");}
                if (AI_Pop<Person_Pop){System.out.println("YOU WIN!");}
                System.out.print("Show stats?:");
                String Stats=Keyboard.readString();
                if (Stats.equals("y")){
                    System.out.println(Stats());
                    System.out.println("Play again?");
                    String newGame=Keyboard.readString();
                    while (newGame.equals("y")){play();break;}
                }//end showstats
                else if (Stats.equals("n")){
                    System.out.println("Play again?");
                    String newGame=Keyboard.readString();
                    while (newGame.equals("y")){play();break;}
                }//end don't show stats
	        }//end don'tsave
        }//end Hard
    }//end play
}//end game