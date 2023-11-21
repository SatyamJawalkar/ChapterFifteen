package com.fortunetellers.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class StartCollection {
	public static void main(String[] args) {
		String name[] = { "Satyam", "Pramod", "Abhishek", "Rohan", "Vikas" };
		List<String> list = new ArrayList<>(List.of(name));
		System.out.println(list);

		System.out.println("-".repeat(50));
		list.addAll(Arrays.asList("Sanif", "Prince", "Muhhemad"));
		System.out.println(list);

		System.out.println("-".repeat(50));
		list.removeIf(s -> s.startsWith("P"));
		System.out.println(list);
		
		//********************COLLECTION WITH ARRAYLIST**********************
		System.out.println("\n"+"-".repeat(25) + "COLLECTION WITH ARRAYLIST" + "-".repeat(25));
		String name1[] = { "Satyam", "Pramod", "Abhishek", "Rohan", "Vikas" };
		Collection<String> lis1 = new ArrayList<>(List.of(name1));
		System.out.println(lis1);

		System.out.println("-".repeat(50));
		lis1.addAll(Arrays.asList("Sanif", "Prince", "Muhhemad"));
		System.out.println(lis1);

		System.out.println("-".repeat(50));
		lis1.removeIf(s -> s.startsWith("P"));
		System.out.println(lis1);

		
		//********************COLLECTION WITH TREESET**********************
		System.out.println("\n"+"-".repeat(25) + "COLLECTION WITH TREESET" + "-".repeat(25));
		String name2[] = { "Satyam", "Pramod", "Abhishek", "Rohan", "Vikas" };
		Collection<String> list2 = new TreeSet<>();
		list2.addAll(Arrays.asList(name2));
		System.out.println(list2);

		System.out.println("-".repeat(50));
		list2.addAll(Arrays.asList("Sanif", "Prince", "Muhhemad"));
		System.out.println(list2);

		System.out.println("-".repeat(50));
		list2.removeIf(s -> s.startsWith("P"));
		System.out.println(list2);
		
		// ********************COLLECTION WITH HASHSET**********************
		System.out.println("\n" + "-".repeat(25) + "COLLECTION WITH HASHSET" + "-".repeat(25));
		String name3[] = { "Satyam", "Pramod", "Abhishek", "Rohan", "Vikas" };
		Collection<String> list3 = new HashSet<>();
		list3.addAll(Arrays.asList(name3));
		System.out.println(list3);

		System.out.println("-".repeat(50));
		list3.addAll(Arrays.asList("Sanif", "Prince", "Muhhemad"));
		System.out.println(list3);

		System.out.println("-".repeat(50));
		list3.removeIf(s -> s.startsWith("P"));
		System.out.println(list3);

	}
}
