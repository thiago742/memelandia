package br.com.fthiago.memelandia_meme.client;

import br.com.fthiago.memelandia_categoria.entity.CategoriaMeme;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "memelandia-categoria", path = "/categorias")
public interface CategoriaMemeClient {
    @GetMapping("/{id}")
    ResponseEntity<CategoriaMeme> buscarCategoriaPorId(@PathVariable Long id);
}
