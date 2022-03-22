package com.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.entity.PersonaEntity;

public interface PersonaService extends BaseService<PersonaEntity, Long> {
	
	public List<PersonaEntity> search(String filtro) throws Exception;
	
	public Page<PersonaEntity> search(String filtro, Pageable pageable) throws Exception;
}
