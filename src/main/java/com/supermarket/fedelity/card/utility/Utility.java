package com.supermarket.fedelity.card.utility;

import java.lang.reflect.Field;

import org.springframework.stereotype.Component;

@Component
public class Utility {

	    public static <T, D> D convertToDto(T entity, Class<D> dtoClass) {
	        try {
	            D dto = dtoClass.getDeclaredConstructor().newInstance();
	            for (Field field : entity.getClass().getDeclaredFields()) {
	                field.setAccessible(true);
	                Field dtoField = dtoClass.getDeclaredField(field.getName());
	                dtoField.setAccessible(true);
	                dtoField.set(dto, field.get(entity));
	            }
	            return dto;
	        } catch (Exception e) {
	            throw new RuntimeException("Errore durante la conversione da entità a DTO", e);
	        }
	    }


//	public boolean checkEntityIsEmpty(BaseEntity entity) throws IllegalArgumentException, IllegalAccessException {
//
//		int count = 0;
//
//		Field[] entityField = entity.getClass().getDeclaredFields();
//
//		for (Field campo : entityField) {
//			campo.setAccessible(true);
//			if (campo.getType().equals(String.class)) {
//				if (null != campo.get(entity)) {
//					if (!"".equals(campo.get(entity))) {
//						System.out.println(campo.getName());
//						count++; // coutn of string != empty
//					}
//				}
//			}
//		}
//
//		return count == 0 ? true : false;
//	}

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
