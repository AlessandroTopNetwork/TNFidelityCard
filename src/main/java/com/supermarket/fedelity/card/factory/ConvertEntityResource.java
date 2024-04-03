package com.supermarket.fedelity.card.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermarket.fedelity.card.dto.BaseResource;
import com.supermarket.fedelity.card.dto.ErrorResource;
import com.supermarket.fedelity.card.entity.BaseEntity;
import com.supermarket.fedelity.card.entity.ErrorEntity;

@Component
public class ConvertEntityResource {

	@Autowired
	private ModelMapper modelMapper;
	
	// resource

	public BaseResource entityToResource(BaseEntity entity, Class<?> classe) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if (null == entity) {
			BaseResource resource = (BaseResource) classe.getDeclaredConstructor().newInstance();
			resource.setError(new ErrorResource());
			resource.getError().setError("Record not found 404");
			resource.getError().setDescription("no comment");
			return resource;
		} else {
			return (BaseResource) modelMapper.map(entity, classe);
		}
	}

	public List<BaseResource> listEntityToResource(List<BaseEntity> listEntity, Class<?> classe) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		List<BaseResource> listResource = new ArrayList<BaseResource>();
		for (BaseEntity entity : listEntity) {
			listResource.add(entityToResource(entity, classe));
		}
		return listResource;
	}

	// entity
	
	public BaseEntity resourceToEntity(BaseResource resource, Class<?> classe) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if (null == resource) {
			BaseEntity entity = (BaseEntity) classe.getDeclaredConstructor().newInstance();
			entity.setError(new ErrorEntity());
			entity.getError().setError("Record not found 404");
			entity.getError().setDescription("no comment");
			return entity;
		} else {
			return (BaseEntity) modelMapper.map(resource, classe);
		}
	}
	
	public List<BaseResource> listResourceToEntity(List<BaseEntity> listEntity, Class<?> classe) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		List<BaseResource> listResource = new ArrayList<BaseResource>();
		for (BaseEntity entity : listEntity) {
			listResource.add(entityToResource(entity, classe));
		}
		return listResource;
	}

}
