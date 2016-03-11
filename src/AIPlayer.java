
public class AIPlayer extends Player{

	public AIPlayer(String Name) {
		super(Name);
	}
	public void PlayerTurn (Player player) {
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
		default :
				System.out.println("BAD!");
				break;
		}
		System.out.println(name + " took " + currentTokens);
		System.out.println();
	}
	public void ClassicPlayerTurn (Player player) {
		
	}

}
