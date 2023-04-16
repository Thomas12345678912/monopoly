package game;

import java.util.Random;
import java.util.Scanner;

import game.ClimateWarrior;
import game.GameSystem;
import game.IDiceRoll;

/**
 * 
 * @author Conor Moore, Ryan wade
 *
 */
public class ClimateWarrior implements IDiceRoll {

	// instance vars
	/**
	 * String to represent players names
	 */
	private String name;

	/**
	 * Player balance to show the amount of resources
	 */
	private double balance;

	/**
	 * Player position to represent where the player is on the board
	 */
	private int position;

	// constructors

	/**
	 * default constructor
	 */
	public ClimateWarrior() {

	}

	/**
	 * Constructor with args Used to declare each player in Game() and set each key
	 * attributes
	 * 
	 * @param name
	 * @param balance
	 * @param position
	 */
	public ClimateWarrior(String name, int balance, int position) {
		super();
		this.name = name;
		this.balance = balance;
		this.position = position;
	}

	// methods

	/**
	 * @return player name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets player name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return player balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Sets player balance
	 * 
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * 
	 * @return player position
	 */
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * @author Conor Moore
	 * Implements Idice roll and created a roll of two dice
	 */
	@Override
	public int rollDice() {
		int total = 0;
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press any key and enter to roll dice..");
		scanner.next();
		int diceRoll1 = random.nextInt(6) + 1;
		int diceRoll2 = random.nextInt(6) + 1;
		total = diceRoll1 + diceRoll2;
		if (total == 1) {
			total += 1;
		}
		System.out.println(this.getName() + " rolled a " + total);

		return total;
	}

	/**
	 * @author Ryan Wade Display all method to show current state of play for
	 *         current player
	 */
	public void displayAll() {
		System.out.println("Player Name:       " + this.name);
		System.out.println("Balance:           " + this.balance);
		System.out.println("Position on board: " + this.getPosition());

	}

	/**
	 * @author Ryan Wade
	 * @return player balance and displays it to the current player
	 */
	public double returnBalance() {
		System.out.println("Player " + this.getName() + " has a balance of: " + this.getBalance());

		return this.getBalance();
	}

	/**
	 * @author Ryan Wade method to pay rent cost
	 */
	public static void payRentCost() {
		Scanner scanner = new Scanner(System.in);
		String userinput;

		/**
		 * Telling the current player they have landed on a square owned by an opposing
		 * player
		 */

		if (GameSystem.getActivePlayer().getPosition() != 14 && GameSystem.getActivePlayer().getPosition() != 15
				&& GameSystem.getActivePlayer().getPosition() != 1) {

			System.out.println("You have landed on your opponent's system and are required to pay rent");

			System.out.println("Please pass control to : " + GameSystem.getSquareLandedOn().getSquareOwner());

			/**
			 * Asking if the player who owns the square wants to accept the rent
			 */
			System.out.println("Hello " + GameSystem.getSquareLandedOn().getSquareOwner()
					+ ", would you like to accept the rent from " + GameSystem.getActivePlayer().getName()
					+ "? Enter Y/N ");
			userinput = scanner.nextLine();
			/**
			 * If yes, the current player balance is reduced by the rent cost. The square
			 * owner balance is increased by the rent cost.
			 */
			if (userinput.equalsIgnoreCase("Y")) {
				// array to store all the players
				ClimateWarrior[] players = { GameSystem.getActivistOne(), GameSystem.getActivistTwo(),
						GameSystem.getActivistThree(), GameSystem.getActivistFour() };
				// using a search/ for loop to loop through the array and find out if a player
				// owns a square
				for (ClimateWarrior player : players) {
					if (GameSystem.getSquareLandedOn().getSquareOwner().equalsIgnoreCase(player.getName())) {
						player.setBalance(player.getBalance() + GameSystem.getSquareLandedOn().getRent());

						// updating the balance and displaying it
						System.out.println(player.getName() + ", your new balance is: " + player.getBalance());
					} else if (GameSystem.getActivePlayer().getName().equalsIgnoreCase(player.getName())) {
						player.setBalance(player.getBalance() - GameSystem.getSquareLandedOn().getRent());
						if (player.getBalance() < 0) {
							player.setBalance(0); // setting balance to zero if it's negative
						}
						System.out.println(player.getName() + ", your new balance is: " + player.getBalance());
					}
				}
			}
		}
	}

}