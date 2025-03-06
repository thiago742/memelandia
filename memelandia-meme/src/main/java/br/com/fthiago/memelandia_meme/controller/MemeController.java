package br.com.fthiago.memelandia_meme.controller;

import br.com.fthiago.memelandia_meme.entity.Meme;
import br.com.fthiago.memelandia_meme.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memes")
public class MemeController {
    @Autowired
    private MemeService memeService;

    @GetMapping
    public List<Meme> buscaMemes() {
        return memeService.listaTodosMemes();
    }

    @PostMapping
    public Meme novoMeme(@RequestBody Meme meme) {
        return memeService.novoMeme(meme);
    }
}