package com.cleartrip.hackathon.lms.service;

import java.util.List;

import com.cleartrip.hackathon.lms.domain.Book;
import com.cleartrip.hackathon.lms.domain.User;

/**
 * @author shishir
 *
 */
public interface ILibraryManager {
	
	/**
	 * Add books to the Library
	 * 
	 * @param books
	 * @return books which are successfully added
	 */
	public List<Book> addBooks(List<Book> books);
	
	/**
	 * Register users in the Library Management System
	 * 
	 * @param users
	 * @return users which are successfully added
	 */
	public List<User> addUsers(List<User> users);
	
	/**
	 * Lend a book with given title to a user with given username
	 * 
	 * @param title
	 * @param userName
	 * @return number of books with the user after lending
	 */
	public int lendBook(String title, String userName);
	
	/**
	 * Return the book owned by a registered user with given username to the library 
	 * 
	 * @param book
	 * @param userName
	 * @return number of books with the user after returning
	 */
	public int returnBook(Book book, String userName);
	
	/**
	 * Search books by title or author or both
	 * 
	 * @param title
	 * @param author
	 * @return 
	 */
	public List<Book> searchBooks(String title, String author);
	
	/**
	 * Search registered users by name
	 * 
	 * @param name
	 * @return
	 */
	public List<User> searchUser(String name);

}
