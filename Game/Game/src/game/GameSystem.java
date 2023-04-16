/**
 * 
 */
package game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


import game.ClimateWarrior;
import game.ForSaleSquare;
import game.GameSystem;
import game.StartSquare;

/**
 * This is the GameSystem which will run the board game
 * @author Conor Moore, Ryan Wade, Naveed Nadaf, Thomas Mckee
 *
 */
public class GameSystem {

	/**
	 * Starting Balance
	 */
	public static final int STARTING_BALANCE = 1500;

	/**
	 * Starting position
	 */
	public static final int STARTING_POSITION = 0;

	/**
	 * Declaring each player object
	 */
	private static ClimateWarrior activePlayer, activistOne, activistTwo, activistThree, activistFour;

	/**
	 * Declaring each player
	 */
	private static ClimateWarrior p1 = new ClimateWarrior(null, STARTING_BALANCE, STARTING_POSITION);
	private static ClimateWarrior p2 = new ClimateWarrior(null, STARTING_BALANCE, STARTING_POSITION);
	private static ClimateWarrior p3 = new ClimateWarrior(null, STARTING_BALANCE, STARTING_POSITION);
	private static ClimateWarrior p4 = new ClimateWarrior(null, STARTING_BALANCE, STARTING_POSITION);

	/**
	 * End game set to false
	 * 
	 * 
	 */
	public static Boolean endGame = false;

	/**
	 * Player turn instance variable set to 1 and incremented after each player turn
	 */
	private static int playerTurn = 1;

	/**
	 * Setting square landed on to null
	 */
	private static ForSaleSquare SquareLandedOn = null;
	/**
	 * Declaring StartSquare Square object
	 */
	public static StartSquare startsquare = new StartSquare();

	/**
	 * Creating the tax Square Object
	 */
	public static Tax loseOneHundred = new Tax("Tax");

	/**
	 * Creating the object chance square
	 */
	public static ChanceSquare chanceSquare = new ChanceSquare("Chance Square");

	/**
	 * Creating the object blank square
	 */
	public static BlankSquare blankSquare = new BlankSquare("Blank Square");

