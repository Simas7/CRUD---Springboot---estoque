package com.estoque.lojinha.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estoque.lojinha.Model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

     
}