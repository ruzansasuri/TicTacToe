/**
 * PlayerT.java
 * @author: Ruzan Sasuri            rps7183@g.rit.edu
 * @author: Akash Venkatachalam     av2833@g.rit.edu
 * @author: Ghodratollah Aalipour   ga5481@g.rit.edu
 *
 * The class that defines each player. Will initialize the player's object with his Board and identifying character.
 *
 * Id: $ PlayerT.java v1.0, 2016/09/19$
 * Revision: First Revision
 */

import java.util.InputMismatchException;
import java.util.Scanner;
public class PlayerT implements Players
{
    private static Board g; //The game's board. Since both players share the same board it is static.
    private int x,y;//The x and y co-ordinate of a particular move.
    private char playerChar;//Player's identifying character.
    private Scanner sc;//The scanner object.
    /**
     * The class's parameterized ccnstructor.
     * @param pc The player's identifying characer.
     */
    public PlayerT(char pc)
    {
        playerChar = pc;
        sc = new Scanner(System.in);
    }

    /**
     * The method calls the emptyBoard function to create an empty board.
     */
    public void createTheBoard()
    {
        g = new Board();
        g.emptyBoard();
    }

    /**
     * Takes the input from the player for his turn in the form of a row and column.
     */
    private void input()
    {
        boolean ok = false;//Used to check if the input the user has given is within the board.
        while(!ok)
        {
            try {
                System.out.println("Enter the row number : ");


                x = sc.nextInt();

                System.out.println("Enter the column number : ");

                y = sc.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please enter numbers for the row and column numbers...");
                sc = new Scanner(System.in);
                continue;
            }
            if(x <= 0 || y<= 0 || x > 3 || y > 3)
            {
                System.out.println("Please mark on the board...");
            }
            else
            {
                ok = true;
            }
        }
    }

    /**
     * Plays the game with the current object aggainst the opponent object.
     * @param a The opponent's object.
     * @return z. A random variable.
     */
    public char playGameWith(Players a)
    {
        PlayerT PlayerA = this;
        PlayerT PlayerB = (PlayerT)a;
        char pc = '\0';
        char victory = 'Z';
        boolean end = false;
        boolean playerAisturn=true;
        while (victory == 'Z' && !end){
            if (playerAisturn){
                pc = PlayerA.getPc();
                System.out.println("Player A's turn: ");
                PlayerA.input();
                if (g.hit(PlayerA.x, PlayerA.y,pc) == 't')
                {
                    g.print();
                    victory = PlayerA.vic(pc);
                    end = endCondtion();
                }
                else {
                    System.out.println("Please reenter the coordinates! That is filled  before!");
                    continue;
                }
            }
            else {
                pc = PlayerB.getPc();
                System.out.println("Player B's turn: ");
                PlayerB.input();
                if (g.hit(PlayerB.x, PlayerB.y,pc) == 't')
                {
                    g.print();
                    victory = PlayerA.vic(pc);
                    end = endCondtion();
                }
                else {
                    System.out.println("Please reenter the coordinates! That is filled before!");
                    continue;
                }
            }
            playerAisturn=!playerAisturn;
        }

        if (victory != 'Z')
            System.out.println("The winner is Player " + pc);
        else
            System.out.println("DRAW!");
        return 'z';
    }

    /**
     * Getter method for playerChar
     * @return this.playerChar. The player's identifying character.
     */
    public char getPc()
    {
        return this.playerChar;
    }

    /**
     * Checks for a victory condition.
     * @param pc The player's identifing character.
     * @return The player's identifying character if he has won or 'Z' if he hasn't won.
     */
    public char vic(char pc)
    {
        char result='Z';
        for (int i=0; i<g.board.length; i++){
            if (g.board[i][0]==g.board[i][1] && g.board[i][0]==g.board[i][2] && g.board[i][0]==pc) {
                result=pc;
            }
        }
        if(result != 'Z')
        {
            return result;
        }
        for (int j=0; j<g.board.length; j++){
            if (g.board[0][j]==g.board[1][j] && g.board[0][j]==g.board[2][j] && g.board[0][j]==pc) {
                result=pc;
            }
            }

        if(result != 'Z')
        {
            return result;
        }

        if (g.board[0][0]==g.board[1][1] && g.board[1][1]==g.board[2][2] && g.board[0][0]==pc) return pc;
        if (g.board[0][2]==g.board[1][1] && g.board[0][2]==g.board[2][0] && g.board[0][2]==pc) return pc;
        else return result;
    }

    /**
     * Checks if the game is a draw
     * @return returns true if the board is filled and false if it has not been filled.
     */
    private boolean endCondtion(){
        boolean blankSpace=true;
        lable1:
        for (int i = 0; i < g.board.length; i++)
        {
            for (int j = 0; j < g.board[i].length; j++)
            {
                if (g.board[i][j]=='_' )  {
                    blankSpace=false;
                    break lable1;
                }

            }

        }
        return blankSpace;
    }

    /**
     * The main menthod for unit testing.
     * @param args Not used.
     */
    public static void main(String args[])
    {
        PlayerT PlayerA = new PlayerT('X');
        PlayerT PlayerB = new PlayerT('O');

        //System.out.println(g.board);
    }
}