	/**
	 * Declaring mount everest
	 */
	public static ForSaleSquare mountEverest = new ForSaleSquare("Mount Everest", 500, "NotYet", 0, 0, 0, 0, 50, 0, 0,
			" Mount Everest is the highest peak in the world, located in the Himalayas on the border between Nepal and Tibet.\n It stands at a staggering height of 8,848 meters (29,029 feet) above sea level,\n and is a popular destination for mountaineers and adventure seekers.\n The mountain was first successfully climbed in 1953 by Sir Edmund Hillary of New Zealand and Tenzing Norgay,\n a Sherpa of Nepal, and has since become an iconic symbol of human achievement and endurance.");
	/**
	 * Declaring congo rainforest
	 */
	public static ForSaleSquare congoRainforest = new ForSaleSquare("Congo Rainforest", 500, "NotYet", 0, 0, 0, 0, 50,
			0, 0,
			" The Congo Rainforest, also known as the Congo Basin, is the world's second-largest tropical rainforest,\n spanning across six African countries - Cameroon, Central African Republic, Democratic Republic of the Congo,\n Republic of the Congo, Equatorial Guinea, and Gabon.\n The rainforest is home to a diverse range of flora and fauna, including gorillas, chimpanzees,\n elephants, and a variety of bird species. It is also an important source of livelihood for the local communities,\n providing food, water, and other natural resources. However, the rainforest is facing various threats such as deforestation,\n poaching, and climate change, which are endangering its ecosystem and the species that depend on it.");
	/**
	 * Declaring mount kilamanjaro
	 */
	public static ForSaleSquare mountKilamanjaro = new ForSaleSquare("Mount Kilamanjaro", 500, "NotYet", 0, 0, 0, 50,
			200, 0, 0,
			" Mount Kilimanjaro is a dormant volcanic mountain located in Tanzania, Africa. It is the highest peak in Africa,\n rising to a height of 5,895 meters (19,341 feet) above sea level.\n Kilimanjaro is a popular destination for hikers and mountaineers,\n attracting thousands of visitors every year.\n The mountain is known for its three volcanic cones, namely Kibo, Mawenzi, and Shira.\n Kilimanjaro is also home to a diverse range of flora and fauna, including several endemic species.");
	/**
	 * Declaring amazon rainforest
	 */
	public static ForSaleSquare amazonRainforest = new ForSaleSquare("Amazon Rainforest", 500, "NotYet", 0, 0, 0, 50,
			200, 0, 0,
			" The Amazon Rainforest is the largest tropical rainforest in the world,\n spanning over 6.7 million square kilometers across nine countries in South America, including Brazil, Peru, and Colombia.\n It is home to an incredibly diverse range of flora and fauna, including many species that are found nowhere else on Earth.\n The rainforest is also an important source of oxygen and a vital component of the global climate system,\n with its trees playing a critical role in absorbing carbon dioxide from the atmosphere.\n Unfortunately, the Amazon Rainforest is under threat from deforestation, mining, and other human activities,\n which could have serious consequences for both the environment and the people who depend on it.");
	/**
	 * declaring gas forSaleSquare
	 */
	public static ForSaleSquare gas = new ForSaleSquare("Gas", 200, "NotYet", 0, 0, 100, 150, 50, 50, 100,
			" Gas is a fossil fuel that can be used as an energy source to generate electricity or provide heating for buildings.\n It is primarily composed of methane, a greenhouse gas that contributes to climate change.\n Gas is extracted from underground reserves and transported through pipelines to homes, businesses, and power plants.\n While it is a relatively clean-burning fossil fuel, it still emits carbon dioxide and other pollutants when burned,\n making it a non-renewable and unsustainable energy source in the long term.");
	/**
	 * declaring wind forSaleSquare
	 */
	public static ForSaleSquare wind = new ForSaleSquare("Wind", 500, "NotYet", 0, 0, 100, 150, 50, 50, 100,
			" Wind energy is a type of renewable energy source that harnesses the power of wind to generate electricity.\n This is typically done using wind turbines, which consist of large blades that spin when exposed to wind.\n The spinning blades drive a generator that produces electricity, which can then be used to power homes,\n businesses, and other facilities. Wind energy is clean, renewable, and emits no greenhouse gases,\n making it a popular alternative to traditional fossil fuel sources of electricity.");
	/**
	 * declaring bio forSaleSquare
	 */
	public static ForSaleSquare bio = new ForSaleSquare("Bio", 450, "NotYet", 0, 0, 100, 150, 50, 50, 100,
			" Bioenergy is a renewable energy source that is derived from biomass, such as plants or organic waste.\n It involves using biological processes, such as combustion or fermentation, to convert biomass into energy in the form of heat,\n electricity, or liquid biofuels. Bioenergy has the potential to reduce greenhouse gas emissions,\n as it can replace fossil fuels in various sectors, including transportation, industry, and heating.\n However, it is important to ensure that the production of biomass for bioenergy is\n sustainable and does not have negative impacts on food security, land use, or biodiversity.");
	/**
	 * declaring solar forSaleSquare
	 */
	public static ForSaleSquare solar = new ForSaleSquare("Solar", 475, "NotYet", 0, 0, 100, 150, 50, 50, 100,
			" Solar energy is the energy generated from the sun's radiation, which is captured through the use of solar panels or other solar technologies.\n It is a renewable and sustainable energy source that can be harnessed to generate electricity or heat.\n Solar energy is increasingly being used as an alternative to traditional fossil fuels\n due to its environmental benefits and cost-effectiveness in the long run.");
	/**
	 * declaring fusion forSaleSquare
	 */
	public static ForSaleSquare fusion = new ForSaleSquare("Fusion", 300, "NotYet", 0, 0, 100, 150, 50, 50, 100,
			" Fusion energy is a potential source of clean and renewable energy that could be derived from the fusion reactions of atomic nuclei,\n which release tremendous amounts of energy. The process involves combining light atomic nuclei,\n such as hydrogen isotopes, to form heavier nuclei, releasing energy in the process.\n While the technology to harness fusion energy is still in development,\n it has the potential to provide a virtually limitless source of energy with minimal environmental impact,\n as the fuel is abundant and the waste products are not radioactive and can be safely recycled or disposed of.");
	/**
	 * declaring fission forSaleSquare
	 */
	public static ForSaleSquare fission = new ForSaleSquare("Fission", 350, "NotYet", 0, 0, 100, 150, 50, 50, 100,
			" Fission is a nuclear energy source that involves splitting the nucleus of an atom into two smaller nuclei,\n releasing a large amount of energy in the process. This energy can be harnessed to generate electricity in nuclear power plants.\n Fission reactions can occur naturally, such as in the radioactive decay of certain elements,\n or can be artificially induced in a nuclear reactor. However, fission reactions also produce radioactive waste,\n which requires careful management and disposal to prevent harm to humans and the environment.");
	/**
	 * declaring coal forSaleSquare
	 */
	public static ForSaleSquare coal = new ForSaleSquare("Coal", 250, "NotYet", 0, 0, 100, 150, 50, 50, 100,
			" Coal is a combustible black or brownish-black sedimentary rock that is primarily composed of carbon,\n along with various other elements like hydrogen, sulfur, oxygen, and nitrogen.\n It is one of the most commonly used fossil fuel resources for generating electricity in power plants.\n Coal is formed over millions of years from the remains of plants and other organic matter that were buried under sediment and subjected to heat and pressure.\n When burned, coal releases energy in the form of heat, which can be used to generate steam and turn turbines to produce electricity.\n However, coal is a non-renewable resource and burning it also produces harmful greenhouse gases and pollutants that contribute to climate change and air pollution.");
	/**
	 * declaring oil forSaleSquare
	 */
	public static ForSaleSquare oil = new ForSaleSquare("Oil", 275, "NotYet", 0, 0, 100, 150, 50, 50, 100,
			" Oil is a fossil fuel formed from the remains of prehistoric plants and animals.\n It is found in underground reservoirs and extracted through drilling. Oil is refined to produce various fuels such as gasoline, diesel, and jet fuel,\n as well as products like plastics, chemicals, and lubricants. It is a finite resource and its combustion produces carbon dioxide emissions,\n which contribute to climate change.");

