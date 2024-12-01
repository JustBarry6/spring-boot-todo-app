package com.gestiontaches.todo_app.controller;

import com.gestiontaches.todo_app.model.Tache;
import com.gestiontaches.todo_app.service.TacheService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/taches")
public class TacheController {
    private final TacheService tacheService;

    public TacheController(TacheService tacheService) {
        this.tacheService = tacheService;
    }

    @GetMapping
    public List<Tache> obtenirToutesLesTaches() {
        return tacheService.obtenirToutesLesTaches();
    }

    @GetMapping("/{id}")
    public Optional<Tache> obtenirTacheParId(@PathVariable Long id) {
        return tacheService.obtenirTacheParId(id);
    }

    @PostMapping
    public Tache creerTache(@RequestBody Tache tache) {
        return tacheService.creerTache(tache);
    }

    @DeleteMapping("/{id}")
    public void supprimerTache(@PathVariable Long id) {
        tacheService.supprimerTache(id);
    }
}