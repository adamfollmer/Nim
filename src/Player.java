import java.util.Scanner;

public class Player {
	Scanner scanner = new Scanner (System.in);
	String name;
	int currentTokens = 1;
	int currentPile = 1;
	boolean isAI = false;
	boolean isGoingFirst;
	
	public Player (String Name) {
		name = Name;
	}
	
	public void PlayerTurn () {
		System.out.println(name + ", do you want to take 1, 2, or 3?");
		//Add robust-y
		currentTokens = scanner.nextInt();
		System.out.println(name + " took " + currentTokens);
		System.out.println();
	}

	public void ClassicPlayerTurn () {
		System.out.println(name + ", do you want to pull from HEAP 1, 2, or 3");
		//Add robust-y
		int pile = scanner.nextInt();
		System.out.println(name + " selected HEAP " + pile);
		this.currentPile = pile;
		PlayerTurn();
	}


}
