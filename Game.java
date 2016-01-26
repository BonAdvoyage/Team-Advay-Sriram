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
   
    public int getPersonPop(){return Person_Pop;}
   
    public int getAIPop(){return AI_Pop;}
   
    public int getUnoccupiedPop(){return Unoccupied_Pop;}
    
    public int getSide(int xcoor,int ycoor){
        if (ycoor >= 29){ycoor = 1+(ycoor % 30);}
        if (ycoor <= 1){ycoor = 29-(ycoor % 30);}
        if (xcoor >= 29){xcoor = 1+(xcoor % 30);}
        if (xcoor <= 1){xcoor = 29-(xcoor % 30);}
        //return grid[xcoor][ycoor];
        return 1;
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
        if (ycoor >= 29){ycoor = 1+(ycoor % 30);}
        if (ycoor <= 1){ycoor = 29-(ycoor % 30);}
        if (xcoor >= 29){xcoor = 1+(xcoor % 30);}
        if (xcoor <= 1){xcoor = 29-(xcoor % 30);}
        if (yp >= 29){yp = 0+((yp) % 30);}
        if (ym <= 1){ym = 29-((ym) % 30);}
        if (xp >= 29){xp = 1+((xp) % 30);}
        if (xm <= 1){xm = 29-((xm) % 30);}
    	if(     getSide(xcoor,yp)   ==1){neighbors[0]++;}
    	else if(getSide(xcoor,yp)   ==2){neighbors[1]++;}
    	if(     getSide(xcoor,ym)   ==1){neighbors[0]++;}
    	else if(getSide(xcoor,ym)   ==2){neighbors[1]++;}
    	if(     getSide(xp,ycoor)   ==1){neighbors[0]++;}
    	else if(getSide(xp,ycoor)   ==2){neighbors[1]++;}
    	if(     getSide(xm,ycoor)   ==1){neighbors[0]++;}
    	else if(getSide(xm,ycoor)   ==2){neighbors[1]++;}
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
        if (ycoor >= 30){ycoor = 0-(ycoor % 30);}
        if (ycoor <= 0){ycoor = 30-(ycoor % 30);}
        if (xcoor >= 30){xcoor = 0-(xcoor % 30);}
        if (xcoor <= 0){xcoor = 30-(xcoor % 30);}
        int [] ans = checkNeighbors (xcoor, ycoor);
        int allies = ans [0];
        int enemies = ans [1];
        return allies + enemies;
    }
    
    public void transition (){
        //if (ycoor > 30){ycoor = 30-(ycoor-30);}
        //if (xcoor > 30){xcoor = 30-(xcoor - 30);}
        for (int xcoor = 0; xcoor < 30; xcoor ++){
            for (int ycoor = 0; ycoor < 30; ycoor ++){
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
        if (ycoor >= 30){ycoor = 30-(ycoor % 30);}
        if (xcoor >= 30){xcoor = 30-(xcoor % 30);}
    	if (grid[xcoor][ycoor]==1){Person_Pop--;}
    	if (grid[xcoor][ycoor]==2){AI_Pop--;}
        grid[xcoor][ycoor]=0;
    	Unoccupied_Pop++;
    }
    //win if one population is greater after 1 turn
    public boolean gameOver (){
        if  (AI_Pop > Person_Pop || AI_Pop < Person_Pop) {return true;}
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
        int[] coors=presetCoors[shape];
        int xbox=coors[0]; int ybox=coors[1];
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
    
    public void placeShape (String shape, int xcoor, int ycoor, int side){
        int index = 0;
        if (ycoor >= 30){ycoor = 30- (ycoor % 30);}
        if (xcoor >= 30){xcoor = 30- (xcoor % 30);}
        for (int i = 0; i <listOfShapes.length; i ++){
            if (listOfShapes[i] == shape){index = i;}
        }
        int xbox = presetCoors [index][0];
        int ybox = presetCoors [index][1];
        while ( !(enoughSpace(index,xcoor,ycoor)) ){break;}
        /*for (int t = 0; t < ybox ;t++){
            for (int z = 2; z < presetCoors[index].length;z++ ){
                for (int p = xbox; p > 0; p --){
                    if (t == presetCoors [index][z]%presetCoors[index].length){
                        grid [xcoor +((z -2)%presetCoors[index].length)][p] = side;
                    }
                }
            }
        }*/
        for (int t = 2; t < presetCoors[index].length; t ++){
            for (int p = xcoor; p < xcoor+xbox; p++){
                for (int q = ycoor; q < ycoor +ybox; q ++){
                    if (p >= 30){p = 30-(p%30);}
                    if (q >= 30){q = 30-(q%30);}
                    if (presetCoors [index][t] == (xbox*(q-ycoor-1) + p-xcoor)){
                        grid [p][q] = side;
                        }
                    }
                }
            }
        
    }//end placeshape
    
    //prints grid and stats on another file
    public void saveFile(){
        String stats=Stats();
        String map=toString();
        Savefile.writeInfo(map + stats);
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
                String Shape=Keyboard.readString();
            	System.out.println("Select where you want to place the shape:");
            	System.out.print("xcoor:");
                String xcoor=Keyboard.readString();
                int Xcoor=Integer.parseInt(xcoor);
            	System.out.print("ycoor:");
                String ycoor=Keyboard.readString();
                int Ycoor=Integer.parseInt(ycoor);
                placeShape(Shape,Xcoor,Ycoor,1); turns++;
                Shape=listOfShapes[(int)Math.random()*usableShapes.length];
                placeShape(Shape,(int)(Math.random()*grid.length),(int)(Math.random()*grid.length),2);
                System.out.println(this);
                while (! (gameOver())){
                    for (int x=0;x<30;x++){
                        saveFile();
                        transition();
                    }//end for
                }//end while
                System.out.println(this);
                System.out.println(Stats());
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
            }//end no save
            else if (Save.equals("n")){//continue without writing
            	//start gameplay
            	System.out.print("Select a shape:"+printShapeList()+"\nSelection: ");
                String Shape=Keyboard.readString();
            	System.out.println("Select where you want to place the shape:");
            	System.out.print("xcoor:");
                String xcoor=Keyboard.readString();
                int Xcoor=Integer.parseInt(xcoor);
            	System.out.print("ycoor:");
                String ycoor=Keyboard.readString();
                int Ycoor=Integer.parseInt(ycoor);
                placeShape(Shape,Xcoor,Ycoor,1); turns++;
                Shape=listOfShapes[(int)Math.random()*usableShapes.length];
                placeShape(Shape,(int)(Math.random()*grid.length),(int)(Math.random()*grid.length),2);
                System.out.println(this);
                while (! (gameOver())){
                    for (int x=0;x<30;x++){
                        transition();
                    }//end for
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
                String Shape=Keyboard.readString();
            	System.out.println("Select where you want to place the shape:");
            	System.out.print("xcoor:");
                String xcoor=Keyboard.readString();
                int Xcoor=Integer.parseInt(xcoor);
            	System.out.print("ycoor:");
                String ycoor=Keyboard.readString();
                int Ycoor=Integer.parseInt(ycoor);
                placeShape(Shape,Xcoor,Ycoor,1); turns++;
                Shape=listOfShapes[(int)Math.random()*usableShapes.length];
                placeShape(Shape,(int)(Math.random()*grid.length),(int)(Math.random()*grid.length),2);
                System.out.println(this);
                while (! (gameOver())){
                    for (int x=0;x<30;x++){
                        saveFile();
                        transition();
                    }//end for
                    System.out.println(this);
                }//end while
                System.out.println(Stats());
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
                String Shape=Keyboard.readString();
            	System.out.println("Select where you want to place the shape:");
            	System.out.print("xcoor:");
                String xcoor=Keyboard.readString();
                int Xcoor=Integer.parseInt(xcoor);
            	System.out.print("ycoor:");
                String ycoor=Keyboard.readString();
                int Ycoor=Integer.parseInt(ycoor);
                placeShape(Shape,Xcoor,Ycoor,1); turns++;
                Shape=listOfShapes[(int)Math.random()*usableShapes.length];
                placeShape(Shape,(int)(Math.random()*grid.length),(int)(Math.random()*grid.length),2);
                System.out.println(this);
                while (! (gameOver())){
                    for (int x=0;x<30;x++){
                        transition();
                    }//end for
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