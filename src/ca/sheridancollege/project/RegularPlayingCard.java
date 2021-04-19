package ca.sheridancollege.project;

public class RegularPlayingCard extends Card {
    private VALUE value;

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
    private SUIT suit;
    
    enum VALUE {
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
    
    enum SUIT {
        HEARTS,
        SPADES,
        CLUBS,
        DIAMONDS
    }

    public RegularPlayingCard(VALUE value, SUIT suit) {
        this.value = value;
        this.suit = suit;
        
    }

    @Override
    public String toString() {
        return value+" of "+suit;
    }
}
