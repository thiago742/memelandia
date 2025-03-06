package br.com.fthiago.memelandia_usuario.controller;

import br.com.fthiago.memelandia_usuario.entity.Usuario;
import br.com.fthiago.memelandia_usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Usuario> buscaUsuarios() {
        return usuarioService.listaTodosUsuarios();
    }

    @PostMapping
    public Usuario novoUsuario(@RequestBody Usuario usuario) {
        return usuarioService.novoUsuario(usuario);
    }
}