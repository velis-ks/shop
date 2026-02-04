package com.example.shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "usuarios")
    public class Usuario {
        @Id
        @GeneratedValue
        private long id;

        @Column
        private String nombre;
        private String correo;
        private String password;

        // Relaciones -> OnetoOne, OnetoMany, ManytoMany

        public Usuario(String nombre, String correo, String password) {
            this.nombre = nombre;
            this.correo = correo;
            this.password = password;
        }
}
