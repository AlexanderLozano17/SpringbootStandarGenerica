package com.api.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.entity.BaseEntity;
import com.api.repository.BaseRepository;
import com.api.service.BaseService;

public abstract class BaseServiceImpl <E extends BaseEntity, ID extends Serializable> implements BaseService<E, ID>{

	protected BaseRepository<E, ID> baseRepository;
	
	public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
		super();
		this.baseRepository = baseRepository;
	}

	@Override
	@Transactional
	public List<E> findAll() throws Exception {		
		try {
			List<E> entities = baseRepository.findAll();
			return entities;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	@Transactional
	public Page<E> findAll(Pageable pageable) throws Exception {		
		try {
			Page<E> entities = baseRepository.findAll(pageable);
			return entities;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public E findById(ID id) throws Exception {
		try {
			if (baseRepository.existsById(id)) {
				Optional<E> entityOptional = baseRepository.findById(id);
				return entityOptional.get();
			} 
			return null;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public E save(E entity) throws Exception {
		try {
			entity = baseRepository.save(entity);
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public E update(ID id, E entity) throws Exception {
		try {
			Optional<E> entityOptional = baseRepository.findById(id);
			if (baseRepository.existsById(id)) {
				E entityUpdate = entityOptional.get();
				entityUpdate = baseRepository.save(entity);
				return entityUpdate;
			}
			return null;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Boolean delete(ID id) throws Exception {
		try {
			if (baseRepository.existsById(id)) {
				baseRepository.deleteById(id);
				return true;
			}
			return false;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
