package br.com.fthiago.memelandia_meme.repository;

import br.com.fthiago.memelandia_meme.entity.Meme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemeRepository extends JpaRepository<Meme, Long> {
}
