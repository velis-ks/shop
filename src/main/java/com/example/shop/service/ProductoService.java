package com.example.shop.service;

import com.example.shop.model.Producto;
import com.example.shop.repository.ProductoRepository;
import com.example.shop.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;


    public List<Producto> getAll(){
        return productoRepository.findAll();
    }
    public Optional<Producto> getId(long id){
        return productoRepository.findById(id);
    }
}
