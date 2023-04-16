/**
 * 
 */
package game;


/**
 * @author Naveed Nisarahamad Nadaf
 */

public class StartSquare extends Square {

	// constants

	/**
	 * Constant setting the pass Go Value
	 */
	public static final int PASS_GO_VALUE = 200;
	/**
	 * Constant setting the number of Squares
	 */
	public static final int NUMBER_OF_SQUARES = 15;

	/**
	 * Instance var of passGoValue
	 */
	private double passGoValue;

	/**
	 * Default constructor
	 */
	public StartSquare() {

	}

	// methods

	/**
	 * 
	 * @return pass go value as a double
	 */
	public double getPassGoValue() {
		return passGoValue;
	}

	/**
	 * 
	 * @param passGoValue sets pass go Value
	 */
	public void setPassGoValue() {
		this.passGoValue = PASS_GO_VALUE;
	}
	
	/**
	 * player class increase current player balance by pass go value
	 */
	public static void passStartSquare() {
		GameSystem.getActivePlayer().setBalance(GameSystem.getActivePlayer().getBalance() + PASS_GO_VALUE);
		GameSystem.getActivePlayer().setPosition(GameSystem.getActivePlayer().getPosition() - NUMBER_OF_SQUARES);
		System.out.println("Global Warming has decreased after one full year of you saving energy.. Congrats! collect: " + PASS_GO_VALUE + "!");
		System.out.println("Well done " + GameSystem.getActivePlayer().getName() + " your new balance is: "
				+ GameSystem.getActivePlayer().getBalance()); 

	}

	/**
	 * Overridden method to be displayed if Square is landed on to tell the current
	 * player their current location
	 */
	@Override
	public void displayAll() {
		System.out.println("Square Name                   : " + this.getSquareName());
		System.out.println("You have just recieved        :" + this.passGoValue);

	}
	
}