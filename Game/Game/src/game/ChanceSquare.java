package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * 
 * @author Thomas Mckee, Naved Nadaf
 *
 */
public class ChanceSquare {
	
	// instance vars
	private String name;
	private List<String> chances;

	public ChanceSquare(String name) {
		this.name = name;
		this.chances = new ArrayList<>();
		chances.add("All players have to lose 300");
		chances.add("All players gain 300");
		chances.add("You gain 300");
		chances.add("You lose 300");
	}

	public void drawChanceCard() {
		System.out.println("You have landed on chance");
		Random random = new Random();
		int index = random.nextInt(chances.size());
		String card = chances.get(index);

		switch (card) {
		case "All players have to lose 300":
			System.out.println("All players lose 300!");
			GameSystem.getActivistOne().setBalance(GameSystem.getActivistOne().getBalance() - 300);
			System.out.println(GameSystem.getActivistOne().getName() + " your new balance is: "
					+ GameSystem.getActivistOne().getBalance());
			// fining activist two
			GameSystem.getActivistTwo().setBalance(GameSystem.getActivistTwo().getBalance() - 300);
			System.out.println(GameSystem.getActivistTwo().getName() + " your new balance is: "
					+ GameSystem.getActivistTwo().getBalance());
			// fining the third activist
			GameSystem.getActivistThree().setBalance(GameSystem.getActivistThree().getBalance() - 300);
			System.out.println(GameSystem.getActivistThree().getName() + " your new balance is: "
					+ GameSystem.getActivistThree().getBalance());
			// fining the fourth
			GameSystem.getActivistFour().setBalance(GameSystem.getActivistFour().getBalance() - 300);
			System.out.println(GameSystem.getActivistFour().getName() + " your new balance is: "
					+ GameSystem.getActivistFour().getBalance());
			break;
		case "All players gain 300":
			System.out.println("All players earn 300!");
			GameSystem.getActivistOne().setBalance(GameSystem.getActivistOne().getBalance() + 300);
			System.out.println(GameSystem.getActivistOne().getName() + " your new balance is: "
					+ GameSystem.getActivistOne().getBalance());
			// paying activist two
			GameSystem.getActivistTwo().setBalance(GameSystem.getActivistTwo().getBalance() + 300);
			System.out.println(GameSystem.getActivistTwo().getName() + " your new balance is: "
					+ GameSystem.getActivistTwo().getBalance());
			// paying the third activist
			GameSystem.getActivistThree().setBalance(GameSystem.getActivistThree().getBalance() + 300);
			System.out.println(GameSystem.getActivistThree().getName() + " your new balance is: "
					+ GameSystem.getActivistThree().getBalance());
			// paying the fourth
			GameSystem.getActivistFour().setBalance(GameSystem.getActivistFour().getBalance() + 300);
			System.out.println(GameSystem.getActivistFour().getName() + " your new balance is: "
					+ GameSystem.getActivistFour().getBalance());
			break;
		case "You gain 300":
			GameSystem.getActivePlayer().setBalance(GameSystem.getActivePlayer().getBalance() + 300);
			System.out.println(GameSystem.getActivePlayer().getName() + " you gained 300! New balance is : "
					+ GameSystem.getActivePlayer().getBalance());
			break;
		case "You lose 300":
			GameSystem.getActivePlayer().setBalance(GameSystem.getActivePlayer().getBalance() - 300);
			System.out.println(GameSystem.getActivePlayer().getName() + " you got fined 300 and your new balance is : "
					+ GameSystem.getActivePlayer().getBalance());
			break;
		}
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
