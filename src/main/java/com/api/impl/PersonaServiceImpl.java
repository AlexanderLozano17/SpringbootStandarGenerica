package com.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.entity.PersonaEntity;
import com.api.repository.BaseRepository;
import com.api.repository.PersonaRepository;
import com.api.service.PersonaService;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<PersonaEntity, Long> implements PersonaService{

	@Autowired
	private PersonaRepository personaRepository;

	public PersonaServiceImpl(BaseRepository<PersonaEntity, Long> baseRepository) {
		super(baseRepository);
	}

	@Override
	public List<PersonaEntity> search(String filtro) throws Exception {
		try {			
			List<PersonaEntity> personas = personaRepository.search(filtro);
			return personas;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Page<PersonaEntity> search(String filtro, Pageable pageable) throws Exception {
		try {			
			Page<PersonaEntity> personas = personaRepository.search(filtro, pageable);
			return personas;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	
}
