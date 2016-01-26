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
        System.out.println(g);
        System.out.println(g.enoughSpace(0,3,3));
        g.placeShape(0,3,3,1);
        System.out.println(g);
        */
        
        //System.out.println(g.getSide(1,1));//1
        //System.out.println(g.getSide(0,0));//0
        //System.out.println(g.getSide(28,28));//2
        //System.out.println(g.checkNumNeighbors(0,0));//8
        //System.out.println(g.checkNumNeighbors(1,1));//3
        //System.out.println(g.checkNumNeighbors(30,30));//8
        //g.transition();
        //System.out.println(g);
        g.play();
    }
}
