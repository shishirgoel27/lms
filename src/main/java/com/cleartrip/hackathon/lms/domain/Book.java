package com.cleartrip.hackathon.lms.domain;

public class Book {

	private String title;

	private String author;

	public Book(Builder b) {
		this.title = b.title;
		this.author = b.author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	private static class Builder {

		private String title;
		private String author;

		public Builder withTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder withAuthor(String author) {
			this.author = author;
			return this;
		}

		public Book build() {
			return new Book(this);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Book) {
			Book b = (Book) obj;
			return this.title.equalsIgnoreCase(b.getTitle());
		}
		return false;
	}

}
