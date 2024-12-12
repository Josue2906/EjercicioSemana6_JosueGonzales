package com.example.EjercicioSemana6_JosueGonzales.controller;

import com.example.EjercicioSemana6_JosueGonzales.model.Producto;
import com.example.EjercicioSemana6_JosueGonzales.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService service;

    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", service.listarProductos());
        return "listar_productos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("producto", new Producto());
        return "formulario_productos";
    }

    @PostMapping
    public String guardarProducto(@ModelAttribute Producto producto) {
        service.guardarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Producto producto = service.buscarPorID(id)
                .orElseThrow(() -> new IllegalArgumentException("ID no válido: " + id));
        model.addAttribute("producto", producto);
        return "formulario_productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        service.eliminarProducto(id);
        return "redirect:/productos";
    }
}
