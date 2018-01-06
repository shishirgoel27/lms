package com.cleartrip.hackathon.lms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cleartrip.hackathon.lms.domain.Book;
import com.cleartrip.hackathon.lms.domain.Library;
import com.cleartrip.hackathon.lms.domain.User;
import com.cleartrip.hackathon.lms.service.ILend;
import com.cleartrip.hackathon.lms.service.ILibraryManager;

public class LibraryManagerImpl implements ILibraryManager, ILend {

	private Library library = Library.getInstance();

	public List<Book> addBooks(List<Book> books) {
		final List<Book> booksAdded = new ArrayList<>();
		books.forEach(b -> {
			if (library.addBook(b)) {
				booksAdded.add(b);
			}
		});
		return booksAdded;
	}

	public List<User> addUsers(List<User> users) {
		final List<User> usersAdded = new ArrayList<>();
		users.forEach(u -> {
			if (library.addUser(u)) {
				usersAdded.add(u);
			}
		});
		return usersAdded;
	}

	public int lendBook(String title, String userName) {
		User user = library.getUser(userName);
		Book b = library.getBook(title);
		if (user != null && b != null && isWithinLimit(user)) {
			List<Book> userBooks = user.getBooks();
			userBooks.add(b);
			user.setBooks(userBooks);
			return userBooks.size();
		}
		return user.getBooks().size();
	}

	public int returnBook(Book book, String userName) {
		User user = library.getUser(userName);
		List<Book> userBooks = user.getBooks();
		if (user != null && userBooks.contains(book)) {
			userBooks.remove(book);
			user.setBooks(userBooks);
			library.addBook(book);
			userBooks.size();
		}
		return user.getBooks().size();
	}

	public List<Book> searchBooks(String title, String author) {
		List<Book> searchList1 = new ArrayList<>();
		List<Book> searchList2 = new ArrayList<>();
		if (title != null && title.length() > 0) {
			searchList1.add(library.getBook(title));
		} if (author != null && author.length() > 0) {
			searchList2 = library.getAllBooks().stream().filter(b -> b.getAuthor().equalsIgnoreCase(author))
					.collect(Collectors.toList());
		}
		return searchList1.isEmpty() ? searchList2
				: (searchList2.isEmpty()) ? searchList1
						: searchList2.stream().filter(b -> searchList1.contains(b)).collect(Collectors.toList());

	}

	public List<User> searchUser(String name) {
		List<User> searchUsers = new ArrayList<>();
		User user = library.getUser(name);
		if (user != null) {
			searchUsers.add(user);
		}
		return searchUsers;
	}

}
