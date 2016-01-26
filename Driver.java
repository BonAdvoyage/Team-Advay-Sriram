import cs1.Keyboard;
import java.io.*;

public class Driver{
    
    public static void main (String [] args){
        Game g=new Game();    	   
        //File savefile = new File("Game.txt"); // new file object
        //Savefile.writeInfo(g.toString()+g.Stats());
        g.play();
    
    }
}
