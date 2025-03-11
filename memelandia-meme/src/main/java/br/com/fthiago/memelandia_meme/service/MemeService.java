package br.com.fthiago.memelandia_meme.service;

import br.com.fthiago.memelandia_meme.client.CategoriaMemeClient;
import br.com.fthiago.memelandia_meme.client.UsuarioClient;
import br.com.fthiago.memelandia_meme.dto.CategoriaMemeDTO;
import br.com.fthiago.memelandia_meme.dto.UsuarioDTO;
import br.com.fthiago.memelandia_meme.entity.Meme;
import br.com.fthiago.memelandia_meme.repository.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MemeService {
    @Autowired
    private MemeRepository memeRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private CategoriaMemeClient categoriaMemeClient;

    public Meme novoMeme(Meme meme) {
        if (meme.getUsuarioId() == null || meme.getCategoriaMemeId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "IDs de usuário e categoria são obrigatórios");
        }

        try {
            // Verifica se o usuário existe
            UsuarioDTO usuario = usuarioClient.buscarUsuarioPorId(meme.getUsuarioId()).getBody();

            // Verifica se a categoria existe
            CategoriaMemeDTO categoria = categoriaMemeClient.buscarCategoriaPorId(meme.getCategoriaMemeId()).getBody();

            // Salva o meme
            return memeRepository.save(meme);
        } catch (FeignException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário ou categoria não encontrado", e);
        } catch (FeignException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao comunicar com outro microsserviço", e);
        }
    }

    public List<Meme> listaTodosMemes() {
        return memeRepository.findAll();
    }
}
