/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package War;

import ca.sheridancollege.project.Game;
import ca.sheridancollege.project.Player;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Liam MacInnis
 */
public class WarGame extends Game {
    
    private boolean playGame = true;
    private ArrayList<Player> players = new ArrayList();
    
    private Scanner k = new Scanner(System.in);
    private String input;
    
    public WarGame(String name){
        super(name);
    }
    
    public static void main(String[] args) {
        WarGame game = new WarGame("War");
        game.play();
    }

    @Override
    public void play() {
        System.out.println("Enter player 1 name");
        WarGamePlayer player1 = new WarGamePlayer(k.nextLine());
        System.out.println("Enter player 2 name");
        WarGamePlayer player2 = new WarGamePlayer(k.nextLine());
        players.add(player1);
        players.add(player2);
        
        
        while(playGame){
            System.out.println("Enter \"play\" to draw a card");
            System.out.println("Enter \"Quit\" to exit the game");
            input = k.nextLine();
            
            if(input.toLowerCase().equals("play")){
                WarFunctions.playRound(players);
            }
            else if(input.toLowerCase().equals("quit")){
                System.out.println("Thank you for playing!");
                System.exit(0);
            }
            else{
                System.out.println("Error: Please enter either play or quit");
            }
        }
    }

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
