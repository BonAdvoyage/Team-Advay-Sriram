
import java.io.PrintWriter;
import java.io.IOException;
public class WriteFile extends Game{ 
    public void writetofile(String filename){
        PrintWriter newgame = new PrintWriter ("newgame.txt", "UTF-8");
        newgame.print (game.toString());
        writer.close ();
    }
    
}