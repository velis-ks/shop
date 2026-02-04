package com.example.shop.service;

import com.example.shop.model.Producto;
import com.example.shop.model.Usuario;
import com.example.shop.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public List<Producto> getAll(){
        return repository.findAll();
    }

    public Optional<Producto> getProductoId(long id){
        return repository.findById(id);
    }

}
