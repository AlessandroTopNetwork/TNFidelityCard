package com.supermarket.fedelity.card.factory;

import com.supermarket.fedelity.card.utility.GetLogger;

public class BaseFactory extends GetLogger{
	
	protected String error(String classFactory) {
		return "error in resourceToEntity/entityToResource in " + classFactory;
	}

}
