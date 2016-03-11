
public class SingleHeap {
	int heap = 17;
	AIPlayer computer = new AIPlayer("Computer");
	boolean printThis = true;

	public SingleHeap() {

	}

	public void CreatePlayers() {

	}

	public void HumanGame(Player player1, Player player2) {
		while (heap > 1) {
			player1.PlayerTurn();
			player1.CheckLegalMove(heap);
			heap = SubtractTokens(player1);
			if (heap == 1) {
				System.out.println(player2.name + " lost.");
				printThis = false;
				break;
			}
			player2.PlayerTurn();
			player2.CheckLegalMove(heap);
			heap = SubtractTokens(player2);
		}
		if (printThis == true) {
			System.out.println(player1.name + " lost.");
		}
	}

	public int SubtractTokens(Player player) {
		System.out.println(player.name + " took " + player.currentTokens);
		System.out.println();
		heap = heap - player.currentTokens;
		System.out.println(heap + " remain");
		System.out.println();
		return heap;
	}

	public void AIGameSlamDunk(Player player1) {
		System.out.println(player1.name + " is going first.");
		while (heap > 1) {
			player1.PlayerTurn();
			player1.CheckLegalMove(heap);
			heap = SubtractTokens(player1);
			if (heap == 1) {
				System.out.println(computer.name + " lost.");
				printThis = false;
				break;
			}
			computer.PlayerTurn(player1);
			heap = SubtractTokens(computer);
		}
		if (printThis == true) {
			System.out.println(player1.name + " lost.");
		}
	}
//Maybe have to change the logic here. AI will also try to go below 0.
	public void AIGameChance(Player player1) {
		System.out.println(computer.name + " is going first.");
		while (heap > 1) {
			computer.AIChanceTurn(heap);
			heap = SubtractTokens(computer);
			if (heap == 1) {
				System.out.println(player1.name + " lost.");
				printThis = false;
				break;
			}
			player1.PlayerTurn();
			player1.CheckLegalMove(heap);
			heap = SubtractTokens(player1);
		}
		if (printThis == true) {
			System.out.println(computer.name + " lost.");
		}
	}
}