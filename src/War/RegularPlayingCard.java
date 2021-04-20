package War;

import ca.sheridancollege.project.Card;


/**
 * A class used for creating and storing values for each individual playing card
 * also allows for card comparisons using enum's and values
 *
 * @author Sami Haddad Apr 2021
 * @author Hizir Ozcelik Apr 2021
 * @author Paolo Giuliano Apr 2021
 * @author Liam MacInnis Apr 2021
 */

public class RegularPlayingCard extends Card {
    //enum storage for each value
    public enum VALUE {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE
    }
    //enum storage for suits
    public enum SUIT {
        HEARTS,
        SPADES,
        CLUBS,
        DIAMONDS
    }
    //variables to store this cards value and suit
    private VALUE value;
    private SUIT suit;
    
    //Getters and setters for suits and values
    public VALUE getValue() {
        return value;
    }
    public void setValue(VALUE value) {
        this.value = value;
    }

    public SUIT getSuit() {
        return suit;
    }

    public void setSuit(SUIT suit) {
        
        this.suit = suit;
    }
    
    //constuctor for RegularPlayingCard
    public RegularPlayingCard(VALUE value, SUIT suit) {
        this.value = value;
        this.suit = suit;
        
    }

    @Override
    public String toString() {
        //To string to display the card.
        return value+" of "+suit;
    }
}