import cs1.Keyboard;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Driver{
    public static void main (String [] args){
        Game g=new Game();
        System.out.println("Please choose a difficulty level:");
        System.out.println("\t1: Easy \n\t2: Hard");
        String Diff=Keyboard.readString();
        g.setDifficulty(Integer.parseInt(Diff)); 
	    System.out.println("You've selected:"+g.getDifficulty());
    	System.out.println(g.Stats());
	    System.out.println("Printing the grid...");
        System.out.println(g);
        System.out.print("Do you want to save this game in a file? 1:Yes 2:No");
        String Save=Keyboard.readString();
        int saved=Integer.parseInt(Save);
        if(saved==1){//write to another file
            //File f=new File();
        	//start gameplay
        	System.out.println("Select a shape:"+g.printShapeList());
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
                //g.write();
            }
        }
        else if (saved==2){//continue without writing
        	//start gameplay
        	System.out.println("Select a shape:"+g.printShapeList());
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
        }
        
    }
    
}
