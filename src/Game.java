import java.util.Random;
import java.util.Scanner;

public class Game {
	Player player1 = new Player("Player 1");
	Player player2 = new Player("Player 2");
	Scanner scanner = new Scanner(System.in);
	Random rand = new Random();
	SingleHeap single = new SingleHeap();
	TripleHeap triple = new TripleHeap();

	public Game() {

	}

	public void NewGame() {
		PrintRules();
		System.out.println("What is your name?");
		player1.name = (scanner.nextLine());
		System.out.println("Do you want to play with (1) another person or (2) the computer?");
		if (scanner.nextInt() == 1) {
			GetPlayer2();
			PlayerSingleOrTriple();
		} else {
			System.out.println("Do you want to stand a chance? (1) Yes or (2) No");
			int hardnessLevel = scanner.nextInt();
			AISingleOrTriple(hardnessLevel);
		}
	}

	public void GetPlayer2() {
		System.out.println("What is the name of player 2?: ");
		scanner.nextLine();
		player2.name = scanner.nextLine();
	}

	public void PlayerSingleOrTriple() {
		System.out.println("Do you want to play the (1) single heap or the (2) classical version with three heaps?");
		int gameMode = scanner.nextInt();
		System.out.println();
		if (gameMode == 1) {
			DetermineOrder(1);
		} else {
			DetermineOrder(2);
		}
	}

	public void DetermineOrder(int version) {
		RandomPlayerGame();
		if (player1.isGoingFirst == true && version == 1) {
			single.HumanGame(player1, player2);
		} else if (player2.isGoingFirst == true && version == 1) {
			single.HumanGame(player2, player1);
		} else if (player1.isGoingFirst == true && version == 2) {
			triple.ClassicHumanGame(player1, player2);
		} else if (player2.isGoingFirst == true && version == 2) {
			triple.ClassicHumanGame(player2, player1);
		} else {
			System.out.println("Invalid input, restarting.");
			NewGame();
		}
	}
	
	public void RandomPlayerGame() {
		if (rand.nextInt(2) == 0) {
			player1.isGoingFirst = true;
		} else {
			player2.isGoingFirst = true;
		}
	}
	
	public void AISingleOrTriple(int hardnessLevel) {
		System.out.println("Do you want to play the (1) single heap or the (2) classical version with three heaps?");
		int gameMode = scanner.nextInt();
		System.out.println();
		if (gameMode == 1 && hardnessLevel == 1) {
			single.AIGameChance(player1);
		} else if (gameMode == 1 && hardnessLevel == 2) {
			single.AIGameSlamDunk(player1);
		} else if (gameMode == 2 && hardnessLevel == 1) {
			System.out.println("This mode isn't quite working, so you will stand a chance of winning!");
			triple.ClassicAIGameSlamDunk(player1);
		} else if (gameMode == 2 && hardnessLevel == 2) {
			triple.ClassicAIGameSlamDunk(player1);
		} else {
			System.out.println("One of those selections wasn't valid, try again.");
			NewGame();
		}
	}

	public void SingleVersionRules() {
		System.out.println("For single version:  ");
		System.out.println("We will start with 17. You can subtract 1, 2, or 3 at a time.");
		System.out.println("Try not to be left with one");
	}

	public void TripleVersionRules() {
		System.out.println("For triple version: ");
		System.out.println("We will start with three piles, each with 17. You can subtract 1,2, or 3 at a time");
		System.out.println("Try TO be left with one");
	}
	
	public void PrintRules() {
		System.out.println("Welcome to NIM!");
		System.out.println();
		SingleVersionRules();
		System.out.println();
		TripleVersionRules();
		System.out.println();
	}
}
