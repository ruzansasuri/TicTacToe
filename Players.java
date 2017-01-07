/**
 * Players.java
 *
 * @author: Ruzan Sasuri            rps7183@g.rit.edu
 * @author: Akash Venkatachalam     av2833@g.rit.edu
 * @author: Ghodratollah Aalipour   ga5481@g.rit.edu
 *
 * This interface is for any 2 player Game's player.
 *
 * Id: $Players.java v1.0 2016/9/26$
 * Revision: First Revision.
 */
public interface Players
{
    void createTheBoard();
    char playGameWith(Players a);
    char getPc();
    char vic(char pc);
}
