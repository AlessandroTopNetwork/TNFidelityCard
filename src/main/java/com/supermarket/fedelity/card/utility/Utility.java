package com.supermarket.fedelity.card.utility;

import java.lang.reflect.Field;

import org.springframework.stereotype.Component;

import com.supermarket.fedelity.card.entity.BaseEntity;

@Component
public class Utility {

	public boolean checkEntityIsEmpty(BaseEntity entity) throws IllegalArgumentException, IllegalAccessException {

		int count = 0;

		Field[] entityField = entity.getClass().getDeclaredFields();

		for (Field campo : entityField) {
			campo.setAccessible(true);
			if (campo.getType().equals(String.class)) {
				if (null != campo.get(entity)) {
					if (!"".equals(campo.get(entity))) {
						System.out.println(campo.getName());
						count++; // coutn of string != empty
					}
				}
			}
		}

		return count == 0 ? true : false;
	}

//	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException { // test
//
//		Cliente c = new Cliente();
//		
//		c.setNome("test me");
//
//		System.out.println(checkEntityIsEmpty(new Cliente()));
//		;
//	}

}
