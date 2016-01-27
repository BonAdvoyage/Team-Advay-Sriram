import cs1.Keyboard;
import java.io.*;

public class Driver{
    public static void main (String [] args){
        Game g=new Game();
        
        
        g.setGrid(1,0,1);
        g.setGrid(0,1,1);
        g.setGrid(1,1,1);
        g.setGrid(29,0,2);
        g.setGrid(29,1,2);
        g.setGrid(0,29,2);
        g.setGrid(1,29,2);
        g.setGrid(29,29,2);
        
        
        /*
        g.setGrid(0,0,1);
        g.setGrid(1,0,1);
        g.setGrid(2,0,1);
        g.setGrid(2,1,1);
        g.setGrid(1,2,1);
        */
        
        //g.play();
        System.out.println(g);
        System.out.println(g.readArray(g.checkNeighbors(0,0)));
        System.out.println(g);
        System.out.println(g.readArray(g.checkNeighbors(1,1)));
        /*
        for (int xcoor = 0; xcoor < 30; xcoor ++){
            for (int ycoor = 0; ycoor < 30; ycoor ++){
                if (g.checkNumNeighbors (xcoor, ycoor) == 3) {
                    System.out.println("neighbors of ("+xcoor+","+ycoor+ ")is 3"); }
                //if (g.checkNumNeighbors(xcoor,ycoor) > 3 || g.checkNumNeighbors(xcoor,ycoor) < 2) {
                //    System.out.println("neighbors of ("+xcoor+","+ycoor+ ")is >3 || <2"); }
            }
        }
        */
        g.transition();
        System.out.println(g+g.Stats());
        g.transition();
        System.out.println(g+g.Stats());
    }
}
