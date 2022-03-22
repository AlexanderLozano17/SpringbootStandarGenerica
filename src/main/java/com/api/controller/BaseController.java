package com.api.controller;

import java.io.Serializable;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.entity.BaseEntity;

public interface BaseController <E extends BaseEntity, ID extends Serializable> {

	public ResponseEntity<?> findAll();
	public ResponseEntity<?> findAll(Pageable pageable);
	public ResponseEntity<?> findById(@PathVariable ID id);
	public ResponseEntity<?> save(@RequestBody E entity);
	public ResponseEntity<?> update(@PathVariable ID id, @RequestBody E entity);
	public ResponseEntity<?> delete(@PathVariable ID id);
}
