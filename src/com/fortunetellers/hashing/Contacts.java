package com.fortunetellers.hashing;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Contacts {
	private String name;
	private Set<String> phones = new HashSet<>();
	private Set<String> emails = new HashSet<>();

	public Contacts(String name, long phone, String emails) {
		this.name = name;
	        if (emails != null) {
	            this.emails.add(emails);
	        }
	        if (phone > 0) {
	            String p = String.valueOf(phone);
	            p = "(%s) %s-%s".formatted(p.substring(0, 3), p.substring(3, 6),
	                    p.substring(6));
	            phones.add(p);
	        }
	}

	public Contacts(String name, String emails) {
		this(name,0,emails);
	}

	public Contacts(String name, long phones) {
		this(name,phones,null);
	}

	public Contacts(String name) {
		this(name,null);
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Name: " + name + " Email: " + emails + " Phones: " + phones + "Hashcode: " + hashCode();
	}

	private Contacts mergeContactData(Contacts contacts) {
		Contacts newContacts = new Contacts(name);
		newContacts.emails = new HashSet<>(this.emails);
		newContacts.phones = new HashSet<>(this.phones);
		newContacts.emails.addAll(contacts.emails);
		newContacts.phones.addAll(contacts.phones);
		return newContacts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emails, name, phones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Contacts other = (Contacts) obj;
		return Objects.equals(emails, other.emails) && Objects.equals(name, other.name)
				&& Objects.equals(phones, other.phones);
	}

	
}
