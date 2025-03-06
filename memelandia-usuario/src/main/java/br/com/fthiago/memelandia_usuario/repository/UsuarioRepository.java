package br.com.fthiago.memelandia_usuario.repository;

import br.com.fthiago.memelandia_usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
