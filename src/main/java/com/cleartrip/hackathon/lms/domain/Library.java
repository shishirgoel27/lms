package com.cleartrip.hackathon.lms.domain;

import java.util.Collection;
import java.util.Map;

public final class Library {

	private static Library library;

	public static Library getInstance() {
		if (library == null) {
			synchronized (Library.class) {
				if (library == null) {
					library = new Library();
				}
			}
		}
		return library;
	}

	private Map<String, Book> books;
	
	private Map<String, User> users;

	public boolean addBook(Book b) {
		if (books.containsKey(b.getTitle())) {
			return false;
		}
		books.put(b.getTitle(), b);
		return true;
	}
	
	public Book removeBook(String title) {
		return books.remove(title);
	}
	
	public Book getBook(String title) {
		return books.get(title);
	}
	
	public Collection<Book> getAllBooks() {
		return books.values();
	}
	
	public boolean addUser(User u) {
		if (users.containsKey(u.getName())) {
			return false;
		}
		users.put(u.getName(), u);
		return true;
	}
	
	public User removeUser(String name) {
		return users.remove(name);
	}
	
	public User getUser(String name) {
		return users.get(name);
	}
	
	public Collection<User> getAllUsers() {
		return users.values();
	}
}