	/**
	 * declaring chnaceSquareLandedOn and setting as null
	 */
	private static ChanceSquare chanceSquareLandedOn = null;

	/**
	 * Declaring ForSaleSquare Square object renewable energy source 1
	 * 
	 */
	public static ForSaleSquare[] squares = { oil, gas, coal, solar, bio, wind, fission, fusion, mountEverest,
			mountKilamanjaro, congoRainforest, amazonRainforest };
	/**
	 * Declaring linked list
	 */
	public static List<String> list = new LinkedList<String>();

	public static void main(String[] args) {

		// set players

		/**
		 * set all players
		 */
		setActivePlayer(p1);
		setActivistOne(p1);
		setActivistTwo(p2);
		setActivistThree(p3);
		setActivistFour(p4);

	
		// get all player names
		getAllPlayerNames();

		// adding a text to ascii to make the opening title beautiful
		list.add("\n\n\n" + "  __  __                                     _ _         \n"
				+ "/_____/\\/_/\\      /_______/\\/__//_//_/\\/_______/\\/________/\\/_____/\\     /_____/\\/_______/\\/________/\\/_______/\\/_____/\\/________/\\/_____/\\ /_____/\\/_____/\\/__/\\ /__/\\/_____/\\     \r\n"
				+ "\\:::__\\/\\:\\ \\     \\__.::._\\/\\::\\| \\| \\ \\::: _  \\ \\__.::.__\\/\\::::_\\/_    \\:::__\\/\\::: _  \\ \\__.::.__\\/\\::: _  \\ \\::::_\\/\\__.::.__\\/\\:::_ \\ \\\\:::_ \\ \\:::_ \\ \\::\\ \\\\  \\ \\::::_\\/_    \r\n"
				+ " \\:\\ \\  _\\:\\ \\       \\::\\ \\  \\:.      \\ \\::(_)  \\ \\ \\::\\ \\   \\:\\/___/\\    \\:\\ \\  _\\::(_)  \\ \\ \\::\\ \\   \\::(_)  \\ \\:\\/___/\\ \\::\\ \\   \\:(_) ) )\\:\\ \\ \\ \\:(_) \\ \\::\\/_\\ .\\ \\:\\/___/\\   \r\n"
				+ "  \\:\\ \\/_/\\:\\ \\____  _\\::\\ \\__\\:.\\-/\\  \\ \\:: __  \\ \\ \\::\\ \\   \\::___\\/_    \\:\\ \\/_/\\:: __  \\ \\ \\::\\ \\   \\:: __  \\ \\_::._\\:\\ \\::\\ \\   \\: __ `\\ \\:\\ \\ \\ \\: ___\\/\\:: ___::\\ \\::___\\/_  \r\n"
				+ "   \\:\\_\\ \\ \\:\\/___/\\/__\\::\\__/\\\\. \\  \\  \\ \\:.\\ \\  \\ \\ \\::\\ \\   \\:\\____/\\    \\:\\_\\ \\ \\:.\\ \\  \\ \\ \\::\\ \\   \\:.\\ \\  \\ \\/____\\:\\ \\::\\ \\   \\ \\ `\\ \\ \\:\\_\\ \\ \\ \\ \\   \\: \\ \\\\::\\ \\:\\____/\\ \r\n"
				+ "    \\_____\\/\\_____\\/\\________\\/ \\__\\/ \\__\\/\\__\\/\\__\\/  \\__\\/    \\_____\\/     \\_____\\/\\__\\/\\__\\/  \\__\\/    \\__\\/\\__\\/\\_____\\/  \\__\\/    \\_\\/ \\_\\/\\_____\\/\\_\\/    \\__\\/ \\::\\/\\_____\\/ \r\n"
				+ "\n\n\n");
		list.add("\n Welcome " + activePlayer.getName() + " , " + activistTwo.getName() + " , "
				+ activistThree.getName() + " , " + activistFour.getName());
		list.add(
				"                  You four have been selected to carry out an essential task for the survival of our planet.\n ");
		list.add("                  Your goal is to lessen the negative effects of climate change on the planet\n");
		list.add(
				"                  you are to change and guarantee future generations a sustainable future. You will need to develop the square by\n");
		list.add(
				"                  constructing Climate Hubs and generate Climate areas by purchasing it in order to accomplish this.\n");
		list.add(
				"                  However, you can only do this once you have educated yourselves on the science of climate change\n");
		list.add(
				"                  it's up to you what sources of energy you buy, in the end you can buy oil, and make it carbon neutral, the more equipments you buy the safer the energy you produce becomes..");

		// creating the opening message
		OpeningMessage openingMessage = new OpeningMessage();
		Thread thread = new Thread(openingMessage);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Scanner scanner = new Scanner(System.in);
		String userInput;

		/**
		 * @Author Ryan Wade Starting game
		 */
		do {
			checkPlayersTurn();
			System.out.println(activePlayer.getName()
					+ "           Would you like to roll the dice ? Press y or press yes to roll or Press n to quit");
			userInput = scanner.nextLine();
			if (userInput.equalsIgnoreCase("Y") || userInput.equalsIgnoreCase("Yes")) {
				takeTurn();

				/**
				 * If current player wants to quit game will end
				 */
			} else {
				System.out.println("Would you like to quit: Press y or type yes to quit.."
						+ "\nWe will miss you! Press n to finish your turn " + activePlayer.getName());
				userInput = scanner.nextLine();
				if (userInput.equalsIgnoreCase("Y") || userInput.equalsIgnoreCase("Yes")) {
					activePlayer.setBalance(0);
					System.out.println(activePlayer.getBalance());
					break;
				}
			}

			// setting end game to true if someone runs out of money
			checkIfGameIsOver();

			// ending the turn
			turnEnd();

			checkPlayersTurn();

			/**
			 * @Author Ryan Wade checking if balance is above 0 and if end endgame boolean
			 *         is false, if conditions are not met game ends
			 */
		} while (activePlayer.getBalance() > 0 && activistOne.getBalance() > 0 && activistTwo.getBalance() > 0
				&& activistThree.getBalance() > 0 && activistFour.getBalance() > 0 && endGame != true);

		/**
		 * Display final state of play
		 */
		activistOne.displayAll();
		activistTwo.displayAll();
		activistThree.displayAll();
		activistFour.displayAll();
		finalStateOfPlay();

		System.out.println("Game over");

		scanner.close();

	}

