package com.fortunetellers.hashing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hashing {
	public static void main(String[] args) {
		String aText = "Hello";
		String bText = "Hello";
		String cText = String.join("l","He","lo");
		String dText = "He".concat("llo");
		String eText = "hello";
		
		List<String> listOfString = List.of(aText,bText,cText,dText,eText);
		listOfString.forEach(s -> System.out.println(s.hashCode()));
		
		Set<String> mySet = new HashSet<>(listOfString);
		
		System.out.println("mySet =>" + mySet);
		System.out.println("# of elements" + mySet.size());
		
		
		for (String string : mySet) {
			System.out.println(string + ": ");
			for (int i = 0; i < listOfString.size(); i++) {
				if (string == listOfString.get(i)) {
					System.out.print(i + ", ");
				}
			}
			System.out.println(" ");
		}
		
		PlayingCards aceHearts = new PlayingCards("Heart", "Ace");
		PlayingCards kingClub = new PlayingCards("Club", "King");
		PlayingCards queenShades = new PlayingCards("Shades", "Queen");
		
		List<PlayingCards> playingCards = List.of(aceHearts,kingClub,queenShades);
		playingCards.forEach(s -> System.out.println(s + ": " + s.hashCode()));
		
		Set<PlayingCards> mySet2 = new HashSet<>();
		for (PlayingCards playingCards2 : playingCards) {
			if (!mySet2.add(playingCards2)) {
				System.out.println("Found duplicate for : " + playingCards2.toString());
			}
		}
		System.out.println(mySet2);
		}
}
