package com.example.shop.repository;

import com.example.shop.model.Producto;
import com.example.shop.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