	/**
	 * @author Conor Moore method which allows a player to take a turn
	 */
	public static void takeTurn() {

		System.out.println(activePlayer.getName() + " it is your turn");

		// Roll the dice and move the player

		activePlayer.setPosition(activePlayer.getPosition() + activePlayer.rollDice());

		// Handle passing the start square
		if (activePlayer.getPosition() > 15) {
			StartSquare.passStartSquare();
		}

		// Display the square landed on
		SquareLanded(squares, startsquare, loseOneHundred, chanceSquare, blankSquare);
		findIfNotBought();

		displayOwners();
	}

	/**
	 * @author Conor Moore Display owners of each square
	 */
	public static void displayOwners() {
		Set<String> propertiesCounted1 = new HashSet<>(); // keep track of properties that have been counted
		for (ForSaleSquare square : squares) {
			if (!propertiesCounted1.contains(square.getSquareName())) {
				System.out.println(square.getSquareName() + " is owned by " + square.getSquareOwner());
				propertiesCounted1.add(square.getSquareName());
			}
		}
	}

	/**
	 * @Author Conor Moore Method to check if the game is over
	 */
	public static void checkIfGameIsOver() {

		endGame = false;

		if (p1.getBalance() <= 0 || p2.getBalance() <= 0 || p3.getBalance() <= 0 || p4.getBalance() <= 0) {

			endGame = true;
			System.out.println("Game Over!!! Someone has won... let's find out");
			double maxBalance = Math.max(p1.getBalance(),
					Math.max(p2.getBalance(), Math.max(p3.getBalance(), p4.getBalance())));
			List<String> winners = new ArrayList<>();
			if (p1.getBalance() == maxBalance) {
				winners.add(p1.getName());
			}
			if (p2.getBalance() == maxBalance) {
				winners.add(p2.getName());
			}
			if (p3.getBalance() == maxBalance) {
				winners.add(p3.getName());
			}
			if (p4.getBalance() == maxBalance) {
				winners.add(p4.getName());
			}
			if (winners.size() == 1) {
				System.out.println("Congratulations " + winners.get(0) + " is the Winner");
			} else {
				System.out.print("Congratulations ");
				for (int i = 0; i < winners.size() - 1; i++) {
					System.out.print(winners.get(i) + " and ");
				}
				System.out.println(winners.get(winners.size() - 1) + " are the Winners");
			}
		}

	}

