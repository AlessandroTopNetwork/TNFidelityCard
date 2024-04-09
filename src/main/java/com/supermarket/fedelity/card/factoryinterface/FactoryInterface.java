package com.supermarket.fedelity.card.factoryinterface;

import java.util.List;

public interface FactoryInterface { // generic interface to override basic method for factory dto
	
	<T> T entityToRequest(T entity);
	
	<T> List<T> entityToRequest(List<T> entity);
	
	<T> T requestToEntity(T entity);
	
	<T> List<T> requestToEntity(List<T> entity);

}
