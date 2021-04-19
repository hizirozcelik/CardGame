/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import ca.sheridancollege.project.RegularPlayingCard.SUIT;
import ca.sheridancollege.project.RegularPlayingCard.VALUE;
import java.util.LinkedList;
import java.util.LinkedList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Sami Haddad Feb 2021
 * @author Hizir Ozcelik Feb 2021
 * @author Paolo Giuliano Feb 2021
 */
public class GroupOfCards {

    //The group of cards, stored in an LinkedList
    private LinkedList<RegularPlayingCard> deckOne = new LinkedList<RegularPlayingCard>();
    private LinkedList<RegularPlayingCard> deckTwo = new LinkedList<RegularPlayingCard>();

    public GroupOfCards() {
    }

    /**
     * A method that will get the group of cards as an LinkedList
     *
     * @return the group of cards.
     */
    public LinkedList<RegularPlayingCard> getDeckOne() {
        for (VALUE v : VALUE.values()) {
            for (SUIT s : SUIT.values()) {
                deckOne.add(new RegularPlayingCard(v, s));
            }
        }
        Collections.shuffle(deckOne);
        
        for(int i = 0; i < deckOne.size(); i++){
            deckTwo.add(deckOne.get(i));
            deckOne.remove(i);
        }
        return deckOne;
    }
    
    public LinkedList<RegularPlayingCard> getDeckTwo(){
        return deckTwo;
    }

}//end class
