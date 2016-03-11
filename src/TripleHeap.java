
public class TripleHeap extends SingleHeap {
	int[] threeHeap = {17,17,17};
	boolean classic1;
	boolean classic2;
	boolean classic3;
	
	public TripleHeap () {
		
	}
	
	public void ClassicHumanGame(Player player1, Player player2) {
		while (ClassicOr()){
			player1.ClassicPlayerTurn();
			PlayerLogic(player1);
			PrintHeapArray();
			if (threeHeap[0] < 1 && threeHeap[1] < 1 && threeHeap[2] < 1) {
				System.out.println(player2.name + " lost.");
				break;
			}
			player2.ClassicPlayerTurn();
			PlayerLogic(player2);
			PrintHeapArray();
		}
		System.out.println(player1.name + " lost.");
	}
	
	public void PlayerLogic(Player player) {
		switch (player.currentPile) {
		case 1:
			threeHeap[0] = threeHeap[0] - player.currentTokens;
			System.out.println(threeHeap[0] + " remain in HEAP " + player.currentPile);
			break;
		case 2:
			threeHeap[1] = threeHeap[1] - player.currentTokens;
			System.out.println(threeHeap[1] + " remain in HEAP " + player.currentPile);
			break;
		case 3:
			threeHeap[2] = threeHeap[2] - player.currentTokens;
			System.out.println(threeHeap[2] + " remain in HEAP " + player.currentPile);
		default:
			break;
		}
	}
	
	public void PrintHeapArray () {
		System.out.println("HEAP 1: " + threeHeap[0]);
		System.out.println("HEAP 2: " + threeHeap[1]);
		System.out.println("HEAP 3: " + threeHeap[2]);
	}
	
	public boolean ClassicOr () {
		classic1 = (threeHeap[0] > 1 && threeHeap[1] < 1 && threeHeap [2] < 1);
		classic2 = (threeHeap[0] < 1 && threeHeap[1] > 1 && threeHeap [2] < 1);
		classic3 = (threeHeap[0] < 1 && threeHeap[1] < 1 && threeHeap [2] > 1);
		return false;
	}
	
	//BROKEN
		public void ClassicAIGameSlamDunk() {
			System.out.println(player1.name + " is going first");
			while (threeHeap[0] > 1 && threeHeap[1] > 1 && threeHeap[2] > 1){
				player1.ClassicPlayerTurn();
				PlayerLogic(player1);
				if (threeHeap[0] > 1 && threeHeap[1] > 1 && threeHeap[2] > 1) {
					System.out.println(computer.name + " lost.");
					break;
				}
			}
		}
}
