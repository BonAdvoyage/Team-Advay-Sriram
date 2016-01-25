import cs1.Keyboard;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Driver{
    
    public static void main (String [] args){
        Game g=new Game();
        g.play();
        
        /*
        Game g=new Game();
        System.out.println("Please choose a difficulty level:");
        System.out.println("\t1: Easy \n\t2: Hard");
        String Diff=Keyboard.readString();
        g.setDifficulty(Integer.parseInt(Diff)); 
	    System.out.println("You've selected: "+g.getDifficulty());
    	System.out.println(g.Stats());
	    System.out.println("Printing the grid...");
        System.out.println(g);
        System.out.print("Do you want to save this game in a file? y:Yes n:No: ");
        String Save=Keyboard.readString();
        if(Save.equals("y")){//write to another file
            //File f=new File();
        	//start gameplay
        	System.out.println("Select a shape:"+g.printShapeList()+"\n Selection:");
            String Shape=Keyboard.readString();
        	System.out.println("Select where you want to place the shape:");
        	System.out.print("xcoor:");
            String xcoor=Keyboard.readString();
        	System.out.print("ycoor:");
            String ycoor=Keyboard.readString();
            g.placeShape(Integer.parseInt(xcoor),Integer.parseInt(ycoor),Integer.parseInt(Shape));
            System.out.println(g);
            while (! (g.gameOver())){
                for (int x=0;x<20;x++){
                    g.transition();
                    //g.write();
                }
                System.out.println(g);
            }
            System.out.println(Stats());
            if (AI_Pop>Person_Pop){System.out.println("YOU LOSE!");
            if (AI_Pop<Person_Pop){System.out.println("YOU WIN!");
        }
        else if (Save.equals("n")){//continue without writing
        	//start gameplay
        	System.out.print("Select a shape:"+g.printShapeList()+"\nSelection:");
            String Shape=Keyboard.readString();
        	System.out.println("Select where you want to place the shape:");
        	System.out.print("xcoor:");
            String xcoor=Keyboard.readString();
        	System.out.print("ycoor:");
            String ycoor=Keyboard.readString();
            g.placeShape(Integer.parseInt(xcoor),Integer.parseInt(ycoor),Integer.parseInt(Shape));
            System.out.println(g);
            for (int x=0;x<20;x++){
                g.transition();
            }
            System.out.println(g);
            while (! (g.gameOver())){
                for (int x=0;x<20;x++){
                    g.transition();
                    //g.write();
                }
                System.out.println(g);
            }
            if (AI_Pop>Person_Pop){System.out.println("YOU LOSE!");}
            if (AI_Pop<Person_Pop){System.out.println("YOU WIN!");}
            System.out.print("Show stats?:");
            String Stats=Keyboard.readString();
            if Stats.equals("y"){
                System.out.println(Stats());
                System.out.println("Play again?");
                String newGame=Keyboard.readString();
                if newGame.equals("y"){}
                if newGame.equals("n"){break;}
            }
            if Stats.equals("n"){
                System.out.println("Play again?");
                String newGame=Keyboard.readString();
                if newGame.equals("y"){}
                if newGame.equals("n"){break;}
            }
        }
    */
    
    }
}
