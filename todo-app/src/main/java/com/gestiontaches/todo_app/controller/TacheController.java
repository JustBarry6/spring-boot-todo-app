package com.gestiontaches.todo_app.controller;

import com.gestiontaches.todo_app.model.Tache;
import com.gestiontaches.todo_app.model.Priorite;
import com.gestiontaches.todo_app.service.TacheService;
import org.springframework.validation.annotation.Validated;
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
    public Tache creerTache(@Validated @RequestBody Tache tache) {
        return tacheService.creerTache(tache);
    }

    @PutMapping("/{id}")
    public Tache updateTache(@PathVariable Long id, @Validated @RequestBody Tache tache) {
        return tacheService.updateTache(id, tache);
    }

    @DeleteMapping("/{id}")
    public void supprimerTache(@PathVariable Long id) {
        tacheService.supprimerTache(id);
    }

    @GetMapping("/categorie/{categorieId}")
    public List<Tache> obtenirTachesParCategorie(@PathVariable Long categorieId) {
        return tacheService.obtenirTachesParCategorie(categorieId);
    }

    @GetMapping("/priorite/{priorite}")
    public List<Tache> obtenirTachesParPriorite(@PathVariable Priorite priorite) {
        return tacheService.obtenirTachesParPriorite(priorite);
    }
}