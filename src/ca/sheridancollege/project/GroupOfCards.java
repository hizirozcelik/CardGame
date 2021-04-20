/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import War.RegularPlayingCard;
import java.util.LinkedList;

/**
 * A class used to manage and edit groups of cards such as players hands or
 * the games card pot
 *
 * @author Paul Bonenfant Apr 2020
 * @author Sami Haddad Apr 2021
 * @author Hizir Ozcelik Apr 2021
 * @author Paolo Giuliano Apr 2021
 * @author Liam MacInnis Apr 2021
 */
public class GroupOfCards {

    //The group of cards, stored in an LinkedList
    private LinkedList<RegularPlayingCard> cards = 
            new LinkedList<RegularPlayingCard>();
    
    public void addToHand(LinkedList<RegularPlayingCard> cards){
        //Adds a list of cards to the bottom of the deck
        this.cards.addAll(cards);
    }
    
    public void addToHand(RegularPlayingCard card){
        //Adds a single card to the bottom of a deck
        this.cards.add(card);
    }
    
    public RegularPlayingCard draw(){
        //Draws the top card, removes it from the deck
        RegularPlayingCard card = cards.get(0);
        cards.remove(0);
        return card;
    }
    
    
    
    public LinkedList<RegularPlayingCard> getPot(){;
        //Returns all the cards, used for the pot
        return this.cards;
    }
    
    public void clearPot(){
        //Clears the group of cards, used for the pot
        this.cards.clear();
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return cards.size();
    }
}//end class
