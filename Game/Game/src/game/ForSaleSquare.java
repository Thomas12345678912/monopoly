/**
 * 
 */
package game;

import java.util.Scanner;

/**
 *@author Conor Moore, Ryan Wade
 *This class creates a forSaleSquare which inherits square
 */
public class ForSaleSquare extends Square {

	// instamce vars

	private String squareName;
	/**
	 * The cost to purchase the square
	 */
	private double squarePrice;
	/**
	 * Setting the square owner name as a string to help tell difference between
	 * players
	 */
	private String squareOwner;

	/**
	 * Number of equipments
	 */
	private int equipments;
	/**
	 * Number of climate hubs
	 */
	private int climateHubs;
	/**
	 * Equipment Price
	 */
	private double equipmentsPrice;
	/**
	 * Climate hub Price
	 */
	private double climateHubPrice;
	/**
	 * Cost of landing on someones else's square
	 */
	private double rent;
	/**
	 * Increase in rent per equipment extra
	 */
	private double equipmentExtra;
	/**
	 * Increase in rent per climate hub extra
	 */
	private double climateHubExtra;
	/**
	 * Description of Square and upgrade option
	 */
	private String description;

	// constructors
	/**
	 * Default constructor
	 */
	public ForSaleSquare() {

	}

	/**
	 * @param squarePrice
	 * @param squareOwner
	 * @param equipments
	 * @param climateHubs
	 * @param equipmentsPrice
	 * @param climateHubPrice
	 * @param rent
	 * @param equipmentExtra
	 * @param climateHubExtra
	 * @param description
	 */
	public ForSaleSquare(String squareName, double squarePrice, String squareOwner, int equipments, int climateHubs,
			double equipmentsPrice, double climateHubPrice, double rent, double equipmentExtra, double climateHubExtra,
			String description) {
		super();
		this.squareName = squareName;
		this.squarePrice = squarePrice;
		this.squareOwner = squareOwner;
		this.equipments = equipments;
		this.climateHubs = climateHubs;
		this.equipmentsPrice = equipmentsPrice;
		this.climateHubPrice = climateHubPrice;
		this.rent = rent;
		this.equipmentExtra = equipmentExtra;
		this.climateHubExtra = climateHubExtra;
		this.description = description;
	}

	/**
	 * @return the squareName
	 */
	public String getSquareName() {
		return squareName;
	}

	/**
	 * @param squareName the squareName to set
	 */
	public void setSquareName(String squareName) {
		this.squareName = squareName;
	}

	/**
	 * @return the squarePrice
	 */
	public double getSquarePrice() {
		return squarePrice;
	}

	/**
	 * @param squarePrice the squarePrice to set
	 */
	public void setSquarePrice(double squarePrice) {
		this.squarePrice = squarePrice;
	}

	/**
	 * @return the squareOwner
	 */
	public String getSquareOwner() {
		return squareOwner;
	}

	/**
	 * @param squareOwner the squareOwner to set
	 */
	public void setSquareOwner(String squareOwner) {
		this.squareOwner = squareOwner;
	}

	/**
	 * @return the equipments
	 */
	public int getEquipments() {
		return equipments;
	}

	/**
	 * @param equipments the equipments to set
	 */
	public void setEquipments(int equipments) {
		this.equipments = equipments;
	}

	/**
	 * @return the climateHubs
	 */
	public int getClimateHubs() {
		return climateHubs;
	}

	/**
	 * @param climateHubs the climateHubs to set
	 */
	public void setClimateHubs(int climateHubs) {
		this.climateHubs = climateHubs;
	}

	/**
	 * @return the equipmentsPrice
	 */
	public double getEquipmentsPrice() {
		return equipmentsPrice;
	}

	/**
	 * @param equipmentsPrice the equipmentsPrice to set
	 */
	public void setEquipmentsPrice(double equipmentsPrice) {
		this.equipmentsPrice = equipmentsPrice;
	}

	/**
	 * @return the climateHubPrice
	 */
	public double getClimateHubPrice() {
		return climateHubPrice;
	}

	/**
	 * @param climateHubPrice the climateHubPrice to set
	 */
	public void setClimateHubPrice(double climateHubPrice) {
		this.climateHubPrice = climateHubPrice;
	}

	/**
	 * @return the rent
	 */
	public double getRent() {
		return rent;
	}

	/**
	 * @param rent the rent to set
	 */
	public void setRent(double rent) {
		this.rent = rent;
	}

	/**
	 * @return the equipmentExtra
	 */
	public double getEquipmentExtra() {
		return equipmentExtra;
	}

