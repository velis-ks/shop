package com.example.shop.repository;


import com.example.shop.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // CRUD
    // escribe la firma del metodo -> SELECT correo
    // tengo metodo que retorne el usuario por correo?

    Usuario findByCorreo(String correo);

    // HQL
    // SQL -> nativeQuery = true
    // @Query(value = "SELECT u FROM Usuario u WHERE u.salario>:salario")
    // List<Usuario> getUsuarioSalario(@Param("salario") int salario);

}
