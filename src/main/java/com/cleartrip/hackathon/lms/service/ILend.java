package com.cleartrip.hackathon.lms.service;

import com.cleartrip.hackathon.lms.domain.User;

public interface ILend {
	
	public static final int BORROW_LIMIT = 5;
	
	default boolean isWithinLimit(User user) {
		return user.getBooks().size() < BORROW_LIMIT;
	}

}
