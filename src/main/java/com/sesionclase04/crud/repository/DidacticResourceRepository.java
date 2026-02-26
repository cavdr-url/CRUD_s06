package com.sesionclase04.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sesionclase04.crud.model.DidacticResource;

@Repository
public interface DidacticResourceRepository extends JpaRepository<DidacticResource, Long> {
    // Métodos CRUD ya incluidos por Spring Data JPA
}