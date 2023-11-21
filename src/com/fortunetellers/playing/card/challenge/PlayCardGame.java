package com.fortunetellers.playing.card.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.fortunetellers.collections.Card;

public class PlayCardGame {
	public static Scanner scanner = new Scanner(System.in);
	public static Random random = new Random();

	public static void main(String[] args) {
		int play_or_exit = 0;
		while (play_or_exit != 2) {
			System.out.print("Play or Exit" + "\n 1: Play" + "\n 2: Exit" + "\n => ");
			play_or_exit = scanner.nextInt();
			switch (play_or_exit) {
			case 1:
				int whichGame = 0;
				while (whichGame != 5) {
					String msg = """
							1: Teen Patti
							2: Rummy
							3: Lucky One
							4: Heart of Seven
							5: Other
							""";
					System.out.println(msg + "Please choose the game =>");
					whichGame = scanner.nextInt();
					switch (whichGame) {
					case 1:
						playTeenPatti();
						break;
					default:
						System.out.println("Enter proper game choice");
						break;
					}
				}
				break;
			case 2:
				System.out.println("Bye bye");
				break;
			default:
				System.out.println("Enter Valid option please!!!");
				break;
			}
		}
	}

	public static void playTeenPatti() {
		int numberOfPlayers = 0;
		System.out.println("Enter the number of player");
		numberOfPlayers = scanner.nextInt();
		if (numberOfPlayers > 10) {
			System.out.println("Not more than ten player can play!!!");
			return;
		}
		Players players[] = new Players[numberOfPlayers];
		for (int i = 0; i < numberOfPlayers; i++) {
			players[i] = new Players(3); 
		}
		List<Card> teenPattiDeck = Card.getCardDeck();
		Collections.shuffle(teenPattiDeck); // Deck Shuffled
		List<Card> cutCardsList = new ArrayList<>(); 
		cutCardsList.addAll(teenPattiDeck.subList(0, random.nextInt(1, 51))); // Deck Cut made
		teenPattiDeck.removeAll(cutCardsList);
		System.out.println(teenPattiDeck.size());
		int cardRequired = numberOfPlayers * 3;
		if (cardRequired < teenPattiDeck.size()) {
			Collections.shuffle(teenPattiDeck);
			int a = 0;
			int numberOfCard = 0;
			while (a < 3) {
				for (int i = 0; i < numberOfPlayers; i++) {
					Card cardToAdd = teenPattiDeck.get(numberOfCard);
					players[i].addCard(cardToAdd);
					numberOfCard ++;
				}
				a++;
			}
			for (int i = 0; i < players.length; i++) {
				System.out.println("Player number " + i);
				players[i].printSinglePlayerCards();
			}
			Players.getTheWinner(players);
			
		} else {
			int cardNeeded = cardRequired - teenPattiDeck.size();
			teenPattiDeck.addAll(cutCardsList.subList(0, cardNeeded));
			Collections.shuffle(teenPattiDeck);
			int a = 0;
			int numberOfCard = 0;
			while (a < 3) {
				for (int i = 0; i < numberOfPlayers; i++) {
					Card cardToAdd = teenPattiDeck.get(numberOfCard);
					players[i].addCard(cardToAdd);
					numberOfCard ++;
				}
				a++;
			}
			for (int i = 0; i < players.length; i++) {
				System.out.println("Player number " + i);
				players[i].printSinglePlayerCards();
			}
			Players.getTheWinner(players);
		}
	}
}
