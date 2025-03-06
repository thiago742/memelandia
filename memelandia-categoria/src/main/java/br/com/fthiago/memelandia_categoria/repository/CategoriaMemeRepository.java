package br.com.fthiago.memelandia_categoria.repository;

import br.com.fthiago.memelandia_categoria.entity.CategoriaMeme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaMemeRepository extends JpaRepository<CategoriaMeme, Long> {
}
