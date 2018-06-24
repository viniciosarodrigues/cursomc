package com.viniciosrodrigues.cursomc.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6695363618876886566L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
