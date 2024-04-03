package com.supermarket.fedelity.card.entity;

public class ErrorEntity {
	
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
		return "ErrorEntity [error=" + error + ", description=" + description + "]";
	}

}
