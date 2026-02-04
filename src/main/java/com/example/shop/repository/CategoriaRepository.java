package com.example.shop.repository;

import com.example.shop.model.Categoria;
import com.example.shop.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
