/**
 * Board.java
 * @author: Ruzan Sasuri            rps7183@g.rit.edu
 * @author: Akash Venkatachalam     av2833@g.rit.edu
 * @author: Ghodratollah Aalipour   ga5481@g.rit.edu
 *
 * The class that defines the game's board.
 *
 * Id: $ Board.java v1.0, 2016/09/19$
 * Revision: First Revision
 */

public class Board implements GameBoard
{
    char board[][] ;//Holds the game's board.

    /**
     * Non parameterized constructor to initialize the board to a 3x3 array.
     */
    public Board()
    {
        board = new char[3][3];
    }

    /**
     * Create's an empty board with '_' and prints the empty board.
     */
    public void emptyBoard()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                board[i][j] = '_';
                System.out.print(board[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    /**
     * Takes the user's inputted row, column number and his identifying character, fills the board with his attack,
     * and returns if the hit is possible or not.
     * @param x The row number entered by the player.
     * @param y The column number entered by the player.
     * @param player The player's identifying character.
     * @return 't' if the hit is possble or 'f' if not.
     */
    public char hit(int x, int y, char player)
    {
        int x1=x-1;
        int y1=y-1;
        char out;
        if (board[x1][y1]=='_'){
            out = player;
            board[x1][y1] = out;
            return 't';
        }
        else return 'f';
    }

    /**
     * Prints the board.
     */
    public void print()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {

                System.out.print(board[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    /**
     * The getter method for the number of rows in the board.
     * @return this.board.length
     */
    public int getRow()
    {
        return board.length;
    }

    /**
     * The getter method for the number of columns in the board.
     * @return this.board[0].length
     */
    public int getColumn()
    {
        return board[0].length;
    }
}
