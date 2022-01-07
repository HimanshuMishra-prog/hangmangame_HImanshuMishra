
import java.util.ArrayList;
import java.util.Scanner;

/*
Class description - helper class that is used to create the actual logic of the game
@developer - Himanshu Mishra
@date - 7/01/2022

*/

public class GameComputation {
	Scanner input = null;//to take input from user
	String word = null;//to store word which comes from word retrevial class
	WordRetrevial wordsGet = null; // object to use wordRetrevial Class
	int lives; //we provide only 5 lives
	boolean dotesting = false;
	
	protected void logic(String testing,boolean dotest) {
		  wordsGet = new WordRetrevial();
		  dotesting = dotest;
		  input = new Scanner(System.in);
		  word = wordsGet.getWord();
		  if(dotesting == true)word = testing;
		  char[] wordArray  = word.toCharArray(); //convert the word into a array
		  int n = word.length(); //length of the word
		  lives = 5;
		  
		  StringBuffer temp = new StringBuffer();  //temporay variable to store temp
		  //create a copy of output
		  for(int i=0;i<n;i++) {
			  temp.append('_');
			  System.out.print("_" + "  ");
		  }
		  System.out.println();
		  //this used array is used to keep track of the letters already entered by user
		  ArrayList<Character> used = new ArrayList<Character>(); 
		  while(lives > 0) {
			  boolean found = false;//to check if letter is found or not
			  
			  char current = input.next().charAt(0);//current is used to keep track of current input variable
			  //condition to check if input was invalid
			  
			  current = Character.toLowerCase(current);
			  if(!(current >= 'a' && current <= 'z')) {
				  System.out.println("                #######INVALID INPUT########");
				  continue;
			  }
			  if(used.contains(current)) {
				  System.out.println("           ~!~!~!~!~!~Word already entered~!~!~!~!~!~!~!~!~");
				  continue;
			  }
			  used.add(current);
			  
			  //to check if correct option is entered
			  for(int i=0;i<n;i++) {
				  if(current == wordArray[i]) {
					  temp.delete(i,i+1);
					  temp.insert(i, current);
					  found = true;
					  
				  }
				 
			  }
			  
			  //didnt found the correct letter so player lost
			  if(found == false) {
				 lives--; 
				 System.out.println("          !~!~!~!~!~!wrong choice!~!~!~!~!~!");
				 
			  }
			  //print new array created
			  for(int i=0;i<n;i++) {
				  	System.out.print(temp.charAt(i) + "  ");
			  }
			  
			  //next lines are just used to print status
			  System.out.print("                ");
			  System.out.println("       *****You have "+lives+" lives left******");
			  
			  //check if the player found all letters before his lives are exhausted
			  if(temp.toString().indexOf('_') == -1) {
				  System.out.println("                       !!!!!!Congrats you have found the word!!!!!!!!");
				  return;
				  
			  }
			  //lives exhausteed and player lost
			  if(lives == 0) {
				  System.out.println("                          !!!!!!!You lost The man is hanged!!!!!!!");
				  System.out.println("The correcct word was :"+ word);
			  }
			  
			  System.out.println();
		  }
		 
	  }
}
