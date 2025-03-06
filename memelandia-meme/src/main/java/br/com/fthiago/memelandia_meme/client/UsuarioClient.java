package br.com.fthiago.memelandia_meme.client;

import br.com.fthiago.memelandia_usuario.entity.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "memelandia-usuario", path = "/usuarios")
public interface UsuarioClient {
    @GetMapping("/{id}")
    ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id);
}