package com.example.shop.service;

import com.example.shop.model.Usuario;
import com.example.shop.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    // Metodos con logica que llaman al repositorio
    // Autowird significa que el repositorio se autoinstancia solo
    @Autowired
    private UsuarioRepository repository;


    public List<Usuario> getAll() {
        // select * from usuarios
        return repository.findAll();
    }

    public Optional<Usuario> getUserId(long id){
        return repository.findById(id);
    }

    public Usuario createUsuario(Usuario usuario) {
        // puede dar error si correo repetido:
        // analizo: si el usuario esta en BBDD, retorno null
        // si no esta en BBDD, insertamos usuario
        return repository.save(usuario);
    }

    public Usuario getUsuarioMail(String correo){
        return repository.findByCorreo(correo);
    }

    public Usuario updateUsuario(Usuario usuario){
        // Si llego a este punto no tengo dudas de que el usuario existe
        return repository.save(usuario);
    }
}