	/**
	 * 
	 * @param squares
	 * @param startSquare
	 * @param looseOneHundred
	 * @param chanceSquare
	 * @param blankSquare2
	 * @author Thomas Mckee
	 */
	public static void SquareLanded(ForSaleSquare[] squares, StartSquare startSquare, Tax looseOneHundred,
			ChanceSquare chanceSquare, BlankSquare blankSquare2) {
		switch (activePlayer.getPosition()) {
		case 0:
			startSquare.displayAll();
			setSquareLandedOn(null);
			break;
		case 1:
			blankSquare.displayAll();
			// returning null if a player lands on the blank square
			setSquareLandedOn(null);
			break;
		case 2:
			squares[0].displayAll();
			setSquareLandedOn(squares[0]);
			break;
		case 3:
			squares[1].displayAll();
			setSquareLandedOn(squares[1]);
			break;
		case 4:
			squares[2].displayAll();
			setSquareLandedOn(squares[2]);
			break;
		case 5:
			squares[3].displayAll();
			setSquareLandedOn(squares[3]);
			break;
		case 6:
			squares[4].displayAll();
			setSquareLandedOn(squares[4]);
			break;
		case 7:
			squares[5].displayAll();
			setSquareLandedOn(squares[5]);
			break;
		case 8:
			squares[6].displayAll();
			setSquareLandedOn(squares[6]);
			break;
		case 9:
			squares[7].displayAll();
			setSquareLandedOn(squares[7]);
			break;
		case 10:
			squares[8].displayAll();
			setSquareLandedOn(squares[8]);
			break;
		case 11:
			squares[9].displayAll();
			setSquareLandedOn(squares[9]);
			break;
		case 12:
			squares[10].displayAll();
			setSquareLandedOn(squares[10]);
			break;
		case 13:
			squares[11].displayAll();
			setSquareLandedOn(squares[11]);
			break;
		case 14:
			chanceSquare.drawChanceCard();
			setSquareChanceSquare(chanceSquare);
			break;
		case 15:
			looseOneHundred.displayAll();
			looseOneHundred.payPollutionFine();
			setSquareLooseOneHundred(looseOneHundred);

		}
	}

