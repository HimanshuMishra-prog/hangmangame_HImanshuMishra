
import java.util.*;
/*
Class description - main class that executes the game in command prompt
@developer - Himanshu Mishra
@date - 7/01/2022

*/
public class GameMain {
	 GameComputation gcomp  = null; 
	
	 
	 //It creates Game computation object and then calls the logic method continuosly 
	 //until the user wants to stop playing
	
	 
	 public void game(String testing,boolean dotest) {
		 boolean flag = true; //to store user hoice to play or not
		 Scanner choice = new Scanner(System.in); //to take user input
		 gcomp = new GameComputation();
		 while(flag == true) {
			 gcomp.logic(testing,dotest);
			 System.out.println("Want to continue[Y/N] :");
			 String s = choice.next();
			 //if user wants to continue let him continue 
			 if(Character.toLowerCase(s.charAt(0)) == 'y') {}
			 //else put flag false i.e. he wants to stop playing
			 else if(Character.toLowerCase(s.charAt(0)) == 'n') {flag = false;}
			 //user entered invalid choice
			 else {
				 System.out.println("Invalid choice we are aborting the game");
				 flag = false;
			 }
			 if(flag == false) {
				 break;
			 }
		 }
		 System.out.println("thanks for playing");
		 choice.close();//closing the input stream
	  }
      
	 
	 //this is the main method which runs the game	
      public static void main(String[] args) {
    	  System.out.println("                      !!!!!!!!!WELCOME TO HANGMAN GAME!!!!!!!!!");
    	  System.out.println();
    	  System.out.println("           ~~~~~~Please Enter a character~~~~~~");
    	 
    	  System.out.println();
    	  
    	  GameMain gm = new GameMain();
    	  gm.game(null,false);
      }
}
