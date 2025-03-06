package br.com.fthiago.memelandia_categoria.controller;

import br.com.fthiago.memelandia_categoria.entity.CategoriaMeme;
import br.com.fthiago.memelandia_categoria.service.CategoriaMemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaMemeController {

    @Autowired
    private CategoriaMemeService categoriaMemeService;

    // Endpoint para listar todas as categorias
    @GetMapping
    public List<CategoriaMeme> getAllCategorias() {
        return categoriaMemeService.findAll();
    }

    // Endpoint para buscar categoria por ID
    @GetMapping("/{id}")
    public CategoriaMeme getCategoriaPorId(@PathVariable Long id) {
        return categoriaMemeService.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    @PostMapping
    public CategoriaMeme criarCategoria(@RequestBody CategoriaMeme categoriaMeme) {
        return categoriaMemeService.save(categoriaMeme);
    }
}
