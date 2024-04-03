package com.supermarket.fedelity.card.dto;

public class ErrorResource {

	private String error, description;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ErrorResource [error=" + error + ", description=" + description + "]";
	}
	
}
