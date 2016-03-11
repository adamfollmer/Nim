import java.util.Random;
import java.util.Scanner;

public class Player {
	Scanner scanner = new Scanner(System.in);
	Random rand = new Random();
	String name;
	int currentTokens = 1;
	int currentPile = 1;
	boolean isAI = false;
	boolean isGoingFirst;

	public Player(String Name) {
		name = Name;
	}

	public void PlayerTurn() {
		System.out.println(name + ", do you want to take 1, 2, or 3?");
		currentTokens = scanner.nextInt();
		while (currentTokens < 1 || currentTokens >= 4) {
			System.out.println("Not a legal move, try again");
			System.out.println();
			PlayerTurn();
		}
	}

	public void ClassicPlayerTurn(int[] threeHeap) {
		System.out.println(name + ", do you want to pull from HEAP 1, 2, or 3");
		if (CheckLegalPile(threeHeap)) {
			PlayerTurn();
			CheckLegalClassic(threeHeap);
		}
	}

	public void CheckLegalMove(int heap) {
		if (heap == 3) {
			if (currentTokens != 1 || currentTokens != 2) {
				System.out.println("Not a legal move, try again.");
				System.out.println();
				PlayerTurn();
			}
		} else if (heap == 2) {
			if (currentTokens != 1) {
				System.out.println("Not a legal move, try again.");
				System.out.println();
				PlayerTurn();
			}
		}
	}

	public void CheckLegalClassic(int[] threeHeap) {
		if (currentTokens == 3 && (threeHeap[currentPile - 1] == 1 || threeHeap[currentPile - 1] == 2)) {
			System.out.println("Not a legal move, try again.");
			System.out.println();
			ClassicPlayerTurn(threeHeap);
		} else if (currentTokens == 2 && threeHeap[currentPile - 1] == 1) {
			System.out.println("Not a legal move, try again.");
			System.out.println();
			ClassicPlayerTurn(threeHeap);
		}
	}

	public boolean CheckLegalPile(int[] threeHeap) {
		int pile = scanner.nextInt();
		System.out.println(name + " selected HEAP " + pile);
		if (pile < 1 || pile >= 4 || threeHeap[pile - 1] == 0) {
			System.out.println("Not a valid pile, pick another");
			System.out.println();
			ClassicPlayerTurn(threeHeap);
			return false;
		} else {
			currentPile = pile;
			return true;
		}
	}

}
