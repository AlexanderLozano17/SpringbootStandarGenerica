package com.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entity.AutorEntity;
import com.api.repository.AutorRepository;
import com.api.repository.BaseRepository;
import com.api.service.AutorService;

@Service
public class AutorServiceImpl extends BaseServiceImpl<AutorEntity, Long> implements AutorService {

	@Autowired
	private AutorRepository autorRepository;
	
	public AutorServiceImpl(BaseRepository<AutorEntity, Long> baseRepository) {
		super(baseRepository);
	}

}
