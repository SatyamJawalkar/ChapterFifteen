package com.fortunetellers.playing.card.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fortunetellers.collections.Card;

public class Players implements Comparable<Players> {
	public static int PLAYER_ID = -1;
	private int id;
	private List<Card> listOfCards;
	private int rank = 0;

	public Players(int size) {
		id = ++PLAYER_ID;
		listOfCards = new ArrayList<>(size);
	}

	public List<Card> getListOfCards() {
		return listOfCards;
	}

	public void calculateRank() {
		for (Card card : listOfCards) {
			rank += card.rank();
		}
	}

	public int getRank() {
		return rank;
	}

	public boolean addCard(Card cards) {
		listOfCards.add(cards);
		return true;
	}

	public int getId() {
		return id;
	}	
	
	public void printSinglePlayerCards() {
		listOfCards.forEach(s -> System.out.print(s));
		System.out.println();
		calculateRank();
	}

	public static void printAllPlayersCard(Players playerList[]) {
		for (int i = 0; i < playerList.length; i++) {
			System.out.println("Player number " + i + 1);
			playerList[i].listOfCards.forEach(s -> System.out.print(s));
		}
	}

	public static void getTheWinner(Players players[]) {
		Arrays.sort(players);
		System.out.println("The Winner of Game is Player => " + players[1].getId());
	}

	@Override
	public int compareTo(Players o) {
		return Integer.compare(o.rank,this.rank);
	}
}
