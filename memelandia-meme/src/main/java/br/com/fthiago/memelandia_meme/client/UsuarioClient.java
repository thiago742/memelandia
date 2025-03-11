package br.com.fthiago.memelandia_meme.client;

import br.com.fthiago.memelandia_meme.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "memelandia-usuario", path = "/usuarios")
public interface UsuarioClient {
    @GetMapping("/{id}")
    ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id);
}