package br.com.fthiago.memelandia_categoria.client;

import br.com.fthiago.memelandia_categoria.entity.CategoriaMeme;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "memelandia-categoria", path = "/categorias")
public interface CategoriaMemeClient {
    @GetMapping("/{id}")
    CategoriaMeme buscarCategoriaPorId(@PathVariable Long id);
}