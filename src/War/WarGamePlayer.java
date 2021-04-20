
package War;

import ca.sheridancollege.project.GroupOfCards;
import ca.sheridancollege.project.Player;

/**
 * A class to store user information and each individual hand
 *
 * @author Sami Haddad Apr 2021
 * @author Hizir Ozcelik Apr 2021
 * @author Paolo Giuliano Apr 2021
 * @author Liam MacInnis Apr 2021
 */
public class WarGamePlayer extends Player {
    //GroupOfCards used as the players hand
    private GroupOfCards hand = new GroupOfCards();
    
    //Setting the users name
    public WarGamePlayer(String name){
        super(name);
    }
    //Gives access to the players hand
    public GroupOfCards getCards(){
        return this.hand;
    } 
}