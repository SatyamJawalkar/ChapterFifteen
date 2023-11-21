package com.fortunetellers.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.fortunetellers.collections.Card.Suit;

public class ChallengeOnPrevious {
	public static void main(String[] args) {
		Card c1;
		c1 = Card.getNumeriCard(Suit.DIAMOND, 8);
		System.out.println(c1.toString());

		c1 = Card.getFaceCard(Suit.HEART, 'k');
		System.out.println(c1.toString());

//		List<Card> deckCard = Card.getCardDeck();
//		int count = 0;
//		for (Card card : deckCard) {
//			count++;
//			System.out.print(card.toString());
//			if (count == 13) {
//				System.out.println();
//				count = 0;
//			}
//		}
		
		//Card.printDeck(deckCard, "All Cards", 4);
		
		Card cardArray[] = new Card[13];
		Card aceOfHeartCard = Card.getFaceCard(Card.Suit.HEART, 'A');
		Arrays.fill(cardArray, aceOfHeartCard); // THIS DOES NOTHING HERE THE LIST IS EMPTY
		Card.printDeck(Arrays.asList(cardArray), "Ace of Heart", 1);
		
		List<Card> aceOfHeart = new ArrayList<>(52);
		Collections.fill(aceOfHeart, aceOfHeartCard);
		Card.printDeck(aceOfHeart,"Ace of Heart with fill()",1);
		
		List<Card> aceOfHeart1 = Collections.nCopies(13, aceOfHeartCard);
		Card.printDeck(aceOfHeart1,"Ace of Heart with nCopies()",1);
		
		List<Card> kingOfClubList = Collections.nCopies(13, Card.getFaceCard(Card.Suit.CLUB, 'K'));
		Card.printDeck(kingOfClubList, "King of Club with nCpies()", 1);
		
		Collections.addAll(aceOfHeart, cardArray);
		Collections.addAll(aceOfHeart, cardArray);
		Card.printDeck(aceOfHeart, "Ace of Heart with addAll", 2);
		
		Collections.copy(aceOfHeart, kingOfClubList); // IF ACEOFHEART IS LESS THAN THE KING OF CLUB IT GIVE ERROR 
		Card.printDeck(aceOfHeart, "King of Club with copy()",2); 
		
		List<Card> fullDeckList = Card.getCardDeck();
		Collections.shuffle(fullDeckList);
		Card.printDeck(fullDeckList, "Full deck with shuffle()", 4);
		
		Collections.sort(fullDeckList,Comparator.comparing(Card::rank)
				.thenComparing(Card::suit));
		Card.printDeck(fullDeckList, "Full deck with sort()", 13);
		
		Collections.reverse(fullDeckList);
		Card.printDeck(fullDeckList, "Full deck with reverse()", 4);
		
		List<Card> subCardList = new ArrayList<>(fullDeckList.subList(4, 8));
		Card.printDeck(subCardList, "King Sublist with subList() of List", 1);
		
		List<Card> subCardList2 = new ArrayList<>(fullDeckList.subList(16, 20));
		Card.printDeck(subCardList2, "Tens sublist with subList() of List", 1);
		
		int sublistIndex = Collections.indexOfSubList(fullDeckList, subCardList2);
		System.out.println("Index of Tens sublist= " + sublistIndex);
		System.out.println("ContainsAll before shuffle in List = " + fullDeckList.containsAll(subCardList));
		
		Collections.shuffle(fullDeckList);
		sublistIndex = Collections.indexOfSubList(fullDeckList, subCardList2);
		System.out.println("Index of Tens sublist after shuffle= " + sublistIndex);
		System.out.println("ContainsAll After shuffle in List = " + fullDeckList.containsAll(subCardList));
		
		//METHOD TO FIND NOT SAME VALUES IN LISTS.
		Boolean is_not_sameBoolean = Collections.disjoint(fullDeckList, kingOfClubList);
		System.out.println("Is not Same => " + is_not_sameBoolean);
		
		boolean is_not_sameBoolean2 = Collections.disjoint(kingOfClubList, aceOfHeart1);
		System.out.println("Is not same=> " + is_not_sameBoolean2);
		
		
		//THIRD PART AND MORE METHODS OF COLLECTIONS
		
		Card tensOfClubCard = Card.getNumeriCard(Card.Suit.CLUB,10);
		Comparator<Card> sorting = Comparator.comparing(Card::suit).thenComparing(Card::rank);
		Comparator<Card> sorting1 = Comparator.comparing(Card::suit);
		int indexFoundCard = Collections.binarySearch(fullDeckList,tensOfClubCard ,sorting1);
		System.out.println("Binary Search Index => " + indexFoundCard);
		
		List<Card> fullDeck2 = Card.getCardDeck();
		Collections.replaceAll(fullDeck2,tensOfClubCard, aceOfHeartCard);
		Card.printDeck(fullDeck2, "After replaceAll()", 4);
		
		System.out.println("Ace of Hearts =>" + Collections.frequency(fullDeck2, aceOfHeartCard));
		
		System.out.println("Min =>" + Collections.min(fullDeck2,sorting));
		System.out.println("Min =>" + Collections.max(fullDeck2,sorting));
		
		fullDeck2.sort(sorting);
		Card.printDeck(fullDeck2, "After Sort() ", 4);
		
		List<Card> copiedCards = new ArrayList<>(Card.getCardDeck().subList(0, 13));
		Collections.rotate(copiedCards, 4);
		System.out.println("Unrotated: " + Card.getCardDeck().subList(0,13));
		System.out.println("Rotated : " + 4 + ":" + copiedCards);
		
		List<Card> copiedCards1 = new ArrayList<>(Card.getCardDeck().subList(0, 13));
		Collections.rotate(copiedCards1, -2);
		System.out.println("Unrotated: " + Card.getCardDeck().subList(0,13));
		System.out.println("Rotated : " + -2 + ":" + copiedCards1);
		
		//MANUALLY SWAP
		
		copiedCards1 = new ArrayList<>(Card.getCardDeck().subList(0, 13));
		Card.printDeck(copiedCards1, "Before Swap() not reversed", 1);
		for (int i = 0; i < copiedCards1.size() / 2; i++) {
			Collections.swap(copiedCards1, i, copiedCards1.size() - 1 - i);
		}
		Card.printDeck(copiedCards1, "Manual Swap() reversed", 1);
		
		
		//REVERSE USING REVERSED()
		Collections.reverse(copiedCards1);
		Card.printDeck(copiedCards1, "reversed()", 1);
	}
}
