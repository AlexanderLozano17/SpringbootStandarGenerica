package com.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.entity.PersonaEntity;

@Repository
public interface PersonaRepository extends BaseRepository<PersonaEntity, Long> {

//	Boolean existByDni(int dni);
	
//	@Query(value = "SELECT p FROM PersonaEntity p WHERE p.nombres LIKE %?1%")
	@Query(value = "SELECT p FROM PersonaEntity p WHERE p.nombres LIKE %:filtro% OR p.apellidos LIKE %:filtro%")
	List<PersonaEntity> search(@Param("filtro") String filtro);
	
	
	@Query(value = "SELECT p FROM PersonaEntity p WHERE p.nombres LIKE %:filtro% OR p.apellidos LIKE %:filtro%")
	Page<PersonaEntity> search(@Param("filtro") String filtro, Pageable pageable);
	
	
	@Query(
			value = "SELECT p FROM personas p WHERE p.nombres LIKE %:filtro% OR p.apellidos LIKE %:filtro%",
			nativeQuery = true
	)
	List<PersonaEntity> searchNativo(@Param("filtro") String filtro);
	

	@Query(
			value = "SELECT p FROM personas p WHERE p.nombres LIKE %:filtro% OR p.apellidos LIKE %:filtro%",
			countQuery = "SELECT count(*) FROM personas",
			nativeQuery = true
	)
	Page<PersonaEntity> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
