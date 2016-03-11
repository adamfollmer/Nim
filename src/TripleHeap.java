
public class TripleHeap extends SingleHeap {
	int[] threeHeap = { 17, 17, 17 };
	boolean classic1 = (threeHeap[0] == 0 && threeHeap[1] == 0 && threeHeap[2] == 1);
	boolean classic2 = (threeHeap[0] == 0 && threeHeap[1] == 1 && threeHeap[2] == 0);
	boolean classic3 = (threeHeap[0] == 1 && threeHeap[1] == 0 && threeHeap[2] == 0);
	boolean winCondition = false;

	public TripleHeap() {

	}

	public void ClassicHumanGame(Player player1, Player player2) {
		PrintHeapArray();
		while (winCondition == false) {
			player1.ClassicPlayerTurn(threeHeap);
			SubtractTokensClassic(player1);
			PrintHeapArray();
			WinCondition();
			if (winCondition == true) {
				System.out.println(player2.name + " lost.");
				break;
			}
			player2.ClassicPlayerTurn(threeHeap);
			SubtractTokensClassic(player2);
			PrintHeapArray();
			WinCondition();
		}
		System.out.println(player1.name + " lost.");
	}

	public void SubtractTokensClassic(Player player) {
		threeHeap[player.currentPile - 1] = threeHeap[player.currentPile - 1] - player.currentTokens;
		System.out.println(threeHeap[player.currentPile - 1] + " remain in HEAP " + player.currentPile);
	}

	public void PrintHeapArray() {
		System.out.println("HEAP 1: " + threeHeap[0]);
		System.out.println("HEAP 2: " + threeHeap[1]);
		System.out.println("HEAP 3: " + threeHeap[2]);
	}

	public void WinCondition() {
		classic1 = (threeHeap[0] == 0 && threeHeap[1] == 0 && threeHeap[2] == 1);
		classic2 = (threeHeap[0] == 0 && threeHeap[1] == 1 && threeHeap[2] == 0);
		classic3 = (threeHeap[0] == 1 && threeHeap[1] == 0 && threeHeap[2] == 0);
		if (classic1 == true) {
			winCondition = true;
		} else if (classic2 == true) {
			winCondition = true;
		} else if (classic3 == true) {
			winCondition = true;
		} else {
			winCondition = false;
		}

	}

	// BROKEN
	public void ClassicAIGameSlamDunk(Player player1) {
		PrintHeapArray();
		System.out.println(player1.name + " is going first");
		while (winCondition == false) {
			player1.ClassicPlayerTurn(threeHeap);
			SubtractTokensClassic(player1);
			System.out.println();
			PrintHeapArray();
			WinCondition();
			if (winCondition == true) {
				System.out.println(computer.name + " lost.");
				break;
			}
			computer.ClassicAIPlayerTurn(threeHeap);
			SubtractTokensClassic(computer);
			System.out.println(computer.name + " took " + computer.currentTokens + " from HEAP " + computer.currentPile);
			System.out.println();
			PrintHeapArray();
			WinCondition();
		}
		System.out.println(player1.name + " lost.");
	}
}
