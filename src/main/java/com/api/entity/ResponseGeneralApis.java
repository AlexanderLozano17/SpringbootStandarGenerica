package com.api.entity;

import java.util.List;

public class ResponseGeneralApis<E> {
	
	private int status;
	private String message;	
	private List<String> errors;
	private E data;
	
	public ResponseGeneralApis() {
		super();
	}

	public ResponseGeneralApis(int status, String message, List<String> errors, E data) {
		super();
		this.status = status;
		this.message = message;
		this.errors = errors;
		this.data = data;
	}

	public ResponseGeneralApis(int status, String message, E data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}
	
	
	
}