	/**
	 * @param equipmentExtra the equipmentExtra to set
	 */
	public void setEquipmentExtra(double equipmentExtra) {
		this.equipmentExtra = equipmentExtra;
	}

	/**
	 * @return the climateHubExtra
	 */
	public double getClimateHubExtra() {
		return climateHubExtra;
	}

	/**
	 * @param climateHubExtra the climateHubExtra to set
	 */
	public void setClimateHubExtra(double climateHubExtra) {
		this.climateHubExtra = climateHubExtra;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @author Ryan Wade
	 * Overridden method from Square abstract class which displays all ForSaleSquare
	 * attributes
	 */
	@Override
	public void displayAll() {
		System.out.println("Square Name                   : " + this.getSquareName());
		System.out.println("Owner                         : " + this.getSquareOwner());
		System.out.println("Description                   :" + this.getDescription());
		System.out.println("Price: " + this.getSquarePrice() + " Cost of Equipment :" + this.getEquipmentsPrice()
				+ " Cost of Climate Hub: " + this.getClimateHubPrice());
		System.out.println("Rent increase per Equipment: " + this.getEquipmentExtra()
				+ " Resource Usage cost increase per Climate Hub :" + this.getClimateHubExtra());
		System.out.println("Currently built here are:    Number of Equipemnts:" + this.getEquipments()
				+ "   Number of Climate Hubs: " + this.getClimateHubs());

	}

	/**
	 * @author Ryan Wade method for purchasing square which skips blank, tax and chance square
	 */
	public static void purchaseSquare() {
		String userResponse;
		Scanner scanner = new Scanner(System.in);
		if (GameSystem.getActivePlayer().getPosition() != 14 && GameSystem.getActivePlayer().getPosition() != 15
				&& GameSystem.getActivePlayer().getPosition() != 1) {
			System.out.println("Would you like to buy the square?");
			userResponse = scanner.nextLine();
			if (userResponse.equalsIgnoreCase("Y")) {
				GameSystem.getSquareLandedOn().setSquareOwner(GameSystem.getActivePlayer().getName());
				GameSystem.getActivePlayer().setBalance(
						GameSystem.getActivePlayer().getBalance() - GameSystem.getSquareLandedOn().getSquarePrice());
				System.out.println(GameSystem.getActivePlayer().getName() + " your new balance is: "
						+ GameSystem.getActivePlayer().getBalance());
			} else if (userResponse.equalsIgnoreCase("N")) {
				System.out.println("Square not purchased");
			}
		}
	}

	/**
	 * @author Conor Moore method for building equipments and climate hubs which skips blank, tax and chance square
	 */
	public static void createEquipmentAndClimateHub() {

		String userResponse;
		Scanner scanner = new Scanner(System.in);
		if (GameSystem.getActivePlayer().getPosition() != 14 && GameSystem.getActivePlayer().getPosition() != 15
				&& GameSystem.getActivePlayer().getPosition() != 1 && GameSystem.getActivePlayer().getPosition() != 10 && GameSystem.getActivePlayer().getPosition() != 11 && GameSystem.getActivePlayer().getPosition() != 12 && GameSystem.getActivePlayer().getPosition() != 13) {

			System.out.println(
					"Would you like to invest in an Equipment on the Squares you own? Press Y to develop, N to end turn");
			userResponse = scanner.nextLine();
			/**
			 * Getting current player input to check that they want to develop square
			 */
			if (userResponse.equalsIgnoreCase("y")) {
				for (int loop = 0; loop < GameSystem.squares.length; loop++) {

					/**
					 * checking if the current player owns Source 1, less 3 Equipments on current
					 * square and enough money to pay for each equipment
					 */
					if (GameSystem.squares[0].getSquareOwner().equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[1].getSquareOwner()
									.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[2].getSquareOwner()
									.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[0].getEquipments() < 3
							&& GameSystem.getActivePlayer().getBalance() > GameSystem.squares[0].getEquipmentsPrice()) {
						GameSystem.squares[0].setEquipments(GameSystem.squares[0].getEquipments() + 1);

						GameSystem.squares[0].setRent(GameSystem.squares[0].getRent()
								+ GameSystem.squares[0].getEquipments() * GameSystem.squares[0].getEquipmentExtra());
						GameSystem.getActivePlayer().setBalance(
								GameSystem.getActivePlayer().getBalance() - GameSystem.squares[0].getEquipmentsPrice());

						System.out.println("Well done " + GameSystem.getActivePlayer().getName()
								+ " you have built 1 equipment on " + GameSystem.squares[0].getSquareName()
								+ " and your new balance is: " + GameSystem.getActivePlayer().getBalance());
						break;

						/**
						 * checking if the current player owns Source 1, less 3 Equipments on current
						 * square and enough money to pay for each equipment
						 */
					} else if (GameSystem.squares[0].getSquareOwner()
							.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[1].getSquareOwner()
									.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[2].getSquareOwner()
									.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[1].getEquipments() < 3
							&& GameSystem.getActivePlayer().getBalance() > GameSystem.squares[1].getEquipmentsPrice()) {
						GameSystem.squares[1].setEquipments(GameSystem.squares[1].getEquipments() + 1);
						GameSystem.squares[1].setRent(GameSystem.squares[1].getRent()
								+ GameSystem.squares[1].getEquipments() * GameSystem.squares[1].getEquipmentExtra());
						GameSystem.getActivePlayer().setBalance(
								GameSystem.getActivePlayer().getBalance() - GameSystem.squares[0].getEquipmentsPrice());
						System.out.println("Well done " + GameSystem.getActivePlayer().getName()
								+ " you have built 1 equipment on " + GameSystem.squares[1].getSquareName()
								+ " and your new balance is: " + GameSystem.getActivePlayer().getBalance());
						break;
						/**
						 * checking if the current player owns Source 1, less 3 Equipments on current
						 * square and enough money to pay for each equipment
						 */
					} else if (GameSystem.squares[0].getSquareOwner()
							.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[1].getSquareOwner()
									.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[2].getSquareOwner()
									.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[2].getEquipments() < 3
							&& GameSystem.getActivePlayer().getBalance() > GameSystem.squares[2].getEquipmentsPrice()) {
						GameSystem.squares[2].setEquipments(GameSystem.squares[2].getEquipments() + 1);
						GameSystem.squares[2].setRent(GameSystem.squares[2].getRent()
								+ GameSystem.squares[2].getEquipments() * GameSystem.squares[2].getEquipmentExtra());
						GameSystem.getActivePlayer().setBalance(
								GameSystem.getActivePlayer().getBalance() - GameSystem.squares[0].getEquipmentsPrice());
						System.out.println("Well done " + GameSystem.getActivePlayer().getName()
								+ " you have built 1 Equipment on " + GameSystem.squares[2].getSquareName()
								+ " and your new balance is: " + GameSystem.getActivePlayer().getBalance());
						break;

						/**
						 * checking if the current player owns Source 2, less 3 Equipments on current
						 * square and enough money to pay for each equipment
						 */
					} else if (GameSystem.squares[3].getSquareOwner()
							.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[4].getSquareOwner()
									.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[5].getSquareOwner()
									.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[3].getEquipments() < 3
							&& GameSystem.getActivePlayer().getBalance() > GameSystem.squares[3].getEquipmentsPrice()) {
						GameSystem.squares[3].setEquipments(GameSystem.squares[3].getEquipments() + 1);
						GameSystem.squares[3].setRent(GameSystem.squares[3].getRent()
								+ GameSystem.squares[3].getEquipments() * GameSystem.squares[3].getEquipmentExtra());
						GameSystem.getActivePlayer().setBalance(
								GameSystem.getActivePlayer().getBalance() - GameSystem.squares[0].getEquipmentsPrice());
						System.out.println("Well done " + GameSystem.getActivePlayer().getName()
								+ " you have built 1 Equipment on " + GameSystem.squares[3].getSquareName()
								+ " and your new balance is: " + GameSystem.getActivePlayer().getBalance());
						break;

						/**
						 * checking if the current player owns Source 2, less 3 Equipments on current
						 * square and enough money to pay for each equipment
						 */
					} else if (GameSystem.squares[3].getSquareOwner()
							.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[4].getSquareOwner()
									.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[5].getSquareOwner()
									.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[4].getEquipments() < 3
							&& GameSystem.getActivePlayer().getBalance() > GameSystem.squares[4].getEquipmentsPrice()) {
						GameSystem.squares[4].setEquipments(GameSystem.squares[4].getEquipments() + 1);
						GameSystem.squares[4].setRent(GameSystem.squares[4].getRent()
								+ GameSystem.squares[4].getEquipments() * GameSystem.squares[4].getEquipmentExtra());
						GameSystem.getActivePlayer().setBalance(
								GameSystem.getActivePlayer().getBalance() - GameSystem.squares[0].getEquipmentsPrice());
						System.out.println("Well done " + GameSystem.getActivePlayer().getName()
								+ " you have built 1 Equipment on " + GameSystem.squares[4].getSquareName()
								+ " and your new balance is: " + GameSystem.getActivePlayer().getBalance());
						break;

						/**
						 * checking if the current player owns Source 2, less 3 Equipments on current
						 * square and enough money to pay for each equipment
						 */
					} else if (GameSystem.squares[3].getSquareOwner()
							.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[4].getSquareOwner()
									.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[5].getSquareOwner()
									.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[5].getEquipments() < 3
							&& GameSystem.getActivePlayer().getBalance() > GameSystem.squares[5].getEquipmentsPrice()) {
						GameSystem.squares[5].setEquipments(GameSystem.squares[5].getEquipments() + 1);
						GameSystem.squares[5].setRent(GameSystem.squares[5].getRent()
								+ GameSystem.squares[5].getEquipments() * GameSystem.squares[5].getEquipmentExtra());
						GameSystem.getActivePlayer().setBalance(
								GameSystem.getActivePlayer().getBalance() - GameSystem.squares[0].getEquipmentsPrice());
						System.out.println("Well done " + GameSystem.getActivePlayer().getName()
								+ " you have built 1 Equipment on " + GameSystem.squares[5].getSquareName()
								+ " and your new balance is: " + GameSystem.getActivePlayer().getBalance());
						break;
						/**
						 * checking if the current player owns Source 3, less 3 Equipments on current
						 * square and enough money to pay for each equipment
						 */
					} else if (GameSystem.squares[6].getSquareOwner()
							.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[7].getSquareOwner()
									.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[6].getEquipments() < 3
							&& GameSystem.getActivePlayer().getBalance() > GameSystem.squares[6].getEquipmentsPrice()) {
						GameSystem.squares[6].setEquipments(GameSystem.squares[6].getEquipments() + 1);
						GameSystem.squares[6].setRent(GameSystem.squares[6].getRent()
								+ GameSystem.squares[6].getEquipments() * GameSystem.squares[6].getEquipmentExtra());
						GameSystem.getActivePlayer().setBalance(
								GameSystem.getActivePlayer().getBalance() - GameSystem.squares[0].getEquipmentsPrice());
						System.out.println("Well done " + GameSystem.getActivePlayer().getName()
								+ " you have built 1 Equipment on " + GameSystem.squares[6].getSquareName()
								+ " and your new balance is: " + GameSystem.getActivePlayer().getBalance());
						break;
						/**
						 * checking if the current player owns Source 3, less 3 Equipments on current
						 * square and enough money to pay for each equipment
						 */
					} else if (GameSystem.squares[6].getSquareOwner()
							.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[7].getSquareOwner()
									.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
							&& GameSystem.squares[7].getEquipments() < 3
							&& GameSystem.getActivePlayer().getBalance() > GameSystem.squares[6].getEquipmentsPrice()) {
						GameSystem.squares[7].setEquipments(GameSystem.squares[7].getEquipments() + 1);
						GameSystem.squares[7].setRent(GameSystem.squares[7].getRent()
								+ GameSystem.squares[7].getEquipments() * GameSystem.squares[7].getEquipmentExtra());
						GameSystem.getActivePlayer().setBalance(
								GameSystem.getActivePlayer().getBalance() - GameSystem.squares[0].getEquipmentsPrice());
						System.out.println("Well done " + GameSystem.getActivePlayer().getName()
								+ " you have built 1 Equipment on " + GameSystem.squares[7].getSquareName()
								+ " and your new balance is: " + GameSystem.getActivePlayer().getBalance());
						break;
						/**
						 * Loop through squares to check number of equipments and see if possible to
						 * create climate hub
						 */
					} else if (GameSystem.squares[loop].getEquipments() == 3
							&& GameSystem.squares[loop].getClimateHubs() < 1) {

						if ((GameSystem.squares[loop].getSquareOwner()
								.equalsIgnoreCase(GameSystem.getActivePlayer().getName())
								&& GameSystem.getActivePlayer().getBalance() > GameSystem.squares[loop]
										.getClimateHubPrice())) {
							GameSystem.squares[loop].setClimateHubs(GameSystem.squares[loop].getClimateHubs() + 1);
							GameSystem.squares[loop].setRent(GameSystem.squares[loop].getRent()
									+ (GameSystem.squares[loop].getEquipments()
											* GameSystem.squares[loop].getEquipmentExtra())
									+ (GameSystem.squares[loop].getClimateHubs()
											* GameSystem.squares[loop].getClimateHubExtra()));
							GameSystem.getActivePlayer().setBalance(GameSystem.getActivePlayer().getBalance()
									- GameSystem.squares[loop].getClimateHubPrice());

							System.out.println("Well done " + GameSystem.getActivePlayer().getName()
									+ " you have built 1 Climate Hub on " + GameSystem.squares[loop].getSquareName()
									+ " and your new balance is: " + GameSystem.getActivePlayer().getBalance());
							break;
						}
					}
				}

			}

		}
	}
}
