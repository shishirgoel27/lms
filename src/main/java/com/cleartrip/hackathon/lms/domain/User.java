package com.cleartrip.hackathon.lms.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String name;
	
	private List<Book> books = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return new ArrayList<Book>(books);
	}

	public void setBooks(List<Book> books) {
		this.books.clear();
		this.books.addAll(books);
	}
	
}
