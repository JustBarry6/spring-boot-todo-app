package com.gestiontaches.todo_app.controller;

import com.gestiontaches.todo_app.model.Categorie;
import com.gestiontaches.todo_app.service.CategorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {
    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    public List<Categorie> obtenirToutesLesCategories() {
        return categorieService.obtenirToutesLesCategories();
    }

    @PostMapping
    public Categorie creerCategorie(@RequestBody Categorie categorie) {
        return categorieService.creerCategorie(categorie);
    }
}