	/**
	 * @author Ryan Wade Ends the current player turn and saves what has occurred
	 *         while the current player has taken their turn
	 */
	public static void turnEnd() {
		if (activePlayer.equals(p1)) {
			p1 = activePlayer;
			p2 = activistTwo;
			p3 = activistThree;
			p4 = activistFour;
			System.out.println("Turn over ");
		} else if (activePlayer.equals(p2)) {
			p2 = activePlayer;
			p1 = activistOne;
			p3 = activistThree;
			p4 = activistFour;
			System.out.println("Turn over ");
		} else if (activePlayer.equals(p3)) {
			p3 = activePlayer;
			p2 = activistTwo;
			p1 = activistOne;
			p4 = activistFour;
			System.out.println("Turn over ");
		} else {
			p4 = activePlayer;
			p2 = activistTwo;
			p3 = activistThree;
			p1 = activistOne;
			System.out.println("Turn over ");
		}
		switch (activePlayer.getPosition()) {
		case 3:
			squares[0] = SquareLandedOn;
			break;
		case 4:
			squares[1] = SquareLandedOn;
			break;
		case 5:
			squares[2] = SquareLandedOn;
			break;
		case 6:
			squares[3] = SquareLandedOn;
			break;
		case 7:
			squares[4] = SquareLandedOn;
			break;
		case 8:
			squares[5] = SquareLandedOn;
			break;
		case 9:
			squares[6] = SquareLandedOn;
			break;
		case 10:
			squares[7] = SquareLandedOn;
			break;
		case 11:
			squares[8] = SquareLandedOn;
			break;
		case 12:
			squares[9] = SquareLandedOn;
			break;
		case 13:
			squares[10] = SquareLandedOn;
			break;
		case 14:
			squares[11] = SquareLandedOn;
			break;

		}

	}

