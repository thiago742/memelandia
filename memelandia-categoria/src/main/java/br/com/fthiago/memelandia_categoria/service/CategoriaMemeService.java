package br.com.fthiago.memelandia_categoria.service;

import br.com.fthiago.memelandia_categoria.entity.CategoriaMeme;
import br.com.fthiago.memelandia_categoria.repository.CategoriaMemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaMemeService {

    @Autowired
    private CategoriaMemeRepository categoriaMemeRepository;

    // Buscar categoria por ID
    public Optional<CategoriaMeme> findById(Long id) {
        return categoriaMemeRepository.findById(id);
    }

    // Listar todas as categorias
    public List<CategoriaMeme> findAll() {
        return categoriaMemeRepository.findAll();
    }

    public CategoriaMeme save(CategoriaMeme categoriaMeme) {
        return categoriaMemeRepository.save(categoriaMeme);
    }
}
