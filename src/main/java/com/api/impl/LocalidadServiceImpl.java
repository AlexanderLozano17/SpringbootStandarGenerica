package com.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entity.LocalidadEntity;
import com.api.repository.BaseRepository;
import com.api.repository.LocalidadRepository;
import com.api.service.LocalidadService;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<LocalidadEntity, Long> implements LocalidadService {

	@Autowired
	private LocalidadRepository localidadRepository;
	
	public LocalidadServiceImpl(BaseRepository<LocalidadEntity, Long> baseRepository) {
		super(baseRepository);
	}

}
