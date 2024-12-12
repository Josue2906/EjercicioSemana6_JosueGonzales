package com.example.EjercicioSemana6_JosueGonzales.service;

import com.example.EjercicioSemana6_JosueGonzales.model.Producto;
import com.example.EjercicioSemana6_JosueGonzales.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    public List<Producto> listarProductos() {
        return repository.findAll();
    }

    public void guardarProducto(Producto producto) {
        repository.save(producto);
    }

    public Optional<Producto> buscarPorID(Integer id) {
        return repository.findById(id);
    }

    public void eliminarProducto(Integer id) {
        repository.deleteById(id);
    }
}
