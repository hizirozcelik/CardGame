package War;

import ca.sheridancollege.project.Game;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class used to interact with the user and control the flow of the game
 *
 * @author dancye
 * @author Sami Haddad Apr 2021
 * @author Hizir Ozcelik Apr 2021
 * @author Paolo Giuliano Apr 2021
 * @author Liam MacInnis Apr 2021
 */
public class WarGame extends Game {
    
    //Play game is used to break the loop once a victor is declared
    private boolean playGame = true;
    //Array list to store 2 WarGamePlayer objects
    private ArrayList<WarGamePlayer> players = new ArrayList();
    
    //Scanner and input variable to interact with the user
    private Scanner k = new Scanner(System.in);
    private String input;
    
    //Class constructor using the super classes constructor
    public WarGame(String name){
        super(name);
    }
    
    //Main method starts the game
    public static void main(String[] args) {
        WarGame game = new WarGame("War");
        game.play();
    }

    @Override
    public void play() {
        //Setting up player objects
        System.out.println("Enter player 1 name");
        WarGamePlayer player1 = new WarGamePlayer(k.nextLine());
        System.out.println("Enter player 2 name");
        WarGamePlayer player2 = new WarGamePlayer(k.nextLine());
        players.add(player1);
        players.add(player2);
        
        //Creating the deck and setting up players hands
        WarFunctions.createDeck(players);
        
        //The game will run until victor is declared
        while(playGame){
            //Offers the user two options
            System.out.println("Enter \"play\" to draw a card");
            System.out.println("Enter \"Quit\" to exit the game");
            input = k.nextLine();
            
            if(input.toLowerCase().equals("play")){
                //If user types "play", run the games logic
                System.out.println(WarFunctions.playRound(players));
            }
            else if(input.toLowerCase().equals("quit")){
                //If user types "quit", thank the user and exit the program
                System.out.println("Thank you for playing!");
                System.exit(0);
            }
            else{
                //If user types anything else, remind them of their options
                System.out.println("Error: Please enter either play or quit");
            }
            //Check to see if there is a winner
            if(player2.getCards().getSize() == 0){
                //If player 1 wins, player 2 has 0 cards
                declareWinner(player1.getName());
            }
            else if(player1.getCards().getSize() == 0){
                //If player 2 wins, player 1 has 0 cards
                declareWinner(player2.getName());
            }
        }
    }
    @Override
    public void declareWinner(String name) {
        //Method breaks the game loop, then declares the winner
        this.playGame = false;
        System.out.println(name + " Is the Winner!");
    }
    
}
