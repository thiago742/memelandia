package br.com.fthiago.memelandia_meme.service;

import br.com.fthiago.memelandia_categoria.entity.CategoriaMeme;
import br.com.fthiago.memelandia_meme.client.CategoriaMemeClient;
import br.com.fthiago.memelandia_meme.client.UsuarioClient;
import br.com.fthiago.memelandia_meme.entity.Meme;
import br.com.fthiago.memelandia_meme.repository.MemeRepository;
import br.com.fthiago.memelandia_usuario.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemeService {
    @Autowired
    private MemeRepository memeRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private CategoriaMemeClient categoriaMemeClient;

    public Meme novoMeme(Meme meme) {
        // Verifica se o usuário existe
        ResponseEntity<Usuario> usuarioResponse = usuarioClient.buscarUsuarioPorId(meme.getUsuarioId());
        if (!usuarioResponse.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        // Verifica se a categoria existe
        ResponseEntity<CategoriaMeme> categoriaResponse = categoriaMemeClient.buscarCategoriaPorId(meme.getCategoriaMemeId());
        if (!categoriaResponse.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Categoria não encontrada");
        }

        // Salva o meme
        return memeRepository.save(meme);
    }

    public List<Meme> listaTodosMemes() {
        return memeRepository.findAll();
    }
}
