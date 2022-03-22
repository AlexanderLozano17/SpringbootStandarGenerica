package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.entity.BaseEntity;
import com.api.entity.PersonaEntity;
import com.api.entity.ResponseGeneralApis;
import com.api.impl.BaseServiceImpl;

public abstract class BaseControllerApi <E extends BaseEntity, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long> {

	@Autowired
	protected S servicio;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intentre mas tarde.\"}");
		}
	}
	
	@GetMapping("/page")
	public ResponseEntity<?> findAll(Pageable pageable) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll(pageable));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intentre mas tarde.\"}");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		try {
			E entity = servicio.findById(id);
			if (entity != null) {
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseGeneralApis<>(200, "Dato listado con éxito!", entity));
			} 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseGeneralApis<>(400, "Registro no encontrado!", entity));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intentre mas tarde.\"}");
		}
	}
	
	@PostMapping
	public ResponseEntity<?> save (@RequestBody E entity) {		
		try {			
			return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intentre mas tarde.\"}");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity) {
		
//		List<String> errors = null;
//		
//		if (result.hasErrors()) {
//			errors = new ArrayList<String>();
//			for (ObjectError error : result.getAllErrors()) {
//				errors.add(error.getDefaultMessage());
//			}			
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseGeneralApis<>(400, "Errores en los datos enviados en la solicitud", errors, entity));
//		}
		
		try {
			
			E Eentity = servicio.update(id, entity);
			if (Eentity != null) {
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseGeneralApis<E>(200, "Dato actualizado con éxito!", Eentity));
			}
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseGeneralApis<E>(400,  "Registro no encontrado!", Eentity));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intentre mas tarde.\"}");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			Boolean delete = servicio.delete(id);
			if (delete) {
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseGeneralApis<>(200, "Registro eliminado con éxito!", id));
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseGeneralApis<>(400, "Registro no encontrado!", null));
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intentre mas tarde.\"}");
		}
	}
}
