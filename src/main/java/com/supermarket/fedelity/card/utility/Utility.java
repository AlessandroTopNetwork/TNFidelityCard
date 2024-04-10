package com.supermarket.fedelity.card.utility;

import java.lang.reflect.Field;
import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class Utility {

	public static String generateRandomString() {
		String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(20);
		for (int i = 0; i < 20; i++) {
			int randomIndex = random.nextInt(CHARACTERS.length());
			char randomChar = CHARACTERS.charAt(randomIndex);
			sb.append(randomChar);
		}
		return sb.toString();
	}

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
	
	public static void main(String[] args) {
		int i = 0;
		while(i<5) {
			System.out.println(generateRandomString());
			i++;
		}
		
	}

}
