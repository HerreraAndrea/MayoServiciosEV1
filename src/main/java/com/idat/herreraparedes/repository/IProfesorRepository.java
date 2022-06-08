package com.idat.herreraparedes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.herreraparedes.model.Profesor;
@Repository
public interface IProfesorRepository extends JpaRepository<Profesor, Integer>{

}
