package game;

/**
 * @author Thomas Mckee
 *
 */
public class BlankSquare extends Square {

	/**
	 * default constructor
	 */
	public BlankSquare() {

	}

	/**
	 *constructor inheriting from superclass
	 *
	 */
	public BlankSquare(String squareName) {
		super(squareName);

	}


	/**
	 * Display all method
	 */
	public void displayAll() {
		System.out.println("you have landed on " + this.getSquareName() + ", nothing will happen, wait a turn");
	}
}