	/**
	 * @Author Conor Moore finds if the square has not been bought and can the
	 *         player buy it
	 * 
	 */
	public static void findIfNotBought() {
		/**
		 * If ForSaleSquare has not been bought yet current player has chance to
		 * purchase it
		 */
		if (getSquareLandedOn() != null) {
			if (getSquareLandedOn().getSquareOwner().equalsIgnoreCase("NotYet")) {
				ForSaleSquare.purchaseSquare();

				/**
				 * If current player owns the whole source they can create a Equipment. square
				 * and also any others they own while it is their turn
				 */
			} else if (squares[0].getSquareOwner().equalsIgnoreCase(GameSystem.getActivePlayer().getName())
					&& squares[1].getSquareOwner().equalsIgnoreCase(GameSystem.getActivePlayer().getName())
					&& squares[2].getSquareOwner().equalsIgnoreCase(GameSystem.getActivePlayer().getName())) {

				ForSaleSquare.createEquipmentAndClimateHub();

			} else if ((squares[3].getSquareOwner().equalsIgnoreCase(GameSystem.getActivePlayer().getName())
					&& squares[4].getSquareOwner().equalsIgnoreCase(GameSystem.getActivePlayer().getName())
					&& squares[5].getSquareOwner().equalsIgnoreCase(GameSystem.getActivePlayer().getName()))) {
				ForSaleSquare.createEquipmentAndClimateHub();
			} else if (GameSystem.squares[6].getSquareOwner().equalsIgnoreCase(GameSystem.getActivePlayer().getName())
					&& GameSystem.squares[7].getSquareOwner()
							.equalsIgnoreCase(GameSystem.getActivePlayer().getName())) {
				ForSaleSquare.createEquipmentAndClimateHub();

				/**
				 * using instanceOf to find rent square
				 */
			} else if (getSquareLandedOn().getSquareOwner().equalsIgnoreCase(getActivePlayer().getName())) {
				System.out.println("You own this square but not all the resources");
			} else if (getSquareLandedOn() == null) {
				System.out.println("Blank Square.. nothing to do");
			} else {
				ClimateWarrior.payRentCost();
			}
		}

		setPlayerTurn(getPlayerTurn() + 1);
	}

	/**
	 * @author Ryan Wade Obtains all player names, checks they are not blank and the
	 *         same as any name previously entered
	 */
	public static void getAllPlayerNames() {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Welcome to Climate Catastrophe!\nWhat is the first players name?");
		activePlayer.setName(scanner.nextLine());
		if (activePlayer.getName().trim().equals("")) {
			System.out.println("Invalid input");
			getAllPlayerNames();
		}
		System.out.printf("\nGreat name %s, and what is player Two's name? ", activePlayer.getName());
		activistTwo.setName(scanner.nextLine());
		if (activistTwo.getName().trim().equals("")) {
			System.out.println("Invalid input");
			getAllPlayerNames();
		}
		if (activePlayer.getName().equalsIgnoreCase(activistTwo.getName())) {
			System.out.println("Names cannot be the same. Please try again.");

			activistTwo.setName("");
			getAllPlayerNames();
		}
		System.out.printf("\nCool %s, and what is player three's name? ", activePlayer.getName());
		activistThree.setName(scanner.nextLine());
		if (activistThree.getName().trim().equals("")) {
			System.out.println("Invalid input");
			getAllPlayerNames();
		}
		if (activistThree.getName().equalsIgnoreCase(activePlayer.getName())
				|| activistThree.getName().equalsIgnoreCase(activistTwo.getName())) {
			System.out.println("Names cannot be the same. Please try again");

			activePlayer.setName("");
			getAllPlayerNames();

		}
		System.out.printf("\nValid name %s, and what is player four's name? ", activePlayer.getName());
		activistFour.setName(scanner.nextLine());
		if (activistFour.getName().trim().equals("")) {
			System.out.println("Invalid input");
			getAllPlayerNames();
		}
		if (activistFour.getName().equalsIgnoreCase(activePlayer.getName())
				|| activistFour.getName().equalsIgnoreCase(activistTwo.getName())
				|| activistFour.getName().equalsIgnoreCase(activistThree.getName())) {
			System.out.println("Names cannot be the same. Please try again");

			activePlayer.setName("");
			getAllPlayerNames();
		}
	}

	/**
	 * @author Thomas Mckee Checks the current player turn Ensures players take turn
	 */
	public static void checkPlayersTurn() {
		// Determine the current player based on the player turn
		switch (getPlayerTurn()) {
		case 1:
			activePlayer = p1;
			break;
		case 2:
			activePlayer = p2;
			break;
		case 3:
			activePlayer = p3;
			break;
		case 4:
			activePlayer = p4;
			break;
		default:
			if (getPlayerTurn() > 4) {
				setPlayerTurn(1);
			}
			break;

		}

		// Update the currentPlayer variable in the Game class
		setActivePlayer(activePlayer);

		// Set the turn to the next player
		setPlayerTurn((getPlayerTurn() % 4) + 1);
	}

