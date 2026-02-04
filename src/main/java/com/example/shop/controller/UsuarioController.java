package com.example.shop.controller;

import com.example.shop.model.Usuario;
import com.example.shop.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    // Devlarar los endpoints que admitiran info

    @Autowired
    // el acceso al servicio
    private UsuarioService usuarioService;

    // localhost:8080/api/usuarios/getAll
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){

        // HashMap = clave valor (no deja de ser un json)
        List<Usuario> listaResultante = usuarioService.getAll();
        Map<String, Object> response = new HashMap<>();
        response.put("code", 1);
        response.put("message", "obtenida la lista de resultados");
        response.put("total", listaResultante.size());
        response.put("data", listaResultante);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        // me voy al servicio


        Optional<Usuario> usuario = usuarioService.getUserId(id);
        Map<String, Object> response = new HashMap<>();
        if (usuario.isPresent()){
            response.put("code", 1);
            response.put("message", "usuario obtenido correctamente");
            response.put("total", 1);
            response.put("data", usuario.get());

        } else {
            response.put("code", 1);
            response.put("message", "usuario no encontrado en la base de datos");
            response.put("total", 0);
            response.put("data", null);

        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario){

        Map<String, Object> response = new HashMap<>();
        Usuario usuarioCreado = usuarioService.createUsuario(usuario);

        response.put("code", 1);
        response.put("message", "usuario creado correctamente");
        response.put("total", 1);
        response.put("data", usuarioCreado);
        return ResponseEntity.status(HttpStatus.OK).body(response);


    }

    @GetMapping("/findCorreo")
    public ResponseEntity<?> getUseByEmail(@RequestParam String correo) {

        // nos vamos al servicio -> de ahi al repositorio
        Usuario usuarioEncntrado = usuarioService.getUsuarioMail(correo);

        Map<String, Object> response = new HashMap<>();

        if(usuarioEncntrado == null){

            response.put("code", 1);
            response.put("message", "usuario no encontrado");
            response.put("total", 0);
            response.put("data", null);
            return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(response);

        } else {

            response.put("code", 1);
            response.put("message", "usuario encontrado correctamente en la base de datos");
            response.put("total", 1);
            response.put("data", usuarioEncntrado);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable int id, @RequestBody Usuario usuario){
        Map<String, Object> response = new HashMap<>();

        try{
            // aqui insero la logiga de negocio
            // busco si el usuario existe
            // reutilizo el metodo mas arriba de buscar a un usuario
            Optional<Usuario> usuarioBusqueda = usuarioService.getUserId(id);
            // usuario isPresent = true
            // usuario isPresent = false
            // de momento forzamos
            Usuario usuarioEncontrado = usuarioBusqueda.get(); // asumo usuario existe si o si
            usuarioEncontrado.setCorreo(usuario.getCorreo());
            usuarioEncontrado.setNombre(usuario.getNombre());
            usuarioEncontrado.setPassword(usuario.getPassword());
            Usuario usuarioActualizado = usuarioService.updateUsuario(usuarioEncontrado);
            response.put("code", 1);
            response.put("message", "usuario actualizado correctamente en la base de datos");
            response.put("total", 1);
            response.put("data", usuarioActualizado);
            return ResponseEntity.ok(response);

        } catch (NoSuchElementException | DataIntegrityViolationException e){
            response.put("code", 2);
            response.put("message", "error de ejecucion");
            response.put("cause", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
