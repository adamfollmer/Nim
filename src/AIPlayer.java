
public class AIPlayer extends Player {
	boolean winnable;

	public AIPlayer(String Name) {
		super(Name);
	}

	public void PlayerTurn(Player player) {
		switch (player.currentTokens) {
		case 1:
			currentTokens = 3;
			break;
		case 2:
			currentTokens = 2;
			break;
		case 3:
			currentTokens = 1;
			break;
		default:
			System.out.println("BAD!");
			break;
		}
	}

	public void AIChanceTurn(int heap) {
		if (heap >= 4) {
			AIChanceTurnSwitch(rand.nextInt(3));
		} else if (heap == 3) {
			currentTokens = 2;
		} else if (heap == 2) {
			currentTokens = 1;
		} else {
			System.out.println("BAD");
		}
	}

	public void AIChanceTurnSwitch(int random) {
		switch (random) {
		case 0:
			currentTokens = 1;
			break;
		case 1:
			currentTokens = 2;
			break;
		default:
			currentTokens = 3;
			break;
		}
	}

	public void ClassicAIPlayerTurn(int[] heap) {
		if (heap[0] > 0) {
			currentPile = 1;
			if (heap[0] > 3) {
				AIChanceTurnSwitch(rand.nextInt(3));
			} else if (heap[0] <= 3) {
				CheckWin(heap, 2, 1, 0);
				if (winnable != true) {
					currentTokens = heap[0];
				}

			}
		} else if (heap[1] > 0) {
			currentPile = 2;
			if (heap[1] > 3) {
				AIChanceTurnSwitch(rand.nextInt(3));
			} else if (heap[1] <= 3) {
				CheckWin(heap, 0, 2, 1);
				if (winnable != true) {
					currentTokens = heap[1];
				}
			}
		} else {
			currentPile = 3;
			if (heap[2] > 3) {
				AIChanceTurnSwitch(rand.nextInt(3));
			} else if (heap[2] <= 3) {
				CheckWin(heap, 1, 2, 2);
				if (winnable != true) {
					currentTokens = heap[2];
				}
			}
		}
	}

	public void CheckWin(int[] heap, int h0, int h1, int h2) {
		if (heap[h0] == 0 && heap[h1] == 0) {
			if (heap[h2] == 3) {
				currentTokens = 1;
				winnable = true;
			} else {
				currentTokens = 1;
				winnable = true;
			}
		}
	}

}
