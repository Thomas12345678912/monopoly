package game;

/**
*
* @author Thomas Mckee
*/
public class Tax extends Square {

	/**
	 * Default constructor
	 */
	public Tax() {

	}

	/**
	 * Constructor with arguments to set the name of the Square
	 * 
	 * @param squareName
	 */
	public Tax(String squareName) {
		super(squareName);
	}

	/**
	 * Overiding method to display Square name which is set in the Game() when blank
	 * square is landed on
	 */
	@Override
	public void displayAll() {
		System.out.println("You landed on " + this.getSquareName()+" Square!");

	}
	/**
	 * Pay pollution fine method
	 */
	public void payPollutionFine() {
		//getting the current player to pay 100 
		System.out.println("They caught you polluting the ocean! you need to pay 200..");
		GameSystem.getActivePlayer()
		.setBalance(GameSystem.getActivePlayer().getBalance() - 200);
System.out.println(GameSystem.getActivePlayer().getName() + " your new balance is: "
		+ GameSystem.getActivePlayer().getBalance());
	}
}


