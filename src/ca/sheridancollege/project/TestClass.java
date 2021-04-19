package ca.sheridancollege.project;

import java.util.LinkedList;

public class TestClass {

    public static void main(String[] args) {

        GroupOfCards cards = new GroupOfCards();
        LinkedList<RegularPlayingCard> deckOne = cards.getDeckOne();
        LinkedList<RegularPlayingCard> deckTwo = cards.getDeckTwo();

        System.out.printf("%20s%20s%20s\n", "Deck One", "Deck Two","Battle Result");
        for (int i = 0; i < 26; i++) {
            System.out.printf("%20s%20s%15s\n", deckOne.get(i).toString(), deckTwo.get(i).toString(), deckOne.get(i).getValue().compareTo(deckTwo.get(i).getValue()));
        }
    }
}
