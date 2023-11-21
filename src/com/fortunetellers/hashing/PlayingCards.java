package com.fortunetellers.hashing;

import java.util.Objects;

public class PlayingCards {
	private String suitString;
	private String faceString;
	private int internalHash;

	public PlayingCards(String suitString, String faceString) {
		super();
		this.suitString = suitString;
		this.faceString = faceString;
		this.internalHash = 1;
	}

	@Override
	public String toString() {
		return faceString + " of " + suitString;
	}

	

//	@Override
//	public int hashCode() {
//		return Objects.hash(faceString, suitString);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		PlayingCards other = (PlayingCards) obj;
//		return Objects.equals(faceString, other.faceString) && Objects.equals(suitString, other.suitString);
//	}
	
	

	
//	@Override
//	public int hashCode() {
//		return (suitString.equals("Heart") ? 11 : 12);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		System.out.println("---> Checking playing card equality");
//		return true;
//	}
	
	
	
	
}
