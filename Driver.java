import cs1.Keyboard;
import java.io.*;

public class Driver{
    public static void main (String [] args){
        Game g=new Game();
        /*
        g.setGrid(1,0,1);
        g.setGrid(0,1,1);
        g.setGrid(1,1,1);
        g.setGrid(29,0,2);
        g.setGrid(29,1,2);
        g.setGrid(0,29,2);
        g.setGrid(1,29,2);
        g.setGrid(29,29,2);
        */
        g.play();
    }
}
