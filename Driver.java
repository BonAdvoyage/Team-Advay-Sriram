public class Driver{
    public static void main (String [] args){
        Game g=new Game();
	System.out.println("Printing the grid...");
        System.out.println(g);
	System.out.println("Removing (1,1)...");
	g.clearPatch(1,1);
	System.out.println(g);
	System.out.println(g.Stats());
	
    }
    
}
