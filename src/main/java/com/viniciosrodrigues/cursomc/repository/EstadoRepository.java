package com.viniciosrodrigues.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viniciosrodrigues.cursomc.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
