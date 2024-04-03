package com.supermarket.fedelity.card.entity;

public class BaseEntity {
	
	private ErrorEntity error;

	public ErrorEntity getError() {
		return error;
	}

	public void setError(ErrorEntity error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "BaseEntity [error=" + error + "]";
	}

}
