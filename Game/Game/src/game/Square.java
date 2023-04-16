/**
 * 
 */
package game;

/**
 * @author Naveed Nisarahamad Nadaf
 *
 */
public class Square {
	// instance variables 
	/**
	 * Name of the Square
	 */
	private String squareName;

	/**
	 * Default constructor
	 */
	public Square() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor with parameters
	 * 
	 * @paramsquareName
	 */
	public Square(String squareName) {
		this.squareName = squareName;
	}

	/**
	 * @return the squareName
	 */
	public String getSquareName() {
		return squareName;
	}

	/**
	 * @paramsquareName
	 * 
	 */
	public void setSquareName(String squareName) {
		this.squareName = squareName;
	}

	/**
	 * Displays Square Name
	 */
	public void displayAll() {
		System.out.println("Square Name: " + this.squareName);
	}

}

