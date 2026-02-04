package com.example.shop.controller;

import com.example.shop.model.Producto;
import com.example.shop.model.Usuario;
import com.example.shop.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // localhost:8080/api/productos/getAll
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProductos(){
        Map<String, Object> response = new HashMap<>();
        try{
            List<Producto> listaProductos = productoService.getAll();
            response.put("code", 1);
            response.put("message", "obtenida la lista de productos");
            response.put("total", listaProductos.size());
            response.put("data", listaProductos);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e){
            response.put("code", 2);
            response.put("message", "error de ejecucion");
            response.put("cause", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

    }

    // localhost:8080/api/productos/getById/1
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable int id){
        // me voy al servicio

        Map<String, Object> response = new HashMap<>();
        try{
            Optional<Producto> producto = productoService.getProductoId(id);
            response.put("code", 1);
            response.put("message", "producto obtenido correctamente");
            response.put("total", 1);
            response.put("data", producto.get());
            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e){
            response.put("code", 1);
            response.put("message", "usuario no encontrado en la base de datos");
            response.put("total", 0);
            response.put("data", null);
            return ResponseEntity.status(HttpStatus.OK).body(response);

        }

    }


}
