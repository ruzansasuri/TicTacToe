/**
 * GameT.java
 * @author: Ruzan Sasuri            rps7183@g.rit.edu
 * @author: Akash Venkatachalam     av2833@g.rit.edu
 * @author: Ghodratollah Aalipour   ga5481@g.rit.edu
 *
 * Creates 2 objects Player, creates a player's board and fills the board and plays the game.
 *
 * Id: $ GameT.java v1.0, 2016/09/19$
 * Revision: First Revision
 */

import java.util.Scanner;
public class GameT
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);//The Scanner object.
        boolean again = true;//Checks if the player wants to play again.
        while(again)
        {
            PlayerT PlayerA = new PlayerT('X');//First player's object.
            PlayerT PlayerB = new PlayerT('O');//Second player's object.
            PlayerA.createTheBoard();
            PlayerA.playGameWith(PlayerB);
            System.out.println("Do you want to play another game?(Y/N)");
            char ch = sc.next().charAt(0);////user's choice to play again.
            if(ch != 'Y')
            {
                System.out.println("You either chose N or something random. Either way Goodbye...");
                again = false;
            }
        }
    }
}

