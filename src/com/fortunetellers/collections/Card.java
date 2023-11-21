package com.fortunetellers.collections;

import java.util.ArrayList;
import java.util.List;


public record Card(Suit suit, String face, int rank) {

	enum Suit {
		CLUB, DIAMOND, HEART, SPADE;

		public char getImage() {
			return (new char[] { 9827, 9830, 9829, 9824 })[this.ordinal()];
		}
	}

	@Override
	public String toString() {
		int index = face.equals("10") ? 2 : 1;
		String faceString = face.substring(0, index);
		return "%s%c(%d) ".formatted(faceString, suit.getImage(), rank);
	}

	public static Card getNumeriCard(Suit suit, Integer num) {
		if (num > 1 && num < 11) {
			return new Card(suit, String.valueOf(num), num - 2);
		}
		System.out.println("Invalid numeric Card selected");
		return null;
	}

//	public static Card getFaceCard(Suit suit, String faceString) {
//		if (faceString.isBlank()) {
//			System.out.println("Not should be empty");
//			return null;
//		} else {
//			return switch (faceString) {
//			case "K", "k" -> new Card(suit, "K", 13);
//			case "J", "j" -> new Card(suit, "J", 11);
//			case "Q", "q" -> new Card(suit, "Q", 12);
//			case "A", "a" -> new Card(suit, "A", 14);
//			default -> throw new IllegalArgumentException("Unexpected value: " + faceString);
//			};
//		}
//	}

	public static Card getFaceCard(Suit suit, char abbrive) {
		String cap1 = "JQKA";
		int index1 = cap1.indexOf(Character.toUpperCase(abbrive));
		if (index1 > -1) {
			return new Card(suit, cap1.substring(index1), index1 + 9);
		}
		System.out.println("Invalid card value");
		return null;
	}

	public static List<Card> getCardDeck() {
		List<Card> deckCards = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (int i = 2; i <= 10; i++) {
				deckCards.add(Card.getNumeriCard(suit, i));
			}
			for (char ar : new char[] { 'J', 'Q', 'K', 'A' }) {
				deckCards.add(Card.getFaceCard(suit, ar));
			}
		}
		return deckCards;
	}
	
	public static void printDeck(List<Card> deck,String discription, int row) {
		System.out.println("----------------------");
		if(discription != null) {
			System.out.println(discription);
		}
		int cardInRows = deck.size() / row;
//		int count = 0;
//		for (Card card : deck) {
//			if (count == cardInRows) {
//				System.out.println();
//				count = 0;
//			}
//			System.out.print(card.toString());
//			count ++;
//		}
		for (int i = 0; i < row; i++) {
			int startIndex = i * cardInRows;
			int endIndex = startIndex + cardInRows;
			deck.subList(startIndex, endIndex).forEach(c -> System.out.print(c));
			System.out.println();
		}
	}
	
	public static void defualtPrint(List<Card> list,String commect) {
		printDeck(list, commect, 4);
	}

}
