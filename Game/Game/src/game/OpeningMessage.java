package game;

/**
 * 
 * @author Thomas Mckee
 * Opening message class
 *
 */
public class OpeningMessage implements Runnable {

	/**
	 * 
	 */
	@Override
	public void run() {

		// for loop
		for (String message : GameSystem.list) {

			System.out.println(message);

			try {
				if (message.equalsIgnoreCase(GameSystem.list.get(0))) {
					Thread.sleep(2000);
				} else {
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
