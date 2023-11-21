package com.fortunetellers.hashing;

import java.util.Collection;
import java.util.List;

public class ContactsMain {
	public static void main(String[] args) {
		List<Contacts> emails = ContactData.getData("email");
		List<Contacts> phone = ContactData.getData("phone");
		printData("Phone List", phone);
		printData("Emails list", emails);
		
//		List<Contacts> mergeList = new ArrayList<>();
//		for(Contacts con : emails) {
//			for(Contacts con1 : phone) {
//				if (con.getName().equals(con1.getName())) {
//					
//				}
//			}
//		}
 	}
	
	public static void printData(String header, Collection<Contacts> contacts) {
		System.out.println("-----------------------------------------");
		System.out.println(header);
		System.out.println("-----------------------------------------");
		contacts.forEach(System.out::println);
	}
}
