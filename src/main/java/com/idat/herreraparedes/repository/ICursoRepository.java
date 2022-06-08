package com.idat.herreraparedes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.herreraparedes.model.Curso;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Integer> {

}
