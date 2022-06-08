package com.idat.herreraparedes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.herreraparedes.model.MallaCurricular;

@Repository
public interface IMallaCurricularRepository extends JpaRepository<MallaCurricular, Integer>{

}