	/**
	 * @author Ryan Wade
	 */
	public static void finalStateOfPlay() {
		Set<String> propertiesCounted = new HashSet<>(); // keep track of properties that have been counted
		for (ForSaleSquare square : squares) {
			if (!propertiesCounted.contains(square.getSquareName())) {
				System.out.println(square.getSquareName() + " is owned by " + square.getSquareOwner());
				System.out.println("Number of Equipments: " + square.getEquipments());
				System.out.println("Number of Climate Hubs: " + square.getClimateHubs());
				propertiesCounted.add(square.getSquareName());
			}
		}
	}

	/**
	 * @return the chanceSquareLandedOn
	 */
	public static ChanceSquare getChanceSquareLandedOn() {
		return chanceSquareLandedOn;
	}

	/**
	 * @param chanceSquareLandedOn the chanceSquareLandedOn to set
	 */
	public static void setChanceSquareLandedOn(ChanceSquare chanceSquareLandedOn) {
		GameSystem.chanceSquareLandedOn = chanceSquareLandedOn;
	}

	/**
	 * 
	 * @return SquareLanded On
	 */
	public static ForSaleSquare getSquareLandedOn() {
		return SquareLandedOn;
	}

	/**
	 * Set squareLandeON
	 * 
	 * @param SquareLandedOn
	 */
	public static void setSquareLandedOn(ForSaleSquare SquareLandedOn) {
		GameSystem.SquareLandedOn = SquareLandedOn;
	}

	/**
	 * 
	 * @param chanceSquare
	 */
	public static void setSquareChanceSquare(ChanceSquare chanceSquare) {
		GameSystem.chanceSquare = chanceSquare;
	}

	/**
	 * 
	 * @param looseOneHundred
	 */
	public static void setSquareLooseOneHundred(Tax looseOneHundred) {
		GameSystem.loseOneHundred = looseOneHundred;
	}

	/**
	 * @return CurrentPlayer
	 */
	public static ClimateWarrior getActivePlayer() {
		return activePlayer;
	}

	/**
	 * Sets activePlayer
	 * 
	 * @param activePlayer
	 */
	public static void setActivePlayer(ClimateWarrior activePlayer) {
		GameSystem.activePlayer = activePlayer;
	}

	/**
	 * @return return Player 2
	 */
	public static ClimateWarrior getActivistTwo() {
		return activistTwo;
	}

	/**
	 * Set Player2
	 * 
	 * @param PlayerTwo
	 */
	public static void setActivistTwo(ClimateWarrior activistTwo) {
		GameSystem.activistTwo = activistTwo;
	}

	/**
	 * 
	 * @return player3
	 */
	public static ClimateWarrior getActivistThree() {
		return activistThree;
	}

	/**
	 * 
	 * @param PlayerThree
	 */
	public static void setActivistThree(ClimateWarrior activistThree) {
		GameSystem.activistThree = activistThree;
	}

	/**
	 * 
	 * @return player4
	 */
	public static ClimateWarrior getActivistFour() {
		return activistFour;
	}

	/**
	 * Sets player 4
	 * 
	 * @param PlayerFour
	 */
	public static void setActivistFour(ClimateWarrior activistFour) {
		GameSystem.activistFour = activistFour;
	}

	/**
	 * 
	 * @return activist one
	 */
	public static ClimateWarrior getActivistOne() {
		return activistOne;
	}

	/**
	 * Sets activist two
	 * 
	 * @param playerOne
	 */
	public static void setActivistOne(ClimateWarrior activistOne) {
		GameSystem.activistOne = activistOne;
	}

	/**
	 * 
	 * @return playerTurn
	 */
	public static int getPlayerTurn() {
		return playerTurn;
	}

	/**
	 * Set PlayerTurn
	 * 
	 * @param playerTurn
	 */
	public static void setPlayerTurn(int playerTurn) {
		GameSystem.playerTurn = playerTurn;
	}

}