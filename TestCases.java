/*
Class description - tester class that is used to test the actual logic of the game
@developer - Himanshu Mishra
@date - 7/01/2022

*/
public class TestCases {
      public static void main(String[] args) {
    	  System.out.println("                      !!!!!!!!!WELCOME TO HANGMAN GAME TESTING PHASE!!!!!!!!!");
    	  String[] myWords = {"himanshu","determination","josh","target","google","samuel","horn","player"};
    	  GameMain gm = new GameMain();
    	  gm.game(myWords[1], true);
      }
}
