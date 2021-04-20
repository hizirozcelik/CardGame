package War;

import ca.sheridancollege.project.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import War.RegularPlayingCard.SUIT;
import War.RegularPlayingCard.VALUE;
import ca.sheridancollege.project.GroupOfCards;

/**
 * A static class that handles the logic of the game. A race to collect all
 * 52 cards, and with the chance of a War scenario
 *
 * @author Sami Haddad Apr 2021
 * @author Hizir Ozcelik Apr 2021
 * @author Paolo Giuliano Apr 2021
 * @author Liam MacInnis Apr 2021
 */
public class WarFunctions {
    //Pot used as a temporary storage for the cards on the table
    public static GroupOfCards pot = new GroupOfCards();
    
    public static String playRound(ArrayList<WarGamePlayer> players){
        //Playround has each player draw a card, and compares them using a
        //helper method
        
        //resultOutput is used to return the results of that round of play
        String resultOutput = "";
        
        //Each player draws a card
        RegularPlayingCard p1Card = players.get(0).getCards().draw();
        RegularPlayingCard p2Card = players.get(1).getCards().draw();
        //resultOutput records what cards were drawn
        resultOutput += players.get(0).getName() + " Draws the " + 
                p1Card.toString() + "\n";
        resultOutput += players.get(1).getName() + " Draws the " + 
                p2Card.toString() + "\n\n";
        
        //result will be positive if player 1 wins, negative if player 2 wins
        //and 0 if its a war scenario
        int result = p1Card.getValue().compareTo(p2Card.getValue());
        
        //Adding the cards to the pot
        pot.addToHand(p1Card);
        pot.addToHand(p2Card);
        
        //Returning the result string, and calling the command to compare
       return getResult(result, players, pot, resultOutput);
    }

    public static String war(ArrayList<WarGamePlayer> players, GroupOfCards pot, 
            String resultOutput) {
        //War scenario, each player draws 4 cards, and compares the 4th
        //Adding to the string results
        resultOutput += ("War! Both players draw 4!\n\n");
        //Drawing 3 cards
        for(int x=0; x < 3; x++){
            //If the players dont have cards left, they dont have to draw
            if(players.get(0).getCards().getSize() > 1)
                pot.addToHand(players.get(0).getCards().draw());
            if(players.get(1).getCards().getSize() > 1)
                pot.addToHand(players.get(1).getCards().draw());
        }
        //Players draw their last cards to compare
        RegularPlayingCard p1Card = players.get(0).getCards().draw();
        RegularPlayingCard p2Card = players.get(1).getCards().draw();
        //Adding to the output string
        resultOutput += players.get(0).getName() + " Draws the " + 
                p1Card.toString() + "\n";
        resultOutput += players.get(1).getName() + " Draws the " + 
                p2Card.toString() + "\n\n";
        
        //Calculating the results
        int result = p1Card.getValue().compareTo(p2Card.getValue());
        getResult(result, players, pot, resultOutput);
        
        //Adding to the pot
        pot.addToHand(p1Card);
        pot.addToHand(p2Card);
        
        //Return the string, and calculate the result
        return getResult(result, players, pot, resultOutput);
    }
    
    private static String getResult(int result, ArrayList<WarGamePlayer> players, 
            GroupOfCards pot, String resultOutput){
        //Recursively compares the cards, with literally any case other than
        //a war scenario being the base case
        if(result > 0){
           //If result is positive, player 1 wins that round
           //Add pot to the bottom of player 1's deck
           players.get(0).getCards().addToHand(pot.getPot());
           //Add all results to the string
           resultOutput += (players.get(0).getName() + " Wins! \n\n");
           resultOutput += (players.get(0).getName() + " Has " + 
                   players.get(0).getCards().getSize() + " Cards!\n");
           resultOutput += (players.get(1).getName() + " Has " + 
                   players.get(1).getCards().getSize() + " Cards!\n");
           //Clear the pot for next round
           pot.clearPot();
           return resultOutput;
       }
       else if(result < 0){
           //If results are negative, player 2 wins that round
           //Add pot to the bottom of player 2's deck
           players.get(1).getCards().addToHand(pot.getPot());
           //Add results to the string
           resultOutput += (players.get(1).getName() + " Wins! \n\n");
           resultOutput += (players.get(0).getName() + " Has " + 
                   players.get(0).getCards().getSize() + " Cards!\n");
           resultOutput += (players.get(1).getName() + " Has " + 
                   players.get(1).getCards().getSize() + " Cards!\n");
           //Clear the pot for the next round
           pot.clearPot();
           return resultOutput;
       }
       else if(players.get(0).getCards().getSize() == 0 || 
               players.get(1).getCards().getSize() == 0){
           //In case a player had 1 card going in and manages to cause a war
           //scenario, this prevents an error
           return resultOutput;
       }
       else{
           //War scenario
           return war(players, pot, resultOutput);
       }
    }

    public static void createDeck(ArrayList<WarGamePlayer> players) {
        //CreateDeck used to create the two players hands
        //Creating two LinkedLists for each deck
        LinkedList<RegularPlayingCard> deckOne = new LinkedList<>();
        LinkedList<RegularPlayingCard> deckTwo = new LinkedList<>();
        //For each value and suit, create a card
        for (VALUE v : VALUE.values()) {
            for (SUIT s : SUIT.values()) {
                deckOne.add(new RegularPlayingCard(v, s));
            }
        }
        //Shuffle the deck of 52 cards
        Collections.shuffle(deckOne);

        for (int i = 0; i < deckOne.size(); i++) {
            //split half the deck into the second one, giving each player a
            //shuffled 26 card hand
            deckTwo.add(deckOne.get(i));
            deckOne.remove(i);
        }
           
        //Adding the deck to each players hands
        players.get(0).getCards().addToHand(deckOne);
        players.get(1).getCards().addToHand(deckTwo);
    }
}
