package com.novel.exception;

public class UserNotFound extends Exception {
	private static final long serialVersionUID = 1L;

	public UserNotFound(String msg) {
		super(msg);
	}
}
