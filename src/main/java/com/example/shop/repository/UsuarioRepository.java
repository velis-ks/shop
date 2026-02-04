package com.example.shop.repository;

import com.example.shop.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // NO SE ESCRIBEN, TE LOS DA EL JPA REPOSITORY
    // solo se definen las firmas del metodo
    // public abs

    // Existe un metodo fibdByCorreo en el repositorio? NO, entonce redifinimos
    // Le tenemos que dar el nombre de la misma variable que ya tenemos definima en controller

    public abstract Usuario findByCorreo(String correo);

}
