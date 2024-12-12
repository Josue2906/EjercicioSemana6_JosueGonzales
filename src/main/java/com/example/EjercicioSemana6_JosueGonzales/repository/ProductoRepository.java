package com.example.EjercicioSemana6_JosueGonzales.repository;

import com.example.EjercicioSemana6_JosueGonzales.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}

