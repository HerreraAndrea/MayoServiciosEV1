package com.idat.herreraparedes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.herreraparedes.model.Universidad;

@Repository
public interface IUniversidadRepository extends JpaRepository<Universidad, Integer>{

}
